## Informe obtenido de mutation_fuzzer con Board(string) original:

```
========== MUTATION FUZZER ==========
Semilla: 1254 | Pruebas: 101 (100 mutantes + 1 fijo) | Tiempo: 10.40s

Resultados:
              ACEPT.   RECH.   CRASH  TIMEOUT
Validos           6      0      1      0
Invalidos        15      0     79      0

Motivos de invalidez:
  espacios mal ubicados / ceros a la izquierda: 27
  corchetes de mas: 18
  valor no es potencia de 2 o supera 2^30: 14
  celda vacia / coma sobrante: 13
  corchetes desbalanceados: 12
  caracter ilegal: 10

Mutaciones:
  Borrar: 58 | Insertar: 76 | Reemplazar: 68

Problemas: 95
  [CRASH] '[1073741824, 1073741824, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2]'
    Esperado: ACEPTADO | Obtenido: CRASH
  [CRASH] '[2, 0, 2, 0, 64, 0, 0,9 2, 0, 8, 03 16, 2, 0, 2, ]'
    Esperado: RECHAZADO | Obtenido: CRASH
  [CRASH] '[4, 0, 4, 0, 32 2, 2, 0, 0, 16,2, 0, 4, 0] 2, 32]'
    Esperado: RECHAZADO | Obtenido: CRASH
  [CRASH] '[4, 0, [4, 2, 32, 0, 16, 2, 4, 2, , 2, 0, 0, 2, 0]'
    Esperado: RECHAZADO | Obtenido: CRASH
  [CRASH] '[2, , 0, 2, 0, 2, 2, 8, 2, 4, 32, 2, 2, 8, 4, 4]'
    Esperado: RECHAZADO | Obtenido: CRASH
  [CRASH] '[4, , 128, 0, 4, 8, 0, 0, 4, 2, 16, 2,5 4, , 8, 2]'
    Esperado: RECHAZADO | Obtenido: CRASH
  [CRASH] '0, 0, 4, 64, 2, 0, 0, 0,516, 2, 2, 0, 0, 0, 2, 0]'
    Esperado: RECHAZADO | Obtenido: CRASH
  [CRASH] '[2, 0, 32, 2, 2, 2, 2, 2, 2, 90, 2, 4, 2, 0, 2, 0]'
    Esperado: RECHAZADO | Obtenido: CRASH
  [CRASH] '[4, 08, 2,7 16, 0,,0, 2, 16, 0, 1024, 0, 0, 2, 0, 2, 0]'
    Esperado: RECHAZADO | Obtenido: CRASH
  [CRASH] '[4, 2, 4, 2, 0, 16, 32, 0, 0, 2, 0, 2, 05, 32, 0, 0]'
    Esperado: RECHAZADO | Obtenido: CRASH
  ... y 85 mas.

RESULTADO: FALLO
====================================
```

## Informe obtenido de mutation_fuzzer con correcciones en Board.java, Cell.java y MainCLI.java:
```
========== MUTATION FUZZER ==========
Semilla: 1254 | Pruebas: 101 (100 mutantes + 1 fijo) | Tiempo: 9.47s

Resultados:
              ACEPT.   RECH.   CRASH  TIMEOUT
Validos           7      0      0      0
Invalidos         0     94      0      0

Motivos de invalidez:
  espacios mal ubicados / ceros a la izquierda: 27
  corchetes de mas: 18
  valor no es potencia de 2 o supera 2^30: 14
  celda vacia / coma sobrante: 13
  corchetes desbalanceados: 12
  caracter ilegal: 10

Mutaciones:
  Borrar: 58 | Insertar: 76 | Reemplazar: 68

Problemas: 0

RESULTADO: OK
====================================
```

## Errores encontrados y corregidos
 
### 1. Crasheaba en vez de rechazar (exit 1)
 
| # | Entrada mínima | Antes | Causa |
|---|---|---|---|
| 1 | ` `, `[]`, `[2,,4,8]` | `NumberFormatException: For input string: ""` | `Integer.parseInt("")` sin validar |
| 2 | `[2,x,4,8]` | `NumberFormatException` | token no numérico |
| 3 | `[99999999999]` | `NumberFormatException` | no entra en `int` |
| 4 | `[2,3,4,8]` | `IllegalArgumentException: Cell must be a power of two` | la excepción de `Cell` llegaba sin capturar al `main` |
| 5 | `[2,-2,4,8]` | `IllegalArgumentException: ... negative` | ídem |
| 6 | `[2,4,8,16] basura` | `NumberFormatException: "16basura"` | |
 
**Corrección:** `Board(String)` ahora valida con un parser lineal escrito a mano y siempre lanza
`IllegalArgumentException` con mensaje descriptivo; `MainCLI.main` la captura, imprime
`Invalid board: ...` y sale con código `2` (`MainCLI.EXIT_INVALID_BOARD`).
 
### 2. Aceptaba en silencio tableros inválidos (exit 0)
 
| # | Entrada mínima | Antes | Causa |
|---|---|---|---|
| 7 | `[2,]`, `[2,4,8,16,]` | aceptado | `String.split(",")` descarta los vacíos finales |
| 8 | `[2,4,8,16` / `2,4,8,16]` | aceptado | `replace("[","").replace("]","")` borra cualquier corchete |
| 9 | `[[2,4,8,16]]` | aceptado | ídem |
| 10 | `[1 6,0,0,0]` | se lee como `16` | `replace(" ","")` borra espacios *dentro* de números |
| 11 | `[+2,0,0,0]`, `[02,0,0,0]`, `[-0,...]` | aceptado | `Integer.parseInt` tolera signo y ceros a la izquierda |
 
**Corrección:** mismo parser estricto (el `replace`/`split` original fue eliminado).
 
### 3. Un tablero **válido** que crashea al jugar (desbordamiento)
 
| # | Entrada | Antes | Causa |
|---|---|---|---|
| 12 | `[1073741824,1073741824,0,0]` + movimiento `a` | `IllegalArgumentException: Cell value cannot be negative: -2147483648` | `2^30 + 2^30 = 2^31` desborda `int` en `Cell.mergeWith` |
 
**Corrección:** `Cell.MAX_VALUE = 1 << 30`; dos celdas con ese valor ya no se pueden fusionar
(`canMergeWith` devuelve `false`). Este caso solo lo detecta el corpus semilla: el mutador
aleatorio casi nunca construye dos `2^30` contiguos.
