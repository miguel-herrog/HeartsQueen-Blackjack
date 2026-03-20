# 🃏 Heart's Queen: Blackjack in Wonderland (v2.0)

A text-based, interactive console game built purely in Java. Challenge the Queen of Hearts to a high-stakes game of Blackjack where your head—and your chips—are on the line.

![Hearts Queen Gameplay Demo](assets/gameplay.png)

## 🎯 Project Overview
This project is continually evolving to solidify core concepts of **Object-Oriented Programming (OOP)**, logical structuring, and game loop mechanics in Java. It serves as a foundational milestone for my game development portfolio.

### ✨ Key Features
* **Casino Economy System:** Players start with a chip balance, place bets before each round, and manage their bankroll. The game continues until the player goes bankrupt.
* **Continuous Game Loop:** State management allows the deck to reset and hands to clear between rounds without restarting the application.
* **Classic Blackjack AI:** The Queen follows strict casino rules (must hit until 17).
* **Dynamic Ace Logic:** The algorithm automatically adjusts the value of Aces (11 or 1) to prevent the player or the AI from busting.
* **Game Feel:** Custom thread-pausing mechanics (`Thread.sleep`) are implemented to create pacing and suspense during the AI's turn and the final reveal.

## 🛠️ Tech Stack & Concepts
* **Language:** Java
* **Data Structures:** `ArrayList` for dynamic deck and hand management.
* **OOP Principles Applied:**
  * **Encapsulation:** Immutable `Card` objects and secure chip balance management.
  * **State Management:** Persisting player stats (chips) across multiple instances of the core game loop.
  * **Enums:** Type-safe definitions for card suits.

## 🚀 How to Play
1. Compile the Java files located in the `src` directory.
2. Run the `Main` class.
3. Place your bet from your starting balance of 100 chips.
4. Follow the console prompts, typing `H` to Hit (draw a card) or `S` to Stand.
5. Survive the Queen's turn, win your bets, and try not to go bankrupt!

## 🛣️ Future Roadmap (v3.0 - The Wonderland Tower)
* **Boss Rush Mechanics:** Implement inheritance to create distinct opponents (e.g., The Mad Hatter, The Cheshire Cat) with unique AI behaviors and minimum bets.
* **Narrative Progression:** Add a story mode with dialogue choices and a definitive win condition (escaping Wonderland).