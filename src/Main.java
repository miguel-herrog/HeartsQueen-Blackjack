// Archivo: Main.java (o Game.java)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        Player alice = new Player("Alice");
        Player queen = new Player("Queen of Hearts");

        System.out.println("Welcome to Wonderland! The Queen challenges you to Blackjack.");

        deck.shuffle();

        // TODO: Lógica principal del juego
        // 1. Repartir 2 cartas a Alice y 2 a la Queen.
        // 2. Bucle do-while preguntando a Alice si quiere "Hit" (robar) o "Stand" (plantarse).
        // 3. Turno de la IA (la Reina debe robar carta mientras su score sea menor a 17).
        // 4. Determinar quién gana y mostrar el resultado.

        scanner.close();
    }
}
