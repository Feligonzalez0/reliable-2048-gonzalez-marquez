

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

## 6. Daikon: invariantes inferidas y comparación con `repOK()`

### 6.1 Comandos de instrumentación y recolección de trazas

**Trazas de RandoopTests:**

```powershell
java -cp $cp daikon.Chicory `
    --output-dir=daikon-traces/RandoopTests `
    org.junit.runner.JUnitCore `
    randoopTests.RegressionTest
```

**Trazas de MainCLI:**

```powershell
java -cp "lib/daikon.jar;target/classes" daikon.Chicory `
    --output-dir=daikon-traces/MainCLI `
    ar.edu.unrc.game2048.MainCLI
```

**Trazas de CellTest:**

```powershell
$cp = "lib/daikon.jar;lib/junit-platform-console-standalone-1.10.2.jar;target/classes;target/test-classes;$(mvn dependency:build-classpath -q -DforceStdout)"

java -cp $cp `
     daikon.Chicory `
     '--ppt-select-pattern=ar.edu.unrc.game2048.(Board|Cell)' `
     --output-dir=daikon-traces/CellTest `
     --dtrace-file=CellTest.dtrace.gz `
     org.junit.platform.console.ConsoleLauncher `
     --select-class ar.edu.unrc.game2048.CellTest
```

**Trazas de BoardTest:**
```powershell
$cp = "lib/daikon.jar;lib/junit-platform-console-standalone-1.10.2.jar;target/classes;target/test-classes;$(mvn dependency:build-classpath -q -DforceStdout)"

java -cp $cp `
     daikon.Chicory `
     '--ppt-select-pattern=ar.edu.unrc.game2048.(Board|Cell)' `
     --output-dir=daikon-traces/BoardTest `
     --dtrace-file=BoardTest.dtrace.gz `
     org.junit.platform.console.ConsoleLauncher `
     --select-class ar.edu.unrc.game2048.BoardTest
```

**Trazas del fuzzer:**

```powershell
py fuzzer-daikon.py
```

**Generación de `daikon-output.txt`:**


```powershell
$trazas = Get-ChildItem -Path daikon-traces -Recurse -File -Filter "*.dtrace*" |
          ForEach-Object { $_.FullName }

