package entities;
import core.DisplayManager;
import core.GameEngine;
import mechanics.Deck;

public class CheshireCat extends Player {
    public CheshireCat() {
        super ("The Cheshire Cat");
    }

    public void playTurn(Deck deck) {
        DisplayManager.type("\n--- THE CHESHIRE CAT'S TURN ---", 10);
        DisplayManager.pause(1000);
        this.showHand();

        while (this.calculateScore() < 18) {
            DisplayManager.pause(1500);
            DisplayManager.type("A wide grin appears in the dark... The Cat draws a card.", 10);
            DisplayManager.pause(1000);
            this.addCardToHand(deck.drawCard());
            this.showHand();
        }
        DisplayManager.pause(2000);
    }
}