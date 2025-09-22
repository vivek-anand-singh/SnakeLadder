# Snake and Ladder Game - UML Class Diagram

```
┌─────────────────────────────────────────────────────────────────────┐
│                          UML Class Diagram                         │
└─────────────────────────────────────────────────────────────────────┘

┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐
│    Player       │     │   Coordinate    │     │   Skipper       │
│   (abstract)    │     │                 │     │   (abstract)    │
├─────────────────┤     ├─────────────────┤     ├─────────────────┤
│ - id: String    │     │ - x: int        │     │ # start: Coord  │
│ - name: String  │     │ - y: int        │     │ # end: Coord    │
│ - position: int │     ├─────────────────┤     ├─────────────────┤
├─────────────────┤     │ + getX(): int   │     │ + canSkip(): bool│
│ + rollDice(): int│    │ + getY(): int   │     │ + getDest(): Coord│
│ + move(): void  │     │ + toPosition()  │     └─────────────────┘
│ + getCoord(): Coord│  │ + fromPosition()│              △
└─────────────────┘     └─────────────────┘              │
         △                                               │
         │                                               │
    ┌────┴────┐                                     ┌────┴────┐
    │         │                                     │         │
┌───▽────┐ ┌──▽──┐                              ┌───▽───┐ ┌──▽────┐
│Human   │ │ Bot │                              │ Snake │ │Ladder │
│Player  │ │     │                              │       │ │       │
├────────┤ ├─────┤                              ├───────┤ ├───────┤
│        │ │-diff│                              │       │ │       │
└────────┘ └─────┘                              └───────┘ └───────┘

┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐
│     Board       │     │     Game        │     │   GameRule      │
├─────────────────┤     ├─────────────────┤     │  (interface)    │
│ - size: int     │     │ - board: Board  │     ├─────────────────┤
│ - skippers: Map │     │ - players: List │     │ + canStart()    │
│ - winPos: int   │     │ - rule: GameRule│     │ + canEnd()      │
├─────────────────┤     │ - ended: bool   │     │ + shouldKill()  │
│ + movePlayer()  │     ├─────────────────┤     └─────────────────┘
│ + isWinning()   │     │ + playTurn()    │              △
│ + addSkipper()  │     │ + isEnded()     │              │
└─────────────────┘     │ + getWinner()   │    ┌─────────▽────────┐
                        └─────────────────┘    │StandardGameRule  │
                                               │                  │
┌─────────────────┐     ┌─────────────────┐    ├──────────────────┤
│DifficultyLevel  │     │ WinningStrategy │    │ - strategy: enum │
│    (enum)       │     │    (enum)       │    └──────────────────┘
├─────────────────┤     ├─────────────────┤
│ EASY            │     │ EXACT_MATCH     │    ┌─────────────────┐
│ MEDIUM          │     │ OVERFLOW_WIN    │    │  GameFactory    │
│ HARD            │     └─────────────────┘    │   (utility)     │
├─────────────────┤                            ├─────────────────┤
│ + getSnakes()   │                            │ + createGame()  │
│ + getLadders()  │                            │ - addSkippers() │
└─────────────────┘                            └─────────────────┘

Relationships:
- Player ──▷ HumanPlayer, Bot (inheritance)
- Skipper ──▷ Snake, Ladder (inheritance)
- GameRule ──▷ StandardGameRule (implementation)
- Game ──► Board, GameRule, Player (composition/aggregation)
- Board ──► Skipper, Coordinate (composition)
- Player ──► Coordinate (dependency)
```

## Key Design Patterns Used:
1. **Strategy Pattern**: GameRule interface with different implementations
2. **Factory Pattern**: GameFactory for creating game instances
3. **Template Method**: Skipper abstract class with common behavior
4. **Enum Pattern**: DifficultyLevel and WinningStrategy

## Core Components:
- **Coordinate System**: (x,y) coordinates mapped to board positions
- **Polymorphism**: Player hierarchy, Skipper hierarchy
- **Encapsulation**: Private fields with public accessors
- **Abstraction**: Abstract classes and interfaces
