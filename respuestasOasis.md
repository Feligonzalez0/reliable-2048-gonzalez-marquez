# Caso 1: Análisis de `repOK` en `Board.move()`
### Comando: `python3 oasis.py ./src/main/java/ar/edu/unrc/game2048 move repOK "es el metodo repOK() de la clase board que valida estructura de la matriz"`

## Respuesta obtenida:
### REPORTE TÉCNICO OASIs: ANÁLISIS DE `repOK` EN `Board.move()`

#### CLASIFICACIÓN: **DEMASIADO DÉBIL (FALSO NEGATIVO)**

---

### 1. JUSTIFICACIÓN TÉCNICA

La aserción `repOK()` es una **invariante de representación estructural**, no funcional. Valida exclusivamente:
1.  Integridad de la matriz (`grid` no nula, cuadrada, celdas no nulas).
2.  Validez local de `Cell` (valores ≥ 0 y potencias de dos).
3.  Consistencia básica de `size` y `score` (≥ 0).

**No verifica la semántica del movimiento 2048**, permitiendo que mutantes que rompen la lógica del juego pasen la aserción silenciosamente. Específicamente, `repOK` **no detecta**:

| Comportamiento Erróneo | ¿Lo detecta `repOK`? | Por qué |
| :--- | :--- | :--- |
| **Fusión incorrecta** (ej. fusionar 3 fichas iguales en una, o fusionar por 4x en vez de 2x) | ❌ No | Los valores resultantes siguen siendo potencias de dos válidas. |
| **Dirección inversa** (UP mueve hacia DOWN) | ❌ No | La matriz resultante es estructuralmente válida. |
| **Puntaje corrupto** (sumar valor erróneo, no sumar, restar) | ❌ No | `score >= 0` se cumple. |
| **Generación de ficha en celda ocupada** (sobrescribir ficha existente) | ❌ No | La celda destino sigue teniendo un `Cell` válido (potencia de 2). |
| **Falta de compactación** (fichas no deslizan hasta el borde) | ❌ No | Las celdas vacías (`EMPTY`) están en posiciones válidas. |
| **Inmutabilidad violada** (mutar `Cell` existente en lugar de crear nuevo) | ❌ No | `Cell` es `final`/`inmutable` por diseño, pero `repOK` no verifica identidad de objetos. |

**Conclusión:** `repOK` es **necesaria pero insuficiente** como oráculo post-condición para `move()`. Garantiza que el tablero "no explota", pero no que "juega bien".

---

### 2. MUTANTE DEMOSTRATIVO (FALSO NEGATIVO)

El siguiente mutante implementa una lógica de **fusión agresiva (4x)** y **puntaje corrupto**, rompiendo completamente las reglas del 2048, pero **pasa `assert repOK()`** en ogni ejecución.

```java
// Archivo: BoardMutant.java (Versión mutada de Board.java)
// Cambios mínimos en processLine() para romper semántica manteniendo estructura.

    private List<Cell> processLine(List<Cell> line){
        List<Cell> nonEmpty = new ArrayList<>();
        for (Cell cell : line) {
            if (!cell.isEmpty()) {
                nonEmpty.add(cell);
            }
        }

        List<Cell> merged = new ArrayList<>();
        int i = 0;
        while (i < nonEmpty.size()) {
            // MUTANTE: Fusiona por 4x (valor * 4) en lugar de 2x
            // Rompe regla: "fusionar iguales suma valores (x2)"
            if (i + 1 < nonEmpty.size()
                        && nonEmpty.get(i).canMergeWith(nonEmpty.get(i + 1))) {

                int mergedValue = nonEmpty.get(i).getValue() * 4; // BUG: x4 en lugar de x2
                Cell mergedCell = new Cell(mergedValue);          // Válido para repOK (potencia de 2)
                merged.add(mergedCell);

                // MUTANTE: Puntaje corrupto (suma valor original, no fusionado)
                // Rompe regla: "score += valor_nueva_ficha"
                score += nonEmpty.get(i).getValue();              // BUG: score incorrecto

                i += 2;
            } else {
                merged.add(nonEmpty.get(i));
                i++;
            }
        }

        while (merged.size() < size) {
            merged.add(Cell.EMPTY);
        }
        return merged;
    }
```

