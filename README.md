# 🃏 Wonderland: A Game of Life, Death, and Chips

A terminal-based roguelike card game built entirely in Java. Face off against iconic denizens of Wonderland in a high-stakes, Blackjack-style combat system where your chips are your life.

## ✨ Features

* **Strategic Card Combat:** Push your luck against bosses like the Mad Hatter, the Cheshire Cat, and the Queen of Hearts.
* **Item Shop & Inventory:** Buy magical items (like *Mad Tea* or a *Rabbit's Foot*) to manipulate the rules of the game in your favor.
* **Persistent Save System:** Built from scratch using a custom Key-Value parser to save your chips, inventory, and floor progress seamlessly.
* **Permadeath Mechanic:** High stakes. If you go bankrupt, your save file is automatically wiped.
* **Factory Pattern Architecture:** Clean, modular code using an `ItemRegistry` to handle object creation dynamically.

## 🚀 How to Play

1. Make sure you have **Java (JRE)** installed on your system.
2. Download the `HeartsQueen.jar` and `run.bat` files.
3. Simply double-click `run.bat` (on Windows) to launch the game with the optimal terminal settings.
   *(Alternatively, run `java -jar HeartsQueen.jar` in your terminal).*

## 🛠️ Technical Details

* **Language:** Java 21 (or your specific version)
* **Paradigm:** Object-Oriented Programming (OOP)
* **Key Concepts Applied:** File I/O (`FileWriter`, `Scanner`), HashMap Registries, Error Handling, and scalable Game Loops.

---
*Created by Miguel.*