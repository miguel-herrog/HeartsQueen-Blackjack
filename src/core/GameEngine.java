package core;
import entities.Player;
import mechanics.Deck;
import java.util.Scanner;

public class GameEngine {
    private Scanner scanner;
    core.SaveManager saveManager = new core.SaveManager();

    public GameEngine() {
        this.scanner = new Scanner(System.in);
    }

    public boolean startEncounter(Player player, Player boss) {

        DisplayManager.type("\n*** A new challenger approaches: " + boss.getName() + "! ***", 50);
        System.out.println(core.ArtManager.getArt(boss.getName()));

        while (player.getChips() > 0 && boss.getChips() > 0) {
            System.out.println("\n=====================================");
            DisplayManager.type("--- NEW ROUND VS " + boss.getName().toUpperCase() + " ---");
            DisplayManager.type("Your current chips: " + player.getChips());
            DisplayManager.type(boss.getName() + "'s chips: " + boss.getChips());
            DisplayManager.type("How many chips do you dare to bet?");

            // --- THE BETTING PHASE ---
            int bet =  0;
            boolean validBet = false;

            while (!validBet) {
                try {
                    String input = scanner.nextLine();
                    bet = Integer.parseInt(input);

                    if (bet > player.getChips() || bet <= 0) {
                        DisplayManager.type("Not so fast, Alice! You can't bet what you don't have.");
                        DisplayManager.type("You have " + player.getChips() + " chips. Try again:");
                    } else {
                        validBet = true;
                    }
                } catch (NumberFormatException e) {
                    DisplayManager.type(boss.getName() + " laughs: 'That's not a number!'");
                    DisplayManager.type("Please, enter a valid number of chips to bet:");
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
                DisplayManager.type("Do you want to (H)it, (S)tand or open (I)nventory?");
                String choice = scanner.nextLine().toUpperCase();

                switch (choice) {
                    case "H" -> {
                        DisplayManager.type(player.getName() + " draws a card from the deck...");
                        player.addCardToHand(deck.drawCard());
                        player.showHand();
                    }
                    case "S" -> {
                        DisplayManager.type(player.getName() + " decides to stand her ground.");
                        isPlayerTurn = false;
                    }
                    case "I" -> {
                        DisplayManager.type(player.getName() + " decides to see her inventory.");
                        player.openInventory(scanner);

                        System.out.println("\n--- BACK TO THE TABLE ---");
                        DisplayManager.type(player.getName() + "'s score is: " + player.calculateScore());
                    }
                    default -> DisplayManager.type("Invalid choice! Type H, S or I!");
                }

            }

            // Check if Alice lost her head before the boss even plays
            if (player.calculateScore() > 21) {
                if (player.consumeItem("Rabbit's Foot")) {
                    usedRabbit = true;
                } else {
                    DisplayManager.type("BUST! You went over 21. " + boss.getName() + " laughs as you lose your chips!");
                    player.adjustChips(-bet);
                    DisplayManager.pause(2000);
                    continue; // Skip the boss's turn and jump to the next round immediately
                }
            }
            DisplayManager.pause(2000);

            // --- THE BOSS'S TURN ---
            boss.playTurn(deck);

            // --- THE VERDICT ---
            int playerScore = player.calculateScore();
            if (usedRabbit) {
                playerScore = 21;
            }
            int bossScore = boss.calculateScore();

            System.out.println("\n*** FINAL RESULTS ***");
            DisplayManager.type(player.getName() + "'s Score: " + playerScore);
            DisplayManager.type(boss.getName() + "'s Score: " + bossScore);

            DisplayManager.pause(1500);

            // Payout logic
            if (bossScore > 21) {
                DisplayManager.type(boss.getName() + " busts! YOU SURVIVE AND WIN THE BET!");
                player.adjustChips(bet);
                boss.adjustChips(-bet);
            } else if (playerScore > bossScore) {
                DisplayManager.type("You beat " + boss.getName() + "'s score! YOU SURVIVE AND WIN THE BET!");
                player.adjustChips(bet);
                boss.adjustChips(-bet);
            } else if (playerScore == bossScore) {
                DisplayManager.type("It's a tie! " + boss.getName() + " spares you... your chips are returned.");
                // No chips are added or lost
            } else {
                DisplayManager.type(boss.getName() + " wins! You lose your bet!");
                player.adjustChips(-bet);
                boss.adjustChips(bet);
            }
        }

        // --- END OF THE ENCOUNTER ---
        if (player.getChips() <= 0) {
            System.out.println("\n*** BANKRUPT ***");
            DisplayManager.type(boss.getName() + " took all your chips! The guards drag you away.");
            saveManager.deleteSave();
            return false; // You Lost

        } else {
            System.out.println("\n*** VICTORY! ***");
            DisplayManager.type("You bankrupted " + boss.getName() + "! You advance to the next floor.");
            return true; // You Won
        }
    }
}