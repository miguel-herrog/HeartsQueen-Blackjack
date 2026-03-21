package entities;
import core.GameEngine;
import mechanics.Deck;

public class Queen extends Player {
    public Queen() {
        super ("The entities.Queen of Hearts");
    }

    public void playTurn(Deck deck) {
        System.out.println("\n--- THE QUEEN OF HEARTS TURN ---");
        GameEngine.pause(1000);
        this.showHand();

        while (this.calculateScore() < 17) {
            GameEngine.pause(1500);
            System.out.println("The entities.Queen slams the table! 'Give me another card!'");
            GameEngine.pause(1000);
            this.addCardToHand(deck.drawCard());
            this.showHand();
        }
        GameEngine.pause(2000);
    }
}
