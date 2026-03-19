// Archivo: Deck.java
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        // TODO: Llama a un método privado aquí para inicializar las 52 cartas
    }

    private void initializeDeck() {
        // TODO: Usa bucles para crear todas las cartas y añadirlas al ArrayList 'cards'
    }

    public void shuffle() {
        // TODO: Usa Collections.shuffle() para mezclar la baraja
    }

    public Card drawCard() {
        // TODO: Saca la primera carta (índice 0) del ArrayList, elimínala de la lista y devuélvela.
        return null; // Cambia esto cuando implementes la lógica
    }
}