java -cp lib/daikon.jar daikon.Daikon $trazas > daikon-output.txt
```

### 6.2 Invariantes inferidas y clasificación

#### Cell

|Invariante|Dónde|Clasificación|Razonamiento|
|---|---|---|---|
|`this.value >= 0`|`OBJECT`|**Correcta y útil**|Está en nuestro `repOK()`|
|`(this.value == 0) <==> (return == true)`|`isEmpty()` EXIT|**Correcta y útil**|Es lo que debería hacer `isEmpty`|
|`2 * this.value - return.value == 0`|`mergeWith` EXIT|**Correcta y útil**|Hacer un merge debería duplicar el valor|
|`this.value == return`|`getValue()` EXIT|**Correcta pero trivial**|Es lo que dice el código del getter|
|`this.value - return + 31 == 0`|`hashCode()` EXIT|**Correcta pero trivial**|Es lo que dice el código del `hashCode` (`31 + value`)|
|`this.value == 16`|`equals` EXIT (rama true)|**Demasiado espuria**|Solo ocurrió porque un test comparó celdas de 16|

#### Board

|Invariante|Dónde|Clasificación|Razonamiento|
|---|---|---|---|
|`this.size == size(this.grid[])`|`OBJECT`|**Correcta y útil**|Tablero cuadrado, está en nuestro `repOK()`|
|`this.score >= orig(this.score)`|`move` EXIT|**Correcta y útil**|El puntaje nunca baja. Detectaría una resta indebida|
|`(return == false) ==> this.score == orig(this.score)`|`move` EXIT|**Correcta y útil**|Un movimiento sin efecto no suma puntos|
|`this.grid == orig(this.grid)`|casi todos los métodos|**Correcta pero trivial**|La grilla no cambia de referencia, casi nunca detectaría un bug|
|`this.score % DEFAULT_SIZE == 0`|`OBJECT`|**Demasiado espuria**|Se debe a que en la mayoría de los tests el score final es múltiplo de 4, pero esto no tiene sentido porque el score va sumando el puntaje de cada celda fusionada|
|`this.score % this.size == 0`|`OBJECT` y varios EXIT|**Demasiado espuria**|Solo se cumple porque en los tableros de otro tamaño el score era 0. Con `size = 10` y una fusión 2+2 el score es 4, y 4 % 10 ≠ 0|
|`(return == true) ==> this.score == 0`|`isWinningBoard`, `isFull` EXIT|**Demasiado espuria**|Un tablero ganador en una partida real tiene puntaje > 0|

#### Incorrecto

| Invariante                                                                            | Dónde            | Clasificación                 | Razonamiento                                                               |
| ------------------------------------------------------------------------------------- | ---------------- | ----------------------------- | -------------------------------------------------------------------------- |
| `this.score % this.size == 0` (el puntaje es siempre múltiplo del tamaño del tablero) | `Board:::OBJECT` | **Incorrecta como propiedad** | Daikon la reporta correctamente sobre las trazas, pero es falsa en general |

### 6.3 Comparación de Daikon con nuestro `repOK()`

Daikon redescubrió solo una parte de lo que ya expresamos en nuestro `repOK()` ,infirió `value >= 0` en `Cell`, y `grid != null`, `size == grid.length`, `grid[] elements != null` (ninguna fila es nula) y `score >= 0` en `Board`. En cambio no logró inferir `size > 0` ni propiedades más ricas como que el valor de una celda sea 0 o potencia de 2(solo en algunos metodos), que cada fila tenga largo `size` y que cada celda sea no nula (propiedades que hay que verificar en todas las posiciones de la matriz) y que cada celda sea válida (`cell.repOK()`, porque daikon solo ve valores de variables y no llama a métodos). Además buena parte de lo que reportó es trivial o espurio (rangos como `size one of {1, 4, 10, 100}` o `score == 0` en tableros ganadores). Todo esto tiene una causa común daikon solo conoce las ejecuciones que le dimos así que sus invariantes describen lo que ocurrió en esas trazas y no necesariamente lo que el programa garantiza y su calidad depende de la variedad de los tests y las partidas.

Daikon no infirió ninguna invariante de objeto nueva que faltara en nuestro `repOK()`. Lo que aportó son pre y postcondiciones útiles como `score >= orig(score)` en `move` o `mergeWith` duplicando el valor. No las agregamos a `repOK()`, porque `repOK()` expresa lo que todo objeto debe cumplir en cualquier momento mirando solo su estado actual y estas relacionan el estado anterior con el posterior, pero sirven como aserciones en esos métodos. Por eso Daikon resulta complementario a `repOK()` no reemplaza una especificación escrita a mano.

### 6.4 Daikon frente a oráculos de pruebas manuales y automatizadas

Para este programa los oráculos más útiles fueron los manuales las aserciones de los tests y `repOK()`. Son los únicos que expresan la lógica real del juego y nuestro `repOK()` capturó propiedades que Daikon no pudo inferir que el valor de una celda sea 0 o potencia de 2, el largo de cada fila, que cada celda sea válida, etc.

Daikon fue un buen complemento infirió relaciones entre entrada y salida que no habíamos escrito, como `score >= orig(score)` en `move` o que `mergeWith` duplica el valor. Pero depende de la calidad de las trazas y generó invariantes espurias, así que sus resultados necesitan revisión humana antes de usarse como oráculo.

Los oráculos de Randoop y EvoSuite son de regresión congelan lo que el código hace hoy así que no detectan un bug que ya existía, aunque sirven para cobertura y como seguridad ante cambios.
