import os
import sys
import argparse
import requests

# Modelo OpenRouter seleccionado
MODEL_NAME = "nvidia/nemotron-3-ultra-550b-a55b:free"

# API Key configurada directamente
DEFAULT_API_KEY = ""

def recolectar_codigo(ruta):
    """Lee el archivo .java o recorre el directorio buscando todos los archivos Java."""
    codigo = ""
    if os.path.isfile(ruta):
        with open(ruta, 'r', encoding='utf-8') as f:
            codigo += f"\n--- Archivo: {os.path.basename(ruta)} ---\n" + f.read()
    elif os.path.isdir(ruta):
        for root, _, files in os.walk(ruta):
            for file in files:
                if file.endswith(".java"):
                    filepath = os.path.join(root, file)
                    with open(filepath, 'r', encoding='utf-8') as f:
                        codigo += f"\n--- Archivo: {file} ---\n" + f.read()
    return codigo

def ejecutar_oasis(ruta, metodo, asercion, contexto_asercion, api_key):
    """Envía el contexto del proyecto y los argumentos al modelo mediante OpenRouter."""
    codigo_fuente = recolectar_codigo(ruta)
    if not codigo_fuente:
        print(f"Error: No se encontró código Java en la ruta: '{ruta}'")
        sys.exit(1)

    prompt = f"""
Actúa como OASIs, una herramienta de refinamiento de oráculos de software utilizando LLMs.

CÓDIGO FUENTE COMPLETO DEL PROYECTO JAVA:
{codigo_fuente}

CONFIGURACIÓN DE EVALUACIÓN:
- Método a analizar: '{metodo}'
- Aserción / Invariante: '{asercion}'
- Contexto de la aserción: {contexto_asercion}

INSTRUCCIONES DE OASIs:
Evalúa si la aserción '{asercion}' es DEMASIADO DÉBIL (falso negativo) o DEMASIADO FUERTE (falso positivo) respecto al comportamiento del método '{metodo}'.

1. Si es DEMASIADO FUERTE (falso positivo):
   - Explica por qué falla en escenarios legales.
   - Genera un test case en Java que ejecute el método con un estado válido pero que viole la aserción.

2. Si es DEMASIADO DÉBIL (falso negativo):
   - Explica qué comportamiento erróneo no es capaz de detectar.
   - Genera un MUTANTE en Java (una modificación incorrecta del método '{metodo}') que rompa la lógica esperada pero pase la aserción sin fallar.

3. Si es ADECUADA:
   - Justifica por qué las pre/postcondiciones cubren correctamente el método.

Genera un reporte técnico conciso enfocado en guiar al usuario para refinar la aserción.
"""

    headers = {
        "Authorization": f"Bearer {api_key}",
        "Content-Type": "application/json",
        "HTTP-Referer": "https://github.com/Feligonzalez0/reliable-2048-gonzalez-marquez",
        "X-Title": "OASIs Oracle Tool"
    }

    payload = {
        "model": MODEL_NAME,
        "messages": [
            {
                "role": "system",
                "content": "Eres OASIs, un asistente experto en testing de software, verificación y refinamiento de oráculos e invariantes en Java."
            },
            {
                "role": "user",
                "content": prompt
            }
        ]
    }

    url = "https://openrouter.ai/api/v1/chat/completions"
    print(f"[OASIs] Enviando análisis de '{metodo}' a OpenRouter ({MODEL_NAME})...")
    
    response = requests.post(url, headers=headers, json=payload)
    
    if response.status_code == 200:
        return response.json()["choices"][0]["message"]["content"]
    else:
        print(f"Error {response.status_code} al consultar OpenRouter:")
        print(response.text)
        sys.exit(1)

def main():
    parser = argparse.ArgumentParser(
        description="OASIs Tool - Refinamiento de Oráculos con OpenRouter"
    )
    
    parser.add_argument("ruta", help="Ruta al directorio o archivo Java a analizar")
    parser.add_argument("metodo", help="Nombre del método objetivo (ej. move, mergeWith)")
    parser.add_argument("asercion", help="Expresión de la aserción o nombre del invariante (ej. repOK, assert score >= 0)")
    parser.add_argument("contexto", help="Aclaración sobre la aserción")

    args = parser.parse_args()

    api_key = os.getenv("OPENROUTER_API_KEY").strip()

    reporte = ejecutar_oasis(args.ruta, args.metodo, args.asercion, args.contexto, api_key)

    print("\n" + "=" * 60)
    print("🎯 REPORTE OASIs - REFINAMIENTO DE ORÁCULO")
    print("=" * 60 + "\n")
    print(reporte)

if __name__ == "__main__":
    main()