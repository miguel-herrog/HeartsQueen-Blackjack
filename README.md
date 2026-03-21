# 🃏 Heart's Queen: Blackjack in Wonderland

A text-based, interactive console RPG built purely in Java. Climb the Wonderland Tower by bankrupting a cast of iconic characters in high-stakes games of Blackjack, buy powerful items at the merchant, and survive the final showdown with the Queen of Hearts.

## 🎯 Project Overview
This project showcases a complete Object-Oriented application, evolving from a simple game loop into a structured, scalable RPG architecture. It demonstrates advanced Java concepts including package management, inheritance, and robust error handling.

### ✨ Key Features
* **The Boss Rush:** Face three distinct opponents (The Mad Hatter, The Cheshire Cat, and The Queen) with unique AI risk logic. Bankrupt them to advance!
* **Dynamic Economy & The Shop:** Earn chips by winning hands and spend them at the Mysterious Merchant's shop between floors.
* **Interactive Combat Inventory:** Access your backpack mid-game to turn the tides of the match.
* **Active & Passive Items:**
    * *Mad Tea (Active):* Drink it during your turn for an instant chip boost.
    * *Rabbit's Foot (Passive):* Automatically triggers to save you from a fatal bust (going over 21).
* **Bulletproof Inputs:** Comprehensive `try-catch` blocks protect the game engine from crashing against invalid user inputs.

## 🛠️ Tech Stack & Architecture
* **Language:** Java
* **Package Structure:** Organized for enterprise-level scalability:
    * `core/`: Game loop (`Main`) and rule arbitration (`GameEngine`).
    * `entities/`: Player and AI Bosses (`Player`, `MadHatter`, `Queen`, etc.).
    * `items/`: Shop logic, Inventory management, and the `Item` inheritance tree.
    * `mechanics/`: Core physical elements (`Card`, `Deck`).
* **OOP Principles Applied:**
    * **Inheritance & Polymorphism:** Items and Bosses inherit from abstract/base classes, overriding methods to inject unique mechanics (`applyEffect()`, `playTurn()`) without bloating the main engine.
    * **Single Responsibility Principle (SRP):** Strict separation between UI prompts, game rules, and entity state management.

## 🚀 How to Play
1. Clone the repository and open it in your preferred IDE (e.g., IntelliJ IDEA).
2. Ensure your IDE recognizes the `src` directory as the project's Source Root.
3. Run the `Main.java` file located inside the `core` package.
4. You start with 100 chips. Place your bets, choose to (H)it, (S)tand, or open your (I)nventory.
5. Buy upgrades, outsmart the AI, and escape Wonderland!