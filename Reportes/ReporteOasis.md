
# Reporte de experiencia con OASIS

La experiencia fue muy positiva. Nos pareció una de las herramientas más útiles que probamos porque aprovecha la capacidad actual de los LLM para razonar el codigo y tambien verificar las aserciones algo que las herramientas tradicionales no hacen

## 2. Casos de estudio

Las tres aserciones analizadas fueron:

| # | Método | Aserción | Veredicto de OASIS |
|---|--------|----------|--------------------|
| 1 | `Board.move()` | `repOK()` | Demasiado débil |
| 2 | `Cell.mergeWith()` | `result.getValue() == 2 * this.value`(postcondición inferida por Daikon) | Adecuada |
| 3 | `Board.addRandomTile()` | `this.size == orig(this.size) && this.score == orig(this.score)` (postcondición inferida por Daikon) | Demasiado débil |

Las respuestas completas de la herramienta están en el archivo `oasisrepuesto.md`

## 3. Que cosas cambiamos

**`Board.move()`:** Agregamos postcondiciones fuertes el score no disminuye, si no hubo movimiento el tablero y el score queda igual y si hubo movimiento la suma de valores aumenta únicamente por la ficha nueva 2 o 4. Elegimos este método porque es el núcleo del juego concentra el deslizamiento, la fusión y el puntaje, y un error acá rompe todo lo demás. Es donde más valor vimos tener un oráculo fuerte.

**`Cell.mergeWith()`:** Oasis la clasificó como adecuada.

**`Board.addRandomTile()`:** Aunque oasis la marcó como débil, decidimos no refinarla porque es un método auxiliar. Su efecto ya queda cubierto indirectamente por la nueva aserción de `move()` que exige que la suma aumente en 2 o 4 tras un movimiento.

## 4. Feedback sobre la herramienta

**Lo bueno**
- Los mutantes y tests generados son concretos y ejecutables, lo que hace evidente por qué una aserción es débil
- Explica el razonamiento y no solo da un veredicto, lo que ayuda a decidir
- Distinguió bien los tres casos, incluido el que no requería cambios

**Lo Malo**
- No concluimos nada malo de la herramienta
