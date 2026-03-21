package entities;
import core.GameEngine;
import mechanics.Deck;

public class MadHatter extends Player {
    public MadHatter() {
        super ("The Mad Hatter");
    }

    public void playTurn(Deck deck) {
        System.out.println("\n--- THE MAD HATTER'S TURN ---");
        GameEngine.pause(1000);
        this.showHand();

        while (this.calculateScore() < 15) {
            GameEngine.pause(1500);
            System.out.println("The Hatter nervously pours some tea and draws a card...");
            GameEngine.pause(1000);
            this.addCardToHand(deck.drawCard());
            this.showHand();
        }
        GameEngine.pause(2000);
    }
}
