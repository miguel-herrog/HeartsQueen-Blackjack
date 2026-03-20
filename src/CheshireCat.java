public class CheshireCat extends Player {
    public CheshireCat() {
        super ("The Cheshire Cat");
    }

    public void playTurn(Deck deck) {
        System.out.println("\n--- THE CHESHIRE CAT'S TURN ---");
        GameEngine.pause(1000);
        this.showHand();

        while (this.calculateScore() < 18) {
            GameEngine.pause(1500);
            System.out.println("A wide grin appears in the dark... The Cat draws a card.");
            GameEngine.pause(1000);
            this.addCardToHand(deck.drawCard());
            this.showHand();
        }
        GameEngine.pause(2000);
    }
}