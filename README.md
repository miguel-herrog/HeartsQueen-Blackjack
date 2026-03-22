# 🎩 Blackjack in Wonderland: A Console-Based Java RPG

![Java Version](https://img.shields.io/badge/Java-17%2B-blue)
![Architecture](https://img.shields.io/badge/Architecture-Data--Driven-success)
![Status](https://img.shields.io/badge/Status-Playable-brightgreen)

Blackjack in Wonderland is a text-based Role Playing Game built entirely in pure Java, running directly in the console.

Rather than relying on external game engines, this project was developed from scratch with a strong focus on **Object-Oriented Programming (OOP)**, **clean architecture**, and **scalable software design patterns**. It serves as a technical showcase of core backend development principles.

---

## 🏗️ Architecture & Design Patterns

This project was built to be easily maintainable and highly scalable. Key architectural decisions include:

* **Data-Driven Design (Events System):** Random encounters are not hardcoded. The `EventManager` dynamically parses an external `events.txt` file at runtime. This completely decouples the event logic from the Java codebase, allowing designers to add hundreds of new events without altering a single line of code, strictly adhering to the **Open/Closed Principle (SOLID)**.
* **Factory & Registry Patterns (Dynamic Shop):** In-game items are managed through an `ItemRegistry`. The `Shop` class generates its inventory dynamically by requesting random registered IDs from the Factory, ensuring the Shop logic remains completely agnostic of the actual item implementations.
* **Single Responsibility Principle (UI & Visuals):** * **`DisplayManager`**: Handles the "Game Feel", creating a custom typewriter effect and managing execution pauses.
    * **`ArtManager`**: Uses `HashMap` data structures to store and retrieve ASCII art with O(1) time complexity, keeping the core game engine free of visual clutter.

---

## 📸 Screenshots

*(Add your screenshots here! Take a picture of the Mad Hatter ASCII art, the typewriter text, and the shop menu)*

![Gameplay Screenshot 1](link_to_your_image_here.png)
*Entering Floor 1: The Mad Hatter encounter.*

![Gameplay Screenshot 2](link_to_your_image_here.png)
*The Dynamic Shop system generating random items.*

---

## 🚀 How to Play

No IDE is required to play. The game is packaged as an executable `.jar` file.

1. Download the latest release folder containing:
    * `HeartsQueen.jar` (The game engine)
    * `events.txt` (The data-driven event database)
    * `run.bat` (The Windows launcher)
2. Ensure all three files are in the same directory.
3. Double-click **`run.bat`** to start your journey into Wonderland.

---

## 🗺️ Roadmap & Next Steps

This project is continuously evolving. Upcoming technical milestones include:

- [ ] **Unit Testing:** Implement `JUnit` tests to verify the `ItemRegistry` and Shop logic.
- [ ] **Database Integration:** Migrate the `.txt` save file system to a lightweight `SQLite` database.
- [ ] **Advanced Error Handling:** Implement custom Exception classes for corrupted save files.

---
*Developed by Miguel.*