# Reporte de métricas — Pruebas generadas por Randoop + RepOK

Proyecto: 2048-game
Paquete: ar.edu.unrc.game2048

## Cobertura de código (JaCoCo) — con RepOK

### Resumen general

* Instrucciones cubiertas: 82% (1.100 de 1.336; 236 missed).
* Ramas cubiertas: 80% (164 de 205; 41 missed).
* Líneas totales: 249; 53 missed.
* Métodos: 37 de 43 cubiertos (6 missed).
* Clases: 4 de 5 cubiertas (1 missed).

### Por clase
| Clase | Cov. Instrucciones | Cov. Ramas | Missed Métodos | Missed Clases |
| --- | --- | --- | --- | --- |
| Board | 91% | 84% | 1 de 24 | 0 |
| Cell | 88% | 90% | 1 de 10 | 0 |
| Board.Position | 96% | 80% | 0 de 4 | 0 |
| Board.Direction | 100% | n/a | 0 de 1 | 0 |
| MainCLI | 0% | 0% | 4 de 4 | 1 |

## Cobertura de Mutaciones (PIT) — con RepOK

### Resumen general

- Cobertura de líneas: 77% (190 de 248; 58 missed).
- Cobertura de mutaciones: 73% (160 de 220; 60 missed).
- Test Strength: 90% (160 de 177).
- Clases: 3.

### Por clase

| Clase         | Cov. Líneas | Cov. Mutaciones | Test Strength |
|---------------|-------------|------------------|----------------|
| Board         | 91% (165/181) | 79% (131/165) | 90% (131/146) |
| Cell          | 93% (25/27)   | 85% (29/34)   | 94% (29/31)   |
| MainCLI       | 0% (0/40)     | 0% (0/21)     | 100% (0/0)    |

## Comparativa: Randoop (sin RepOK) vs Randoop (con RepOK)

### Cobertura de código (JaCoCo)
| Métrica | Randoop (sin RepOK) | Randoop (con RepOK) | Diferencia |
|---|---|---|---|
| Instrucciones cubiertas | 64% | 82% | +18 pts |
| Ramas cubiertas | 57% | 80% | +23 pts |
| Métodos cubiertos | 34 de 40 | 37 de 43 | +3 métodos |
| Clases cubiertas | 4 de 5 | 4 de 5 | Sin cambios |

### Diferencias por clase (Cov. Instrucciones — JaCoCo)
| Clase | Randoop (sin RepOK) | Randoop (con RepOK) | Diferencia |
|---|---|---|---|
| Board | 69% | 91% | +22 pts |
| Cell | 77% | 88% | +11 pts |
| Board.Position | 85% | 96% | +11 pts |
| Board.Direction | 100% | 100% | Sin cambios |
| MainCLI | 0% | 0% | Sin cambios |

### Diferencias por clase (Cov. Ramas — JaCoCo)
| Clase | Randoop (sin RepOK) | Randoop (con RepOK) | Diferencia |
|---|---|---|---|
| Board | 59% | 84% | +25 pts |
| Cell | 83% | 90% | +7 pts |
| Board.Position | 50% | 80% | +30 pts |
| Board.Direction | n/a | n/a | — |
| MainCLI | 0% | 0% | Sin cambios |

## Comparativa completa: Fase 2 (Manual) vs Randoop vs Randoop + RepOK

### Cobertura de código (JaCoCo)
| Métrica | Fase 2 (Manual) | Randoop (sin RepOK) | Randoop (con RepOK) |
|---|---|---|---|
| Instrucciones cubiertas | 88% | 64% | 82% |
| Ramas cubiertas | 90% | 57% | 80% |
| Métodos cubiertos | 36 de 40 | 34 de 40 | 37 de 43 |
| Clases cubiertas | 4 de 5 | 4 de 5 | 4 de 5 |

### Análisis de mutaciones (PITest)
| Métrica | Fase 2 (Manual) | Randoop (sin RepOK) | Randoop (con RepOK) |
|---|---|---|---------------------|
| Line Coverage | 82% | 64% | 77%                 |
| Mutation Coverage | 84% | 49% | 73%                 |
| Test Strength | 94% | 77% | 90%                 |

