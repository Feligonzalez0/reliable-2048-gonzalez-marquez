
"""
Fuzzer por mutacion para Board(String), con informe compacto.

    python mutation_fuzzer.py          # 100 mutantes
    python mutation_fuzzer.py 300      # 300 mutantes

Flujo: tablero valido (generar_tablero) -> mutar -> ejecutar MainCLI -> comparar con el oraculo.
"""

import random
import re
import subprocess
import sys
import time
from collections import Counter, namedtuple

from fuzzer import generar_tablero


COMMAND = [
    'java', '-ea', '-cp', './target/classes',
    'ar.edu.unrc.game2048.MainCLI'
]

JUGADAS = "a\nd\nw\ns\nq\n"
SEMILLA = 1254

random.seed(SEMILLA)

ACEPTADO, RECHAZADO, CRASH, TIMEOUT = (
    "ACEPTADO", "RECHAZADO", "CRASH", "TIMEOUT"
)

RESULTADOS = [ACEPTADO, RECHAZADO, CRASH, TIMEOUT]

Prueba = namedtuple(
    "Prueba",
    "tablero ops motivo resultado codigo stderr segundos"
)


# ---------------------------------------------------------------- mutador

def mutar(s):
    """Aplica de 1 a 3 mutaciones: borrar, insertar o reemplazar."""
    ops = []

    for _ in range(random.randint(1, 3)):
        op = random.choice(["borrar", "insertar", "reemplazar"])
        i = random.randint(0, len(s))

        if op == "borrar" and s:
            s = s[:i - 1] + s[i:] if i > 0 else s[1:]

        elif op == "insertar":
            s = s[:i] + random.choice("0123456789,[] -x") + s[i:]

        elif op == "reemplazar" and s:
            j = min(i, len(s) - 1)
            s = s[:j] + random.choice("0123456789,[] -x") + s[j + 1:]

        else:
            continue

        ops.append(op)

    return s, ops


# ---------------------------------------------------------------- oraculo

CELDA = r'(?:0|[1-9][0-9]*)'
CUERPO = CELDA + r'(?:, *' + CELDA + r')*'


def motivo_invalido(s):
    """Devuelve None si el tablero es valido; si no, indica el motivo."""

    abre, cierra = s.startswith("["), s.endswith("]")

    if abre != cierra:
        return "corchetes desbalanceados"

    cuerpo = s[1:-1] if abre else s

    if "[" in cuerpo or "]" in cuerpo:
        return "corchetes de mas"

    if re.search(r'[^0-9, ]', cuerpo):
        return "caracter ilegal"

    if re.search(r'(^|,) *(,|$)', cuerpo):
        return "celda vacia / coma sobrante"

    if not re.fullmatch(CUERPO, cuerpo):
        return "espacios mal ubicados / ceros a la izquierda"

    for v in map(int, re.findall(r'[0-9]+', cuerpo)):
        if v != 0 and ((v & (v - 1)) != 0 or v > 2**30):
            return "valor no es potencia de 2 o supera 2^30"

    return None


# ---------------------------------------------------------------- arnes

def correr(tablero):
    """Ejecuta MainCLI y clasifica su respuesta."""

    try:
        r = subprocess.run(
            COMMAND + [tablero],
            input=JUGADAS,
            capture_output=True,
            text=True,
            encoding="utf-8",
            errors="replace",
            timeout=10
        )

    except subprocess.TimeoutExpired:
        return TIMEOUT, None, ""

    primera = r.stderr.strip().splitlines()[0] if r.stderr.strip() else ""

    if r.returncode == 0 and not r.stderr:
        return ACEPTADO, 0, ""

    limpio = (
        "Exception in thread" not in r.stderr
        and "\tat " not in r.stderr
    )

    if (
        r.returncode == 2
        and r.stderr.startswith("Invalid board")
        and limpio
    ):
        return RECHAZADO, 2, primera

    return CRASH, r.returncode, primera


