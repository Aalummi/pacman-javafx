# Pac-Man JavaFX

A Pac-Man-style desktop game implemented in **Java** and **JavaFX** as a university group project focused on object-oriented software design.

This repository is a cleaned portfolio copy of the original project: generated build files, IDE metadata, local SDK binaries, backup archives, and duplicate development assets have been removed so the repository contains the source code and the files needed to build the application.

## What the project demonstrates

- Object-oriented Java application structure
- JavaFX rendering, animation, and keyboard input
- Game-state handling for normal, power, win, and game-over states
- Collision, movement, score, and life management
- Ghost chase/flee behaviour with separate implementations
- Resource-based level and sprite loading
- Use of patterns such as Builder and Singleton
- Collaborative Git/GitHub development in a three-person group project

## Project structure

```text
src/main/java/projectpacman/
├── Animator/       Rendering and animation
├── Board/          Board loading and parsing
├── GameLogic/      Core game state and update logic
├── GhostLogic/     Ghost behaviour and navigation
├── Initializer/    Game and UI setup
└── Player/         Player movement and interaction

src/main/resources/
├── fonts/
└── projectpacman/
    ├── levels/
    └── tiles/

docs/
├── uml.png
└── pacman-uml.drawio
```

## Requirements

- JDK 21
- Maven 3.9+

JavaFX dependencies are resolved by Maven; no local JavaFX SDK folder is required.

## Run

```bash
mvn clean javafx:run
```

## Build

```bash
mvn clean package
```

## Controls

Use either the **arrow keys** or **WASD** to move.

## UML

The final project UML diagram is available in [`docs/uml.png`](docs/uml.png). The editable draw.io source is included as [`docs/pacman-uml.drawio`](docs/pacman-uml.drawio).

## Project context

This was developed as a **three-person university group project**. If this repository is used in a CV or portfolio, individual contributions should be described separately rather than presenting the entire codebase as solo work.

## Asset notice

The project is an educational Pac-Man recreation and is not affiliated with Bandai Namco. Before publishing a public portfolio copy, verify that any third-party game sprites, fonts, or other assets included in `src/main/resources` may be redistributed.

## License

The original repository's MIT license is preserved in [`LICENSE`](LICENSE).
