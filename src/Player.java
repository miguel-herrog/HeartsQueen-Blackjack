// Archivo: Player.java
import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addCardToHand(Card card) {
        // TODO: Añade la carta recibida al ArrayList 'hand'
    }

    public int calculateScore() {
        int score = 0;
        // TODO: Recorre la mano y suma los valores. 
        // RETO: Añade la lógica para que el As ("A") valga 1 en lugar de 11 si el score se pasa de 21.
        return score;
    }

    public void showHand() {
        // TODO: Imprime por consola las cartas que tiene el jugador actualmente
    }
}