

# Reporte final: Generación automática de pruebas y fuzzing

## 1. Cobertura y puntuaciones de mutación por técnica

Técnicas evaluadas: pruebas manuales (Fase 1 y Fase 2), Randoop sin repOK, Randoop con repOK y EvoSuite.

### 1.1 Cobertura de código (JaCoCo)

| Métrica                 | Manual Fase 1 | Manual Fase 2 | Randoop (sin RepOK) | Randoop (con RepOK) | EvoSuite |
| ----------------------- | ------------- | ------------- | ------------------- | ------------------- | -------- |
| Instrucciones cubiertas | 72%           | 88%           | 64%                 | 82%                 | 84%      |
| Ramas cubiertas         | 69%           | 90%           | 57%                 | 80%                 | 80%      |
| Métodos cubiertos       | 32 de 40      | 36 de 40      | 34 de 40            | 37 de 43            | 39 de 43 |
| Clases cubiertas        | 4 de 5        | 4 de 5        | 4 de 5              | 4 de 5              | 4 de 5   |

### 1.2 Cobertura de instrucciones por clase

|Clase|Manual Fase 2|Randoop (sin RepOK)|Randoop (con RepOK)|EvoSuite|
|---|---|---|---|---|
|Board|100%|69%|91%|93%|
|Cell|100%|77%|88%|95%|
|Board.Position|100%|85%|96%|100%|
|Board.Direction|100%|100%|100%|100%|
|MainCLI|0%|0%|0%|0%|

### 1.3 Cobertura de ramas por clase

|Clase|Manual Fase 2|Randoop (sin RepOK)|Randoop (con RepOK)|EvoSuite|
|---|---|---|---|---|
|Board|97%|59%|84%|84%|
|Cell|100%|83%|90%|90%|
|Board.Position|100%|50%|80%|100%|
|Board.Direction|n/a|n/a|n/a|n/a|
|MainCLI|0%|0%|0%|0%|

### 1.4 Puntuaciones de mutación (PITest)

|Métrica|Manual Fase 1|Manual Fase 2|Randoop (sin RepOK)|Randoop (con RepOK)|
|---|---|---|---|---|
|Line Coverage|70%|82%|64%|77%|
|Mutation Coverage|65%|84%|49%|73%|
|Test Strength|86%|94%|77%|90%|

### 1.5 Mutation coverage por clase

|Clase|Manual Fase 2|Randoop (sin RepOK)|Randoop (con RepOK)|
|---|---|---|---|
|Board|93%|50%|79%|
|Cell|100%|81%|85%|
|MainCLI|0%|0%|0%|

## 2. Comparación entre EvoSuite y Randoop

### 2.1 Similitudes

Ambas herramientas generan test suite de manera automática, y además son principalmente de regresión es decir generan test con lo que dice el código sin entender la regla de juego.

### 2.2 Diferencias

| Aspecto             | Randoop                                                                                                                                                                            | EvoSuite                                                                                                                                                                                                                                                              |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Tipo de técnica     | Generación aleatoria dirigida por feedback, crea secuencias de llamadas a métodos de forma aleatoria, descartando de inmediato las entradas que fallan o no aportan nuevos estados | Generación basada en búsqueda (algoritmo genético), trata la creación de pruebas como un problema de optimización, evolucionando conjuntos de pruebas (test suites), utilizando la función de fitness: cobertura de ramas (con distancia de rama), mutation score,etc |
| Cobertura de Código | Logra una cobertura de código menor y se enfoca más en la verificación de contratos y detección rápida de anomalías básicas                                                        | Alcanza porcentajes de cobertura de código más altos, gracias a su optimización evolutiva dirigida a cubrir ramas                                                                                                                                                     |
| Rendimiento         | Es mucho más rápido y ligero. Genera pruebas en poco tiempo                                                                                                                        | Más costoso en tiempo y recursos de cómputo                                                                                                                                                                                                                           |
| Aserciones          | Crea pruebas con aserciones en chequear que no ocurran excepciones no controladas                                                                                                  | Generar aserciones regresivas basadas en el comportamiento observado del código, intentando documentar el estado actual del codigo                                                                                                                                    |

