# Línea base de métricas — Fase 1

Proyecto: 2048-game
Paquete: ar.edu.unrc.game2048
Fecha: 03/09/2026

## Cobertura de código (JaCoCo)

### Resumen general
- Instrucciones cubiertas: 72% (878 de 1,205; 327 missed)
- Ramas cubiertas: 69% (118 de 169; 51 missed)
- Líneas cubiertas: 224 missed de total
- Métodos: 32 de 40 cubiertos (8 missed)
- Clases: 4 de 5 cubiertas (1 missed)

### Por clase
| Clase | Cov. Instrucciones | Cov. Ramas | Missed Métodos | Missed Clases |
|---|---|---|---|---|
| Board | 83% | 81% | 2 de 22 | 0 |
| Cell | 89% | 75% | 0 de 9 | 0 |
| Board.Position | 40% | 0% | 2 de 4 | 0 |
| Board.Direction | 100% | n/a | 0 de 1 | 0 |
| MainCLI | 0% | 0% | 4 de 4 | 1 |

## Análisis de mutaciones (PITest)

### Resumen general
- Number of Classes: 3
- Line Coverage: 70% (155/222)
- Mutation Coverage: 65% (125/192)
- Test Strength: 86% (125/145)

### Por clase
| Clase | Line Coverage | Mutation Coverage | Test Strength |
|---|---|---|---|
| Board.java | 84% (135/160) | 72% (104/145) | 85% (104/122) |
| Cell.java | 91% (20/22) | 81% (21/26) | 91% (21/23) |
| MainCLI.java | 0% (0/40) | 0% (0/21) | 100% (0/0) |