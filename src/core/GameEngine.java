package core;
import entities.Player;
import mechanics.Deck;
import java.util.Scanner;

public class GameEngine {
    private Scanner scanner;

    public GameEngine() {
        this.scanner = new Scanner(System.in);
    }

    // Utility method to add pacing and suspense to the game flow
    public static void pause(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            System.out.println("Error pausing the game.");
        }
    }

    public boolean startEncounter(Player player, Player boss) {

        System.out.println("\n*** A new challenger approaches: " + boss.getName() + "! ***");

        while (player.getChips() > 0 && boss.getChips() > 0) {
            System.out.println("\n=====================================");
            System.out.println("--- NEW ROUND VS " + boss.getName().toUpperCase() + " ---");
            System.out.println("Your current chips: " + player.getChips());
            System.out.println(boss.getName() + "'s chips: " + boss.getChips());
            System.out.println("How many chips do you dare to bet?");

            // --- THE BETTING PHASE ---
            int bet =  0;
            boolean validBet = false;

            while (!validBet) {
                try {
                    String input = scanner.nextLine();
                    bet = Integer.parseInt(input);

                    if (bet > player.getChips() || bet <= 0) {
                        System.out.println("Not so fast, Alice! You can't bet what you don't have.");
                        System.out.println("You have " + player.getChips() + " chips. Try again:");
                    } else {
                        validBet = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(boss.getName() + " laughs: 'That's not a number!'");
                    System.out.println("Please, enter a valid number of chips to bet:");
                }
            }

            // --- RESETTING THE TABLE ---
            player.clearHand();
            boss.clearHand();
            Deck deck = new Deck();
            deck.shuffle();

            // --- THE INITIAL DEAL ---
            player.addCardToHand(deck.drawCard());
            player.addCardToHand(deck.drawCard());

            boss.addCardToHand(deck.drawCard());
            boss.addCardToHand(deck.drawCard());

            player.showHand();
            boss.showFirstCard();

            // --- ALICE'S TURN ---
            boolean usedRabbit = false;
            boolean isPlayerTurn = true;
            while (isPlayerTurn && player.calculateScore() < 21) {
                System.out.println("Do you want to (H)it, (S)tand or open (I)nventory?");
                String choice = scanner.nextLine().toUpperCase();

                switch (choice) {
                    case "H" -> {
                        System.out.println(player.getName() + " draws a card from the deck...");
                        player.addCardToHand(deck.drawCard());
                        player.showHand();
                    }
                    case "S" -> {
                        System.out.println(player.getName() + " decides to stand her ground.");
                        isPlayerTurn = false;
                    }
                    case "I" -> {
                        System.out.println(player.getName() + " decides to see her inventory.");
                        player.openInventory(scanner);

                        System.out.println("\n--- BACK TO THE TABLE ---");
                        System.out.println(player.getName() + "'s score is: " + player.calculateScore());
                    }
                    default -> System.out.println("Invalid choice! Type H, S or I!");
                }

            }

            // Check if Alice lost her head before the boss even plays
            if (player.calculateScore() > 21) {
                if (player.consumeItem("Rabbit's Foot")) {
                    System.out.println("\n✨ THE RABBIT'S FOOT GLOWS! ✨");
                    System.out.println("It crumbles to dust, but it saves you from busting!");
                    System.out.println("Your score is magically locked at 21. Your turn ends.");
                    usedRabbit = true;
                } else {
                    System.out.println("BUST! You went over 21. " + boss.getName() + " laughs as you lose your chips!");
                    player.adjustChips(-bet);
                    pause(2000);
                    continue; // Skip the boss's turn and jump to the next round immediately
                }
            }
            pause(2000);

            // --- THE BOSS'S TURN ---
            boss.playTurn(deck);

            // --- THE VERDICT ---
            int playerScore = player.calculateScore();
            if (usedRabbit) {
                playerScore = 21;
            }
            int bossScore = boss.calculateScore();

            System.out.println("\n*** FINAL RESULTS ***");
            System.out.println(player.getName() + "'s Score: " + playerScore);
            System.out.println(boss.getName() + "'s Score: " + bossScore);

            pause(1500);

            // Payout logic
            if (bossScore > 21) {
                System.out.println(boss.getName() + " busts! YOU SURVIVE AND WIN THE BET!");
                player.adjustChips(bet);
                boss.adjustChips(-bet);
            } else if (playerScore > bossScore) {
                System.out.println("You beat " + boss.getName() + "'s score! YOU SURVIVE AND WIN THE BET!");
                player.adjustChips(bet);
                boss.adjustChips(-bet);
            } else if (playerScore == bossScore) {
                System.out.println("It's a tie! " + boss.getName() + " spares you... your chips are returned.");
                // No chips are added or lost
            } else {
                System.out.println(boss.getName() + " wins! You lose your bet!");
                player.adjustChips(-bet);
                boss.adjustChips(bet);
            }
        }

        // --- END OF THE ENCOUNTER ---
        if (player.getChips() <= 0) {
            System.out.println("\n*** BANKRUPT ***");
            System.out.println(boss.getName() + " took all your chips! The guards drag you away.");
            return false; // Perdiste
        } else {
            System.out.println("\n*** VICTORY! ***");
            System.out.println("You bankrupted " + boss.getName() + "! You advance to the next floor.");
            return true; // Ganaste
        }
    }
}