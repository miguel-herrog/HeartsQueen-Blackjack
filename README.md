# 🃏 Heart's entities.Queen: Blackjack in Wonderland (v3.0 - The Tower)

A text-based, interactive console RPG game built purely in Java. Climb the Wonderland Tower by bankrupting a cast of iconic characters in high-stakes games of Blackjack, leading up to the final showdown with the entities.Queen of Hearts.

![Hearts entities.Queen Gameplay Demo](assets/gameplay.png)

## 🎯 Project Overview
This project showcases the evolution from a simple console script into a structured, scalable application. It demonstrates a strong understanding of **Object-Oriented Programming (OOP)**, software architecture, and robust error handling in Java.

### ✨ Key Features
* **The Boss Rush (Progression System):** Face three distinct opponents (The Mad Hatter, The Cheshire Cat, and The entities.Queen). You must bankrupt each boss to advance to the next floor.
* **Unique AI Behaviors:** Each boss features custom logic and risk tolerance. The Hatter stands at 15, the entities.Queen at 17, and the Cat gambles until 18.
* **Dedicated Game Engine:** A centralized `core.GameEngine` class dynamically handles the rules, pacing, and economy of any encounter regardless of the opponent.
* **Bulletproof Input Handling:** The betting phase is protected against invalid user inputs (letters, empty spaces) using structured `try-catch` blocks, preventing application crashes.
* **Dynamic Ace Logic:** Aces automatically adjust their value (11 or 1) to optimize the hand score.

## 🛠️ Tech Stack & Architecture
* **Language:** Java
* **OOP Principles Applied:**
  * **Inheritance & Polymorphism:** Opponents are subclasses of a base `entities.Player` class, overriding the `playTurn()` method to inject their unique logic while being processed identically by the `core.GameEngine`.
  * **Single Responsibility Principle (SRP):** Complete separation of concerns between game execution (`core.Main`), rule arbitration (`core.GameEngine`), and state management (`entities.Player`).
  * **Encapsulation:** Protected chip balances and isolated deck management.
* **Error Handling:** Implementation of `NumberFormatException` catching to sanitize standard input streams.

## 🚀 How to Play
1. Compile the Java files located in the `src` directory.
2. Run the `core.Main` class.
3. You start with 100 chips. Your goal is to drain the chips of the boss in front of you.
4. Place your bet, then type `H` to Hit or `S` to Stand.
5. Defeat the Mad Hatter, survive the Cheshire Cat, and bankrupt the entities.Queen of Hearts to escape Wonderland!