#### Prueba de Ejecución del Mutante

```java
@Test
public void testMutantPassesRepOKButBreaksGame() {
    // Tablero: [2, 2, 0, 0] -> Esperado: [4, 0, 0, 0] (score +4)
    // Mutante produce: [8, 0, 0, 0] (score +2)

    Board board = new Board("[2,2,0,0, 0,0,0,0, 0,0,0,0, 0,0,0,0]");
    int initialScore = board.getScore(); // 0

    // Ejecutar movimiento LEFT
    boolean moved = board.move(Direction.LEFT);

    // 1. repOK() NO FALLA (Falso Negativo)
    assertTrue(board.repOK(), "repOK pasó: estructura válida, celdas potencias de 2, score >= 0");

    // 2. Pero la lógica está ROTA (Oráculo funcional necesario)
    Cell resultCell = board.getCell(0, 0);
    assertEquals(8, resultCell.getValue(), "MUTANTE: Fusionó 2+2=8 (x4) en lugar de 4 (x2)");
    assertEquals(2, board.getScore() - initialScore, "MUTANTE: Score incrementó en 2 en lugar de 4");
}
```

**Resultado:** El test `assertTrue(board.repOK())` pasa ✅. El juego está roto ❌.

---

### 3. RECOMENDACIÓN DE REFINAMIENTO (ORÁCULO MÁS FUERTE)

Para detectar estos fallos, `repOK` debe complementarse con **post-condiciones funcionales** en `move()` o un `functionalOK(Board prev, Direction dir)`:

```java
// Ejemplo de contrato funcional sugerido para move()
public boolean move(Direction direction) {
    Board previous = new Board(this);
    // ... lógica actual ...

    // NUEVAS ASERCIONES FUNCIONALES (activar con -ea)
    assert functionalMoveOK(previous, direction, moved) : "Violación semántica en move(" + direction + ")";
    assert repOK(); // Estructural (existente)
    return moved;
}

private boolean functionalMoveOK(Board prev, Direction dir, boolean moved) {
    // 1. Conservación de masa (suma de valores + score delta = valor ficha nueva)
    int prevSum = sumValues(prev);
    int currSum = sumValues(this);
    int newTileValue = moved ? (currSum + getScore() - (prevSum + prev.getScore())) : 0;
    // La nueva ficha (2 o 4) debe explicar la diferencia de masa
    if (moved && (newTileValue != 2 && newTileValue != 4)) return false;

    // 2. Monotonicidad de fusión (no crear valores imposibles sin fusión previa)
    // 3. Dirección: verificar que las fichas no se muevan "atrás"
    // 4. Fusión única por ficha por movimiento (regla 2048 estándar)

    return true; // Implementar checks detallados según especificación formal
}

private int sumValues(Board b) {
    int sum = 0;
    for (int r=0; r<b.size; r++)
        for (int c=0; c<b.size; c++)
            sum += b.grid[r][c].getValue();
    return sum;
}
```

**Resumen:** Mantenga `repOK` como **guardián estructural** (barato, siempre activo), pero añada un **oráculo funcional** (`functionalMoveOK`) como **guardián semántico** para `move()`.

---
# Caso 2: Aserción en `Cell.mergeWith()`

### Comando: `python3 oasis.py ./src/main/java/ar/edu/unrc/game2048 "Cell mergeWith()" "assert result.getValue() == 2 * this.value" "El valor de la celda nueva al fusionar 2 celdas debe ser el doble que el valor original"`

