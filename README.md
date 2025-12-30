# Minesweeper Game (BombSweeper)

A fully functional Minesweeper clone built in Java with a graphical interface, demonstrating object-oriented design, recursive algorithms, and event-driven programming.

## Overview

**Why this matters:**
- Implemented classic game logic including flood-fill recursion for auto-revealing empty spaces
- Designed extensible OOP architecture using abstract classes and inheritance
- Built event-driven GUI with interactive grid (50×50 = 2,500 clickable squares)
- Applied recursive algorithms to solve the "chain reaction" reveal mechanic

**Key skills demonstrated:**
Java • Object-Oriented Programming • Recursion • Event-Driven Programming • Swing/AWT • Game Logic • Algorithm Design

Built to demonstrate problem-solving with recursion, clean OOP architecture, and GUI development. Shows practical application of data structures (2D arrays), algorithms (flood-fill), and user interaction patterns common in game development and interactive applications.

---

## Technical Highlights

### Game Logic & Algorithms
- **Recursive Flood-Fill**: Automatically reveals connected empty squares when clicking a space with no adjacent bombs
- **Neighbor Detection**: Calculates bomb counts by checking all 8 surrounding squares using coordinate arrays
- **Randomized Bomb Placement**: 10% probability per square creates varied gameplay experiences
- **Click State Management**: Prevents re-clicking squares to avoid infinite recursion

### Object-Oriented Design
- **Abstract Base Class**: `GameSquare` defines interface for all grid squares
- **Concrete Implementation**: `BombSquare` handles game-specific logic (bombs, clicks, recursion)
- **Separation of Concerns**: `GameBoard` manages grid, `BombSquare` handles individual square behavior
- **Polymorphism**: All squares treated uniformly through base class reference

### GUI & Event Handling
- **Interactive Grid**: 50×50 board = 2,500 individual clickable buttons
- **Event-Driven Architecture**: ActionListener pattern for user clicks
- **Dynamic Image Updates**: Changes square images based on game state (blank → number/bomb)
- **Responsive Layout**: GridLayout automatically arranges squares

---

## Quick Start
```bash
javac *.java
java Driver
```

Click any square to start. Numbers show adjacent bombs. Blank squares auto-reveal connected safe areas. Click a bomb and you lose!

---

## Project Structure
```
GameSquare (abstract base)
└── BombSquare (concrete implementation)

GameBoard (manages grid + events)
Driver (entry point)
```

- `Driver.java` — Launches the game (3 lines)
- `GameBoard.java` — Grid manager, creates 50×50 board, handles click events
- `GameSquare.java` — Abstract base class defining square interface
- `BombSquare.java` — Game logic: bomb placement, neighbor checking, recursive reveal

---

## Key Implementation Details

### Recursive Space Reveal
When clicking an empty square (0 adjacent bombs):
```java
1. Mark square as clicked
2. Check all 8 neighbors
3. If neighbor is safe and unclicked → recursively click it
4. Chain reaction reveals entire connected safe region
```

### Neighbor Detection Algorithm
Uses coordinate offset array to check all 8 directions:
```java
int[][] offsets = { {-1,1}, {0,1}, {1,1},
                    {-1,0},        {1,0},
                    {-1,-1},{0,-1},{1,-1} };
```

### Bomb Probability
- Each square has 1 in 10 chance (10%) of containing a bomb
- `Random.nextInt(10) == 0` generates randomized board layouts
- Average ~250 bombs per 50×50 board

---

## Technologies

**Core:** Java SE, Swing (JFrame, JButton, JPanel), AWT (ActionListener, GridLayout)

**Concepts:** Object-oriented programming (abstraction, inheritance, polymorphism), recursion, event-driven architecture, 2D arrays, algorithm design (flood-fill)

---

## Game Features

✅ **Classic Minesweeper Mechanics**
- Click to reveal squares
- Numbers show adjacent bomb counts (1-8)
- Empty squares trigger chain reactions
- Clicking bombs reveals game over

✅ **Visual Feedback**
- Blank squares (unclicked state)
- Number images (1-8 adjacent bombs)
- Bomb image (game over)
- 0 image (safe square, triggers flood-fill)

✅ **Scalable Architecture**
- Easy to adjust board size (currently 50×50)
- Configurable bomb probability (10%)
- Extensible for features like flags, timers, difficulty levels

---

## What I Learned

- **Recursion in Practice**: Implementing flood-fill algorithm with base cases and preventing infinite loops
- **OOP Design**: When to use abstract classes vs concrete implementations
- **Event-Driven Programming**: Handling user interactions with ActionListener pattern
- **Algorithm Optimization**: Checking bounds before array access, preventing redundant operations
- **State Management**: Tracking clicked squares to control game flow

---

## Code Architecture Highlights

### Abstract Base Class Pattern
`GameSquare` defines the contract, `BombSquare` implements specifics:
```java
public abstract class GameSquare extends JButton {
    protected int xLocation, yLocation;
    protected GameBoard board;
    public abstract void clicked(); // Subclasses define behavior
}
```

### Type Casting for Polymorphism
Uses downcasting to access subclass methods while maintaining flexibility:
```java
BombSquare square = (BombSquare) board.getSquareAt(x, y);
if (square != null && square.thisSquareHasBomb) { ... }
```

### Coordinate Array Technique
Elegant way to iterate through neighbors without 8 separate if-statements:
```java
for (int[] offset : coordinates) {
    int newX = xLocation + offset[0];
    int newY = yLocation + offset[1];
    // Check neighbor at (newX, newY)
}
```

---

## Requirements

- Java JDK 8+
- Image files in `images/` folder: blank.png, bomb.png, 0.png through 8.png
- Any OS (Windows/Mac/Linux)

---

<details>
<summary><strong>Technical Details (Expand for deep dive)</strong></summary>

### Recursion Base Cases
- Square already clicked → return immediately
- Square contains bomb → show bomb, end recursion
- Square has adjacent bombs → show number, end recursion
- Square has 0 adjacent bombs → show 0, recursively check all 8 neighbors

### Memory Efficiency
- Click state tracked with boolean flag per square
- Early return prevents redundant recursion
- 2D array provides O(1) square lookup

### Board Dimensions
- 50×50 grid = 2,500 total squares
- Average 250 bombs (10% probability)
- Window size: 1020×1020 pixels (20px per square + margins)

### Game State
- Bomb locations determined at initialization (Random object)
- No global game state tracking (distributed across squares)
- Each square manages own state independently

</details>

---

*This project demonstrates proficiency in recursive algorithms, object-oriented design, event-driven programming, and GUI development — skills directly applicable to software engineering and game development roles.*
