// Archivo: Card.java
public class Card {
    private String rank; // Ej: "2", "10", "J", "Q", "K", "A"
    private int value;   // Ej: 2, 10, 10, 10, 10, 11
    private Suit suit;   // El enum que creamos antes

    public Card(String rank, int value, Suit suit) {
        this.rank = rank;
        this.value = value;
        this.suit = suit;
    }

    // TODO: Crea los "getters" para rank, value y suit.

    // TODO: Sobrescribe el método toString() para que al imprimir la carta
    // se lea bonito, por ejemplo: "Q of HEARTS"
}