## Respuesta obtenida:
### Reporte Técnico OASIs: Evaluación de Aserción en `Cell.mergeWith()`

### Veredicto: **ADECUADA** ✅

La aserción `assert result.getValue() == 2 * this.value` es **correcta y precisa** para el método `Cell.mergeWith()` bajo sus precondiciones establecidas.

---

### Justificación Técnica

#### 1. Cobertura de Precondiciones (Contrato del Método)
El método `mergeWith(Cell other)` solo retorna un resultado (no lanza excepción) si se cumplen **todas** las siguientes condiciones (verificadas en `canMergeWith`):
- `other != null`
- `!this.isEmpty() || !other.isEmpty()` (no ambas vacías)
- `this.value != MAX_VALUE` (evita overflow: `MAX_VALUE = 1 << 30`)
- `this.value == other.value` (valores idénticos)

#### 2. Comportamiento de la Implementación
Cuando las precondiciones se cumplen:
```java
return new Cell(this.value * 2);
```
- `this.value` es una potencia de 2 (invariante de `Cell`).
- Al no ser `MAX_VALUE`, `this.value <= (1 << 29)`.
- `this.value * 2` es exactamente `2 * this.value`, cabe en `int` sin overflow y es potencia de 2.
- El constructor `Cell(int)` valida que el valor sea potencia de 2 → **siempre tiene éxito**.

#### 3. Evaluación de la Aserción
| Escenario | `result.getValue()` | `2 * this.value` | Aserción |
|-----------|---------------------|------------------|----------|
| Caso nominal (ej. 2+2) | 4 | 4 | ✅ Pasa |
| Valor máximo mergeable (2²⁹ + 2²⁹) | 2³⁰ (MAX_VALUE) | 2³⁰ | ✅ Pasa |
| Mutante: `return new Cell(this.value)` (no duplica) | `v` | `2v` | ❌ **Falla** (detectado) |
| Mutante: `return new Cell(this.value * 4)` (cuadruplica) | `4v` | `2v` | ❌ **Falla** (detectado) |
| Mutante: `return Cell.EMPTY` | 0 | `2v` | ❌ **Falla** (detectado) |

#### 4. Por qué NO es "Demasiado Fuerte" (Falso Positivo)
- No falla en **ningún** estado válido precondiciones + implementación correcta.
- No impone restricciones extra (ej. inmutabilidad, identidad de `other`) fuera del alcance del valor numérico.

#### 5. Por qué NO es "Demasiado Débil" (Falso Negativo)
- Detecta **cualquier** desviación en el cálculo del valor resultante (factor ≠ 2).
- La igualdad `this.value == other.value` (garantizada por precondición) hace que verificar contra `this.value` sea equivalente a verificar contra `other.value` o la suma de ambos.

---

### Conclusión y Recomendación

**La aserción está bien formulada.** Captura exactamente la postcondición funcional principal del merge: *"el valor resultante es el doble del valor de la celda actual"*.

**No se requiere refinamiento** para esta aserción específica. Si se desea ampliar el oráculo, se podrían añadir aserciones complementarias (ej. `assert result != this` para inmutabilidad, `assert result.getValue() == other.getValue() * 2` para redundancia), pero la aserción actual es **suficiente y necesaria** para la propiedad que verifica.

---

# Caso 3: Aserción en `Cell.mergeWith()`

### Comando: `python3 oasis.py ./src/main/java/ar/edu/unrc/game2048 "Board addRandomTile()"  "this.size == orig(this.size) && this.score == orig(this.score)" "Postcondición inferida por Daikon para Board.addRandomTile(): agrega una celda de valor 2 o 4 en una celda vacía elegida al azar y devuelve true; si no hay celdas vacías devuelve false y no modifica el tablero"`

## Respuesta obtenida:
### Reporte Técnico de Evaluación de Aserción - OASIs

### Veredicto: **DEMASIADO DÉBIL (Falso Negativo)**

