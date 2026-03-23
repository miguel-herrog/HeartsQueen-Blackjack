package entities;

import core.DisplayManager;
import mechanics.Deck;
import mechanics.Card;

public class MadHatter extends Boss {
    public MadHatter() {
        super("The Mad Hatter", 200);
    }

    @Override
    public void playTurn(Deck deck, Player opponent) {
        DisplayManager.pause(1000);
        DisplayManager.type("\n--- THE HATTER'S CHAOTIC TURN ---", 20);



        while (calculateScore() <= 17) {
            DisplayManager.pause(1000);
            DisplayManager.type("Mad Hatter: \"More tea! MORE CARDS!\"", 30);

            Card drawnCard = deck.drawCard();
            addCardToHand(drawnCard);

            System.out.println("-> Hatter draws: " + drawnCard.toString());
            DisplayManager.pause(500);
        }

        DisplayManager.pause(1000);
        int finalScore = calculateScore();

        if (finalScore > 21) {
            DisplayManager.type("Mad Hatter: \"Oh dear... my hat is too tight...\" (BUSTS with " + finalScore + ")", 30);
        } else {
            DisplayManager.type("Mad Hatter: \"I'm perfectly fine! Your turn, Alice!\" (Stands with " + finalScore + ")", 30);
        }
    }
}
