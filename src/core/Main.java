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
        GameEngine engine = new GameEngine();
        Shop merchant = new Shop();

        System.out.println("Welcome to Wonderland! A game of life, death, and chips.");

        // Floor 1: entities.MadHatter
        if (engine.startEncounter(alice, new MadHatter())) {
            merchant.visitShop(alice, mainScanner);
            // Floor 2: entities.CheshireCat
            System.out.println("\n--- YOU ENTER THE DARK FOREST ---");
            if (engine.startEncounter(alice, new CheshireCat())){
                merchant.visitShop(alice, mainScanner);
                // Floor 3: entities.Queen
                System.out.println("\n--- YOU ENTER THE ROYALE PALACE ---");
                if (engine.startEncounter(alice, new Queen())) {
                    System.out.println("\n===============================================");
                    System.out.println("👑 YOU BANKRUPTED THE QUEEN! YOU ESCAPED WONDERLAND! 👑");
                    System.out.println("Final Chips: " + alice.getChips());
                    System.out.println("===============================================");
                }
            }
        }
        System.out.println("\nThanks for playing!");
        mainScanner.close();
    }
}