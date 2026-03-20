import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        Player alice = new Player("Alice");
        Player queen = new Player("Queen of Hearts");

        System.out.println("Welcome to Wonderland! The Queen challenges you to a game of life, death, and chips.");

        // --- THE GRAND CASINO LOOP ---
        // The game continues as long as Alice has at least 1 chip left to bet.
        while (alice.getChips() > 0) {
            System.out.println("\n=====================================");
            System.out.println("--- NEW ROUND ---");
            System.out.println("Your current chips: " + alice.getChips());
            System.out.println("How many chips do you dare to bet?");

            // --- THE BETTING PHASE ---
            int bet = scanner.nextInt();
            scanner.nextLine();

            // --- RESETTING THE TABLE ---
            alice.clearHand();
            queen.clearHand();
            deck = new Deck();
            deck.shuffle();

            // --- THE INITIAL DEAL ---
            alice.addCardToHand(deck.drawCard());
            alice.addCardToHand(deck.drawCard());

            queen.addCardToHand(deck.drawCard());
            queen.addCardToHand(deck.drawCard());

            alice.showHand();
            queen.showFirstCard();

            // --- ALICE'S TURN ---
            boolean isPlayerTurn = true;
            while (isPlayerTurn && alice.calculateScore() < 21) {
                System.out.println("Do you want to (H)it or (S)tand?");
                String choice = scanner.nextLine().toUpperCase();

                if (choice.equals("H")) {
                    System.out.println("Alice draws a card from the deck...");
                    alice.addCardToHand(deck.drawCard());
                    alice.showHand();
                } else if (choice.equals("S")) {
                    System.out.println("Alice decides to stand her ground.");
                    isPlayerTurn = false;
                } else {
                    System.out.println("The Mad Hatter interrupts: 'Invalid choice! Type H or S!'");
                }
            }

            // Check if Alice lost her head before the Queen even plays
            if (alice.calculateScore() > 21) {
                System.out.println("BUST! You went over 21. The Queen laughs as you lose your chips!");
                alice.adjustChips(-bet);
                pause(2000);
                continue; // Skip the Queen's turn and jump to the next round immediately
            }

            pause(2000);

            // --- THE QUEEN'S TURN ---
            System.out.println("\n--- THE QUEEN'S TURN ---");
            pause(1000);
            queen.showHand();

            while (queen.calculateScore() < 17) {
                pause(1500);
                System.out.println("The Queen demands another card...");
                pause(1000);
                queen.addCardToHand(deck.drawCard());
                queen.showHand();
            }

            pause(2000);

            // --- THE ROYAL VERDICT ---
            int playerScore = alice.calculateScore();
            int queenScore = queen.calculateScore();

            System.out.println("\n*** FINAL RESULTS ***");
            System.out.println("Alice's Score: " + playerScore);
            System.out.println("Queen's Score: " + queenScore);

            pause(1500);

            // Payout logic
            if (queenScore > 21) {
                System.out.println("The Queen busts! YOU SURVIVE AND WIN THE BET!");
                alice.adjustChips(bet);
            } else if (playerScore > queenScore) {
                System.out.println("You beat the Queen's score! YOU SURVIVE AND WIN THE BET!");
                alice.adjustChips(bet);
            } else if (playerScore == queenScore) {
                System.out.println("It's a tie! The Queen spares you... your chips are returned.");
                // No chips are added or lost
            } else {
                System.out.println("The Queen wins! You lose your bet!");
                alice.adjustChips(-bet);
            }
        }

        // --- GAME OVER ---
        System.out.println("\n*** BANKRUPT ***");
        System.out.println("You have 0 chips left. The Queen's guards drag you out of Wonderland!");
        scanner.close();
    }

    // Utility method to add pacing and suspense to the game flow
    public static void pause(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            System.out.println("Error pausing the game.");
        }
    }
}