# ---------------------------------------------------------------- casos

def generar_casos(n):
    """Genera un caso fijo y n mutantes."""

    # Caso fijo: dos celdas 2^30 juntas.
    # Permite comprobar el comportamiento ante un posible desbordamiento
    # al fusionar dos valores máximos.

    fijo = "[1073741824, 1073741824" + ", 0" * 13 + ", 2]"

    return (
        [(fijo, ["caso fijo"])]
        + [mutar(generar_tablero()) for _ in range(n)]
    )


def ejecutar(casos):
    """Ejecuta los casos y almacena sus resultados."""

    pruebas = []

    for tablero, ops in casos:
        inicio = time.time()

        resultado, codigo, stderr = correr(tablero)

        pruebas.append(
            Prueba(
                tablero,
                ops,
                motivo_invalido(tablero),
                resultado,
                codigo,
                stderr,
                time.time() - inicio
            )
        )

    return pruebas


# ---------------------------------------------------------------- analisis

def tipo_problema(p):
    """Devuelve el tipo de problema o None si el resultado es correcto."""

    if p.resultado in (CRASH, TIMEOUT):
        return p.resultado

    if p.motivo is None and p.resultado == RECHAZADO:
        return "RECHAZO_INCORRECTO"

    if p.motivo is not None and p.resultado == ACEPTADO:
        return "ACEPTO_INVALIDO"

    return None


def corto(s, n=70):
    """Acorta una cadena para mostrarla en el informe."""

    return repr(s) if len(s) <= n else repr(s[:n]) + f"... (+{len(s) - n} car.)"


# ---------------------------------------------------------------- main

def main():
    n = int(sys.argv[1]) if len(sys.argv) > 1 else 100

    inicio = time.time()
    pruebas = ejecutar(generar_casos(n))
    duracion = time.time() - inicio

    problemas = [p for p in pruebas if tipo_problema(p)]

    print("\n========== MUTATION FUZZER ==========")
    print(
        f"Semilla: {SEMILLA} | Pruebas: {len(pruebas)} "
        f"({n} mutantes + 1 fijo) | Tiempo: {duracion:.2f}s"
    )

    # Resultados
    cuenta = Counter(
        (p.motivo is None, p.resultado)
        for p in pruebas
    )

    print("\nResultados:")
    print(f"{'':12} {'ACEPT.':>7} {'RECH.':>7} {'CRASH':>7} {'TIMEOUT':>8}")

    for valido, nombre in [
        (True, "Validos"),
        (False, "Invalidos")
    ]:
        print(
            f"{nombre:<12}"
            + "".join(
                f"{cuenta[(valido, r)]:>7}"
                for r in RESULTADOS
            )
        )

    # Motivos de invalidez
    motivos = Counter(
        p.motivo
        for p in pruebas
        if p.motivo
    )

    if motivos:
        print("\nMotivos de invalidez:")

        for motivo, cantidad in motivos.most_common():
            print(f"  {motivo}: {cantidad}")

    # Operaciones aplicadas
    ops = Counter(
        op
        for p in pruebas
        for op in p.ops
    )

    print("\nMutaciones:")
    print(
        f"  Borrar: {ops['borrar']} | "
        f"Insertar: {ops['insertar']} | "
        f"Reemplazar: {ops['reemplazar']}"
    )

    # Problemas encontrados
    print(f"\nProblemas: {len(problemas)}")

    for p in problemas[:10]:
        esperado = "ACEPTADO" if p.motivo is None else "RECHAZADO"

        print(f"  [{tipo_problema(p)}] {corto(p.tablero)}")
        print(f"    Esperado: {esperado} | Obtenido: {p.resultado}")

    if len(problemas) > 10:
        print(f"  ... y {len(problemas) - 10} mas.")

    print("\n" + ("RESULTADO: OK" if not problemas else "RESULTADO: FALLO"))
    print("=" * 36)

    sys.exit(bool(problemas))


if __name__ == "__main__":
    main()
