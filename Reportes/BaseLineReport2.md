# Línea base de métricas — Fase 2

Proyecto: 2048-game
Paquete: ar.edu.unrc.game2048
Fecha: 10/09/2026

## Cobertura de código (JaCoCo)

### Resumen general
- Instrucciones cubiertas: 88% (1,071 de 1,205; 134 missed)
- Ramas cubiertas: 90% (153 de 169; 16 missed)
- Líneas cubiertas: 224 total; 4 missed
- Métodos: 36 de 40 cubiertos (4 missed)
- Clases: 4 de 5 cubiertas (1 missed)

### Por clase
| Clase | Cov. Instrucciones | Cov. Ramas | Missed Métodos | Missed Clases |
|---|---|---|---|---|
| Board | 100% | 97% | 0 de 22 | 0 |
| Cell | 100% | 100% | 0 de 9 | 0 |
| Board.Position | 100% | 100% | 0 de 4 | 0 |
| Board.Direction | 100% | n/a | 0 de 1 | 0 |
| MainCLI | 0% | 0% | 4 de 4 | 1 |

## Análisis de mutaciones (PITest)

### Resumen general
- Number of Classes: 3
- Line Coverage: 82% (182/222)
- Mutation Coverage: 84% (161/192)
- Test Strength: 94% (161/171)

### Por clase
| Clase | Line Coverage | Mutation Coverage | Test Strength |
|---|---|---|---|
| Board.java | 100% (160/160) | 93% (135/145) | 93% (135/145) |
| Cell.java | 100% (22/22) | 100% (26/26) | 100% (26/26) |
| MainCLI.java | 0% (0/40) | 0% (0/21) | 100% (0/0) |

## Mejoras respecto a la Fase 1

### Cobertura de código (JaCoCo)
| Métrica | Fase 1 | Fase 2 | Mejora |
|---|---|---|---|
| Instrucciones cubiertas | 72% | 88% | +16 pts |
| Ramas cubiertas | 69% | 90% | +21 pts |
| Métodos cubiertos | 32 de 40 | 36 de 40 | +4 métodos |
| Clases cubiertas | 4 de 5 | 4 de 5 | Sin cambios |

### Análisis de mutaciones (PITest)
| Métrica | Fase 1 | Fase 2 | Mejora |
|---|---|---|---|
| Line Coverage | 70% | 82% | +12 pts |
| Mutation Coverage | 65% | 84% | +19 pts |
| Test Strength | 86% | 94% | +8 pts |

### Mejoras por clase (Cov. Instrucciones — JaCoCo)
| Clase | Fase 1 | Fase 2 | Mejora |
|---|---|---|---|
| Board | 83% | 100% | +17 pts |
| Cell | 89% | 100% | +11 pts |
| Board.Position | 40% | 100% | +60 pts |
| Board.Direction | 100% | 100% | Sin cambios |
| MainCLI | 0% | 0% | Sin cambios |

### Mejoras por clase (Mutation Coverage — PITest)
| Clase | Fase 1 | Fase 2 | Mejora |
|---|---|---|---|
| Board.java | 72% | 93% | +21 pts |
| Cell.java | 81% | 100% | +19 pts |
| MainCLI.java | 0% | 0% | Sin cambios |