### 2.3 Fortalezas y debilidades

**Randoop**

- Fortalezas:
    
    - Es simple de configurar, solo necesita las clases y un tiempo.
        
    - El feedback evita tests inválidos y redundantes sin necesidad de definir objetivos.
        
    - Con `repOK` puede detectar violaciones de invariantes de la estructura, que es un oráculo más significativo.

- Debilidades:
    
    - No tiene un objetivo de cobertura, la cobertura depende de lo que el azar y el feedback alcancen.
        
    - En nuestro caso, sin `repOK` cubrió solo 64% de instrucciones y 57% de ramas.
        
    - Sus asserts de regresión no verifican que el resultado sea correcto según las reglas del 2048.


**EvoSuite**

- Fortalezas:
    
    - Está guiado por un objetivo explícito (ramas y mutantes), por eso logró más cobertura de instrucciones (84% contra 82%) y de métodos (39 de 43 contra 37 de 43).
        
    - Los asserts se eligen por su capacidad de matar mutantes y las suites se minimizan.
        
    - Genera casos límite y excepciones que una persona podría olvidar.

- Debilidades:
    
    - Los asserts siguen siendo de regresión, si el código tuviera un bug, EvoSuite lo registraría como comportamiento correcto.


## 3. fuzzer y implementación de fuzz()

### 3.1 Cómo funciona un fuzzer

Un fuzzer genera entradas de forma automática (aleatorias), toma el programa con estas entradas y observa si hubo un comportamiento anómalo, un crash, violación de un invariante,etc. De esta manera se puede encontrar errores de codificación y fallas.

### 3.2 Implementación de fuzz()

Se implementó un fuzzer aleatorio que genera una sesión completa de juego como texto, para alimentar la entrada estándar de la interfaz de línea de comandos.

```python
def __init__(self, min_length: int = 10, max_length: int = 50):
    self.min_length = min_length
    self.max_length = max_length

def fuzz(self) -> str:
    length = random.randint(self.min_length, self.max_length)
    result = ""

    for i in range(0, length, 1):
        result += random.choice(KEYS) + "\n"

    result += "q\n"

    return result
```

El funcionamiento de nuestro fuzzer es el siguiente: primero, elige un número al azar entre un mínimo y un máximo (que por defecto está entre 10 y 50). Luego, creamos una variable de tipo string llamada "result", que es donde vamos a ir armando la secuencia de comandos para que el fuzzer vaya probando el juego.

Después, usamos un ciclo for que itera desde el cero hasta ese número aleatorio que habíamos elegido. En cada iteración, le agregamos a la variable "result" una tecla elegida al azar junto con un salto de línea.

Una vez que termina el ciclo, le agregamos la letra "q" al final del string para que salga del juego. Finalmente, la función retorna esa cadena completa.

## 4. Errores encontrados

No tuvimos errores. El fuzzer funcionó correctamente desde la primera implementación y ninguna de las entradas generadas hizo fallar al programa.

## 5. Reflexiones

- **Más eficaz en métricas: las pruebas manuales (Fase 2).** Alcanzaron 88% de instrucciones, 90% de ramas, 84% de mutation coverage y 94% de test strength. Esto se explica porque como sabemos las reglas del 2048 podemos escribir aserciones significativas y no solo de regresión.
    
- **Mejor técnica automática en cobertura: EvoSuite**, con 84% de instrucciones, sin configuración adicional.
    
- **Randoop con RepOK** aumentó mucho la eficacia de al técnica, lo que queda claro que meter buenos oráculos a esta técnica mejora notablemente.
    
- **El fuzzer** cumple un rol distinto no mide cobertura ni compara resultados, solo busca que el programa no se rompa.
    
- **Conclusión:** las técnicas se complementan, cada una tiene sus pro y contras. Lo razonable es usar las herramientas automáticas para descubrir casos límite y excepciones, el fuzzer para probar la interfaz completa con entradas masivas.
