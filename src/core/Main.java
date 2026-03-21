package core;
import entities.CheshireCat;
import entities.MadHatter;
import entities.Player;
import entities.Queen;
import items.Shop;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner mainScanner = new Scanner(System.in);
        Player alice = new Player("Alice");

        core.SaveManager saveManager = new core.SaveManager();
        int currentFloor = saveManager.loadGame(alice);

        GameEngine engine = new GameEngine();
        Shop merchant = new Shop();

        System.out.println("Welcome to Wonderland! A game of life, death, and chips.");

        // --- Floor 1: Mad Hatter ---
        if (currentFloor <= 1) {
            if (!engine.startEncounter(alice, new MadHatter())) return;
            merchant.visitShop(alice, mainScanner, 2);
        }

        // --- Floor 2: Cheshire Cat ---
        if (currentFloor <= 2) {
            System.out.println("\n--- YOU ENTER THE DARK FOREST ---");
            if (!engine.startEncounter(alice, new CheshireCat())) return;
            merchant.visitShop(alice, mainScanner, 3);
        }

        // --- Floor 3: The Queen ---
        if (currentFloor <= 3) {
            System.out.println("\n--- YOU ENTER THE ROYALE PALACE ---");
            if (engine.startEncounter(alice, new Queen())) {
                System.out.println("\n===============================================");
                System.out.println("👑 YOU BANKRUPTED THE QUEEN! YOU ESCAPED WONDERLAND! 👑");
                System.out.println("Final Chips: " + alice.getChips());
                System.out.println("===============================================");

                saveManager.deleteSave();
            }
        }

        System.out.println("\nThanks for playing!");
        mainScanner.close();
    }
}