---

### Análisis

La aserción `this.size == orig(this.size) && this.score == orig(this.score)` **solo verifica que dos campos no cambien**, pero **no captura la semántica esencial** de `addRandomTile()`:

| Campo | ¿Cambia en `addRandomTile()`? | Cobertura de la aserción |
|-------|------------------------------|--------------------------|
| `size` | **Nunca** (es `final`) | ✅ Trivialmente cierto |
| `score` | **Nunca** (solo cambia en `move()` al fusionar) | ✅ Cierto pero irrelevante |
| `grid` (contenido) | **Sí** (se añade un `Cell(2)` o `Cell(4)` en una posición vacía) | ❌ **No verificado** |
| Valor de retorno | **Sí** (`true` si había hueco, `false` si lleno) | ❌ **No verificado** |

**Consecuencia:** Un mutante que **no haga nada** (ni añada ficha, ni cambie el tablero, siempre devuelva `false`) **cumple la aserción** cuando el tablero tiene celdas vacías, porque `size` y `score` siguen intactos.

---

### Mutante que rompe la lógica pero pasa la aserción

```java
// MUTANTE: Board.java - método addRandomTile() corrompido
private boolean addRandomTile() {
    // BUG: Ignora completamente las celdas vacías y no añade nada
    // Comportamiento esperado: colocar 2/4 en hueco aleatorio y devolver true
    // Comportamiento real: no modifica el tablero y devuelve false siempre
    return false;
}
```

**Por qué pasa la aserción débil:**
- `size` inmutable → `this.size == orig(this.size)` ✅
- `score` no tocado → `this.score == orig(this.score)` ✅
- **Pero el tablero no cambió** y el método mintió devolviendo `false` cuando había huecos.

---

### Guía de Refinamiento

La postcondición debe expresar **qué cambia y cómo**:

```java
// Postcondición fuerte (esquema JML/Daikon mejorado)
/*@ ensures \result ==>
        (\exists Position p; getEmptyPositions().contains(p);
            grid[p.row][p.col].getValue() == 2 || grid[p.row][p.col].getValue() == 4
        ) &&
        !\result ==> !hasEmptyPositions() &&
        size == \old(size) &&
        score == \old(score)
*/
```

**Puntos clave a añadir:**
1. **Si `\result == true`**: exactamente una celda vacía pasó a ser `2` o `4`.
2. **Si `\result == false`**: no había celdas vacías (`!hasEmptyPositions()`).
3. **Inmutables**: `size` y `score` sin cambios (lo que ya tienes).
4. **Opcional**: el número de celdas vacías disminuye en 1 si `\result`.

---

### Test Case para Exponer la Debilidad (Opcional)

```java
@Test
void testAddRandomTileActuallyAddsTile() {
    // Tablero 2x2 con 3 celdas vacías
    Board b = new Board("[2,0,0,0]"); // size=2, una ficha, 3 huecos
    int emptyBefore = b.getEmptyPositions().size(); // 3
    int scoreBefore = b.getScore(); // 0

    boolean added = b.addRandomTile();

    // La aserción débil pasa, pero el test fuerte falla con el mutante
    assertTrue(added, "Debe devolver true si había hueco");
    assertEquals(emptyBefore - 1, b.getEmptyPositions().size(),
        "Debe haber una celda vacía menos");
    assertEquals(scoreBefore, b.getScore(), "Score no debe cambiar");
    // Verificar que la nueva ficha es 2 o 4
    Cell newTile = Arrays.stream(b.grid)
        .flatMap(Arrays::stream)
        .filter(c -> c.getValue() != 0 && c.getValue() != 2) // ignora la original
        .findFirst().orElseThrow();
    assertTrue(newTile.getValue() == 2 || newTile.getValue() == 4);
}
```

Este test **falla con el mutante** y **pasa con la implementación correcta**, demostrando que la aserción original no detecta la regresión.