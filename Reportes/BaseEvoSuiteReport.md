# Reporte de metricas: Pruebas generadas por EvoSuite (JaCoCo)

Proyecto: 2048-game
Paquete: ar.edu.unrc.game2048

## Cobertura de codigo (JaCoCo): EvoSuite

### Resumen general
* Instrucciones cubiertas: 84% (1.192 de 1.408; 216 missed).
* Ramas cubiertas: 80% (165 de 205; 40 missed).
* Líneas totales: 248; 52 missed.
* Métodos: 39 de 43 cubiertos (4 missed).
* Clases: 4 de 5 cubiertas (1 missed).

### Por clase
| Clase | Cov. Instrucciones | Cov. Ramas | Missed Métodos | Missed Clases |
| --- | --- | --- | --- | --- |
| Board | 93% | 84% | 0 de 24 | 0 |
| Cell | 95% | 90% | 0 de 10 | 0 |
| Board.Position | 100% | 100% | 0 de 4 | 0 |
| Board.Direction | 100% | n/a | 0 de 1 | 0 |
| MainCLI | 0% | 0% | 4 de 4 | 1 |

## Comparativa: Manual (Fase 2) vs Randoop + RepOK vs EvoSuite

### Cobertura de código (JaCoCo)
| Métrica | Fase 2 (Manual) | Randoop (con RepOK) | EvoSuite |
|---|---|---|---|
| Instrucciones cubiertas | 88% | 82% | 84% |
| Ramas cubiertas | 90% | 80% | 80% |
| Métodos cubiertos | 36 de 40 | 37 de 43 | 39 de 43 |
| Clases cubiertas | 4 de 5 | 4 de 5 | 4 de 5 |

### Cov. Instrucciones por clase
| Clase | Fase 2 (Manual) | Randoop (con RepOK) | EvoSuite |
|---|---|---|---|
| Board | 100% | 91% | 93% |
| Cell | 100% | 88% | 95% |
| Board.Position | 100% | 96% | 100% |
| Board.Direction | 100% | 100% | 100% |
| MainCLI | 0% | 0% | 0% |

### Cov. Ramas por clase
| Clase | Fase 2 (Manual) | Randoop (con RepOK) | EvoSuite |
|---|---|---|---|
| Board | 97% | 84% | 84% |
| Cell | 100% | 90% | 90% |
| Board.Position | 100% | 80% | 100% |
| Board.Direction | n/a | n/a | n/a |
| MainCLI | 0% | 0% | 0% |

## Conclusion:
* Las pruebas manuales siguen siendo las de mayor cobertura en instrucciones (88%) y ramas (90%).
* EvoSuite supera a Randoop en instrucciones, en métodos cubiertos y Empatan en ramas (80%).

Respuestas a las preguntas 1.2:

**¿Que tipo de datos de entrada genero EvoSuite?**

EvoSuite genero principalmente valores limite y extremos: tamanos de tablero normales y tamanos negativos o muy grandes, indices fuera de rango para getCell/setCell (2143, -1233), valores de Cell invalidos (numeros que no son potencia de dos, o negativos), y tambien null pasado como parametro. Ademas reutiliza numeros que ya estaban en el codigo, como 2048 y 4, aunque no tengan sentido en ese lugar (por ejemplo como coordenadas de una Position). No genero datos "normales" pensando en como un jugador usaria el juego, sino datos pensados para forzar los if y las excepciones del codigo.

**¿Son significativas las afirmaciones (oraculos) de prueba, o son principalmente afirmaciones de regresion?**

Son principalmente de regresion. La mayoria de los assertEquals no verifican que el resultado sea correcto segun las reglas del 2048, sino que solo guardan el valor que el codigo devolvio en el momento en que se genero el test. Por ejemplo, si el score despues de un merge estuviera mal calculado, EvoSuite igual generaria un test que lo marca como "correcto", porque solo copia lo que observa. La excepcion son los tests que verifican que se lance una excepcion cuando corresponde (por ejemplo, tamano de tablero negativo o Cell con valor invalido) esos si coinciden con lo que el codigo deberia hacer segun su contrato, aunque EvoSuite los haya encontrado por casualidad durante la busqueda y no porque entienda el modelo de negocio.

**¿Hay alguna prueba que parezca fragil o dificil de entender?**

Si. hay pruebas dificiles de entender por como estan armadas: tienen variables declaradas que nunca se usan, encadenan muchas llamadas a metodos sin ninguna aserción relevante en el medio, o directamente llaman a un metodo sin verificar nada del resultado, lo que las hace confusas de leer y con poco valor real como prueba.