# 🃏 Heart's Queen: Blackjack in Wonderland

A text-based, interactive console game built purely in Java. Challenge the Queen of Hearts to a high-stakes game of Blackjack where your head is on the line.

![Hearts Queen Gameplay Demo](assets/gameplay.png)

## 🎯 Project Overview
This project was developed to solidify core concepts of **Object-Oriented Programming (OOP)**, logical structuring, and game loop mechanics in Java. It serves as a foundational milestone for my game development portfolio.

### ✨ Key Features
* **Classic Blackjack AI:** The Queen follows strict casino rules (must hit until 17).
* **Dynamic Ace Logic:** The algorithm automatically adjusts the value of Aces (11 or 1) to prevent the player or the AI from busting.
* **Game Feel:** Custom thread-pausing mechanics (`Thread.sleep`) are implemented to create pacing and suspense during the AI's turn and the final reveal.
* **Robust Input Handling:** Safe `Scanner` implementation with string normalization to prevent game crashes on invalid user inputs.

## 🛠️ Tech Stack & Concepts
* **Language:** Java
* **Data Structures:** `ArrayList` for dynamic deck and hand management.
* **OOP Principles Applied:**
    * **Encapsulation:** Immutable `Card` objects with controlled access.
    * **Enums:** Type-safe definitions for card suits.
    * **Polymorphism:** Overridden `toString()` methods for clean console UI rendering.

## 🚀 How to Play
1. Compile the Java files located in the `src` directory.
2. Run the `Main` class.
3. Follow the console prompts, typing `H` to Hit (draw a card) or `S` to Stand.
4. Don't go over 21, and beat the Queen's score to survive!

## 🛣️ Future Roadmap (v2.0)
* **Narrative Expansion:** Implement a story mode with dialogue choices before the match.
* **Quest System:** Add progression and multiple opponents from the Wonderland universe.
* **Betting Mechanics:** Introduce a chip system for multiple rounds.