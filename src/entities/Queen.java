package entities;
import core.DisplayManager;
import core.GameEngine;
import mechanics.Deck;

public class Queen extends Player {
    public Queen() {
        super ("Queen of Hearts");
    }

    public void playTurn(Deck deck) {
        DisplayManager.type("\n--- THE QUEEN OF HEARTS TURN ---", 10);
        DisplayManager.pause(1000);
        this.showHand();

        while (this.calculateScore() < 17) {
            DisplayManager.pause(1500);
            DisplayManager.type("Queen slams the table! 'Give me another card!'", 10);
            DisplayManager.pause(1000);
            this.addCardToHand(deck.drawCard());
            this.showHand();
        }
        DisplayManager.pause(2000);
    }
}
