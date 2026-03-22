package entities;
import core.DisplayManager;
import core.GameEngine;
import mechanics.Deck;

public class MadHatter extends Player {
    public MadHatter() {
        super ("The Mad Hatter");
    }

    public void playTurn(Deck deck) {
        DisplayManager.type("\n--- THE MAD HATTER'S TURN ---");
        DisplayManager.pause(1000);
        this.showHand();

        while (this.calculateScore() < 15) {
            DisplayManager.pause(1500);
            DisplayManager.type("The Hatter nervously pours some tea and draws a card...");
            DisplayManager.pause(1000);
            this.addCardToHand(deck.drawCard());
            this.showHand();
        }
        DisplayManager.pause(2000);
    }
}
