package mechanics;

public class Card {
    private String rank; // Ej: "2", "10", "J", "Q", "K", "A"
    private int value;   // Ej: 2, 10, 10, 10, 10, 11
    private Suit suit;   // El enum que creamos antes

    public Card(String rank, int value, Suit suit) {
        this.rank = rank;
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
