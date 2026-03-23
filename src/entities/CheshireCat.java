package entities;

import core.DisplayManager;
import mechanics.Deck;
import mechanics.Card;
import java.util.Random;

public class CheshireCat extends Boss {

    private Random random;

    public CheshireCat() {
        super("The Cheshire Cat", 400);
        this.random = new Random();
    }

    @Override
    public void playTurn(Deck deck, Player opponent) {
        DisplayManager.pause(1000);
        DisplayManager.type("\n--- THE CAT'S ENIGMATIC TURN ---", 20);

        int standLimit = 14 + random.nextInt(5);

        while (calculateScore() < standLimit) {
            DisplayManager.pause(1000);

            if (random.nextBoolean()) {
                DisplayManager.type("Cheshire Cat: \"We're all mad here...\"", 30);
            } else {
                DisplayManager.type("Cheshire Cat smiles, slowly fading into the darkness...", 30);
            }

            Card drawnCard = deck.drawCard();
            addCardToHand(drawnCard);

            System.out.println("-> Cat draws: " + drawnCard.toString());
            DisplayManager.pause(500);
        }

        DisplayManager.pause(1000);
        int finalScore = calculateScore();

        if (finalScore > 21) {
            DisplayManager.type("Cheshire Cat: \"Oops... I seem to have lost my head before the Queen could take it!\" (BUSTS with " + finalScore + ")", 30);
        } else {
            DisplayManager.type("Cheshire Cat: \"A purr-fect hand...\" (Stands with " + finalScore + ")", 30);
        }
    }
}