# Reporte de métricas — Pruebas generadas por Randoop

Proyecto: 2048-game
Paquete: ar.edu.unrc.game2048

## Cobertura de código (JaCoCo)

### Resumen general

* Instrucciones cubiertas: 64% (773 de 1.205; 432 missed).
* Ramas cubiertas: 57% (98 de 169; 71 missed).
* Líneas totales: 224; 79 missed.
* Métodos: 34 de 40 cubiertos (6 missed).
* Clases: 4 de 5 cubiertas (1 missed).

### Por clase
| Clase | Cov. Instrucciones | Cov. Ramas | Missed Métodos | Missed Clases |
| --- | --- | --- | --- | --- |
| Board | 69% | 59% | 1 de 22 | 0 |
| Cell | 77% | 83% | 1 de 9 | 0 |
| Board.Position | 85% | 50% | 0 de 4 | 0 |
| Board.Direction | 100% | n/a | 0 de 1 | 0 |
| MainCLI | 0% | 0% | 4 de 4 | 1 |

## Análisis de mutaciones (PITest)

### Resumen general

* Number of Classes: 3.
* Line Coverage: 64% (143/222).
* Mutation Coverage: 49% (94/192).
* Test Strength: 77% (94/122).

### Por clase
| Clase | Line Coverage | Mutation Coverage | Test Strength |
|---|---|---|---|
| Board.java | 78% (124/160) | 50% (73/145) | 74% (73/99) |
| Cell.java | 86% (19/22) | 81% (21/26) | 91% (21/23) |
| MainCLI.java | 0% (0/40) | 0% (0/21) | 100% (0/0) |

## Comparativa: Fase 2 (Manual) vs Randoop (Automático)

### Cobertura de código (JaCoCo)
| Métrica | Fase 2 (Manual) | Randoop | Diferencia |
|---|---|---|---|
| Instrucciones cubiertas | 88% | 64% | -24 pts |
| Ramas cubiertas | 90% | 57% | -33 pts |
| Métodos cubiertos | 36 de 40 | 34 de 40 | -2 métodos |
| Clases cubiertas | 4 de 5 | 4 de 5 | Sin cambios |

### Análisis de mutaciones (PITest)
| Métrica | Fase 2 (Manual) | Randoop | Diferencia |
|---|---|---|---|
| Line Coverage | 82% | 64% | -18 pts |
| Mutation Coverage | 84% | 49% | -35 pts |
| Test Strength | 94% | 77% | -17 pts |

### Diferencias por clase (Cov. Instrucciones — JaCoCo)
| Clase | Fase 2 (Manual) | Randoop | Diferencia |
|---|---|---|---|
| Board | 100% | 69% | -31 pts |
| Cell | 100% | 77% | -23 pts |
| Board.Position | 100% | 85% | -15 pts |
| Board.Direction | 100% | 100% | Sin cambios |
| MainCLI | 0% | 0% | Sin cambios |

### Diferencias por clase (Mutation Coverage — PITest)
| Clase | Fase 2 (Manual) | Randoop | Diferencia |
|---|---|---|---|
| Board.java | 93% | 50% | -43 pts |
| Cell.java | 100% | 81% | -19 pts |
| MainCLI.java | 0% | 0% | Sin cambios |
---