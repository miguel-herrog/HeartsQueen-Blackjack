// Archivo: Player.java
import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private int chips;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.chips = 100;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public int calculateScore() {
        int score = 0, aces = 0;

        for (Card h : hand){
            score += h.getValue();

            if (h.getRank().equals("A")){
                aces += 1;
            }
        }
        while (score > 21 && aces > 0){
            score -= 10;
            aces -= 1;
        }
        return score;
    }

    public void showHand() {
        System.out.println("--- " + name + "'s Hand ---");
        for (Card c : hand) {
            System.out.println("- " + c);
        }
        System.out.println("Current Score: " + calculateScore());
        System.out.println("-------------------");
    }

    public void showFirstCard() {
        System.out.println("--- " + name + "'s Hand ---");
        System.out.println("- " + hand.get(0));
        System.out.println("- [Hidden Card]");
        System.out.println("-------------------");
    }

    public int getChips() {
        return chips;
    }

    public void adjustChips(int amount) {
        this.chips += amount;
    }

    public void clearHand() {
        this.hand.clear();
    }
}