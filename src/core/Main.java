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

        System.out.println(core.ArtManager.getArt("BlackJack In Wonderlands"));

        core.SaveManager saveManager = new core.SaveManager();
        int currentFloor = saveManager.loadGame(alice);

        GameEngine engine = new GameEngine();
        Shop merchant = new Shop();

        StoryManager.playIntro();
        DisplayManager.pause(1000);

        // --- Floor 1: Mad Hatter ---
        if (currentFloor <= 1) {
            StoryManager.playMadHatterIntro();

            if (!engine.startEncounter(alice, new MadHatter())) return;

            events.EventManager.rollForEvent(alice);
            merchant.visitShop(alice, mainScanner, 2);
        }

        // --- Floor 2: Cheshire Cat ---
        if (currentFloor <= 2) {
            StoryManager.playCheshireIntro();

            if (!engine.startEncounter(alice, new CheshireCat())) return;
            events.EventManager.rollForEvent(alice);
            merchant.visitShop(alice, mainScanner, 3);
        }

        // --- Floor 3: The Queen ---
        if (currentFloor <= 3) {
            StoryManager.playQueenIntro();

            if (engine.startEncounter(alice, new Queen())) {

                StoryManager.playVictory(alice.getChips());
                saveManager.deleteSave();
            }
        }

        DisplayManager.type("\nThanks for playing!");
        mainScanner.close();
    }
}