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

        // Initial Deal
        alice.addCardToHand(deck.drawCard());
        alice.addCardToHand(deck.drawCard());

        queen.addCardToHand(deck.drawCard());
        queen.addCardToHand(deck.drawCard());

        alice.showHand();

        queen.showFirstCard();

        // Player's turn
        boolean isPlayerTurn = true;
        while (isPlayerTurn &&  alice.calculateScore() < 21){
            System.out.println("Do you want to (H)it or (S)tand?");
            String choice = scanner.nextLine().toUpperCase();

            if (choice.equals("H")){
                System.out.println("You draw a card...");
                alice.addCardToHand(deck.drawCard());
                alice.showHand();
            } else if (choice.equals("S")) {
                System.out.println("You stand.");
                isPlayerTurn = false;
            } else {
                System.out.println("Invalid input. Type H or S.");
            }
        }

        if (alice.calculateScore() > 21) {
            System.out.println("BUST! You went over 21. The Queen chops off your head! GAME OVER.");
            scanner.close();
            return;
        }

        pause(2000);

        // Queen's turn
        System.out.println("\n--- QUEEN's TURN ---");
        pause(1000);
        queen.showHand();

        while (queen.calculateScore() < 17) {
            pause(1500);
            System.out.println("The Queen draws a card...");
            pause(1000);
            queen.addCardToHand(deck.drawCard());
            queen.showHand();
        }

        // Determine the winner
        pause(2000);

        int playerScore = alice.calculateScore();
        int queenScore = queen.calculateScore();

        System.out.println("\n*** FINAL RESULTS ***");
        System.out.println("Alice's Score: " + playerScore);
        System.out.println("Queen's Score: " + queenScore);

        pause(1500);

        if (queenScore > 21) {
            System.out.println("The Queen busts! YOU SURVIVE!");
        } else if (playerScore > queenScore) {
            System.out.println("You beat the Queen! YOU SURVIVE!");
        } else if (playerScore == queenScore) {
            System.out.println("It's a tie! The Queen spares you... for now.");
        } else {
            System.out.println("The Queen wins! OFF WITH YOUR HEAD!");
        }
        scanner.close();
    }
}
