package entities;

import core.DisplayManager;
import mechanics.Deck;
import mechanics.Card;

public class Queen extends Boss {

    public Queen() {
        super("Queen of Hearts", 1000);
    }

    @Override
    public void playTurn(Deck deck) {
        DisplayManager.pause(1000);
        DisplayManager.type("\n--- THE QUEEN'S ROYAL TURN ---", 20);

        // (Soft 17 rule)
        while (calculateScore() < 17) {
            DisplayManager.pause(1000);
            DisplayManager.type("Queen: \"Another card! And make it quick!\"", 30);

            Card drawnCard = deck.drawCard();
            addCardToHand(drawnCard);

            System.out.println("-> Queen draws: " + drawnCard.toString());
            DisplayManager.pause(500);
        }

        DisplayManager.pause(1000);
        int finalScore = calculateScore();

        if (finalScore > 21) {
            DisplayManager.type("Queen: \"NO! IMPOSSIBLE! WHO SHUFFLED THIS DECK?! EXECUTE THE DEALER!\" (BUSTS with " + finalScore + ")", 30);
        } else {
            DisplayManager.type("Queen: \"Read 'em and weep, Alice.\" (Stands with " + finalScore + ")", 30);
        }
    }
}