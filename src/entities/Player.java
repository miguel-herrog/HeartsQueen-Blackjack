package entities;
import items.Item;
import mechanics.Card;
import mechanics.Deck;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private ArrayList<Item> inventory;
    private int chips;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.chips = 100;
    }

    public String getName() {
        return name;
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
        System.out.println("\n--- " + name.toUpperCase() + "'s Hand ---");

        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        StringBuilder line3 = new StringBuilder();
        StringBuilder line4 = new StringBuilder();
        StringBuilder line5 = new StringBuilder();

        for (Card c : hand) {
            String r = c.getShortRank();
            String s = c.getSuitSymbol();

            // Ajuste de espaciado por si es un "10" (ocupa 2 caracteres)
            String topRank = r.length() == 1 ? r + " " : r;
            String botRank = r.length() == 1 ? " " + r : r;

            line1.append("┌───────┐ ");
            line2.append("│ ").append(topRank).append("    │ ");
            line3.append("│   ").append(s).append("   │ ");
            line4.append("│    ").append(botRank).append(" │ ");
            line5.append("└───────┘ ");
        }

        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println("Current Score: " + calculateScore());
        System.out.println("-------------------");
    }

    public void showFirstCard() {
        System.out.println("\n--- " + name.toUpperCase() + "'s Hand ---");

        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        StringBuilder line3 = new StringBuilder();
        StringBuilder line4 = new StringBuilder();
        StringBuilder line5 = new StringBuilder();

        // 1. Dibujamos la primera carta (Visible)
        Card firstCard = hand.get(0);
        String r = firstCard.getShortRank();
        String s = firstCard.getSuitSymbol();
        String topRank = r.length() == 1 ? r + " " : r;
        String botRank = r.length() == 1 ? " " + r : r;

        line1.append("┌───────┐ ");
        line2.append("│ ").append(topRank).append("    │ ");
        line3.append("│   ").append(s).append("   │ ");
        line4.append("│    ").append(botRank).append(" │ ");
        line5.append("└───────┘ ");

        // 2. Dibujamos la segunda carta (Oculta)
        line1.append("┌───────┐ ");
        line2.append("│ ░░░░░ │ ");
        line3.append("│ ░ ? ░ │ ");
        line4.append("│ ░░░░░ │ ");
        line5.append("└───────┘ ");

        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);
        System.out.println("-------------------");
    }

    public int getChips() {
        return chips;
    }

    public void adjustChips(int amount) {
        this.chips += amount;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public void clearHand() {
        this.hand.clear();
    }

    public void addItem(Item item) {
        this.inventory.add(item);
    }

    public void playTurn(Deck deck) {
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public boolean consumeItem(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equals(itemName)) {
                Item itemToUse = inventory.get(i);
                itemToUse.applyEffect(this);
                inventory.remove(i);
                return true;
            }
        } return false;
    }

    public void openInventory(Scanner scanner) {
        System.out.println("\n🎒 ALICE'S INVENTORY 🎒");

        boolean inInventory = true;
        while (inInventory) {
            System.out.println("-------------------------------------");
            if (inventory.isEmpty()) {
                System.out.println("Your inventory is empty.");
            } else {
                for (int i = 0; i < inventory.size(); i++) {
                    Item item = inventory.get(i);
                    System.out.println((i + 1) + ". " + item.getName());
                    System.out.println("   * " + item.getDescription());
                }
            }
            System.out.println("0. Leave inventory");
            System.out.println("-------------------------------------");

            System.out.println("What would you like to use? (Enter number):");

            int choice = -1;
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    String input = scanner.nextLine();
                    choice = Integer.parseInt(input);

                    if (choice > inventory.size() || choice < 0) {
                        System.out.println("Not so fast, Alice! Pick a valid number.");
                    } else {
                        validChoice = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("That's not even a number, Alice");
                    System.out.println("Please, enter a valid number:");
                }
            }
            if (choice == 0) {
                System.out.println("Closing inventory...");
                inInventory = false;
            } else {
                Item selectedItem = inventory.get(choice - 1);

                if (selectedItem.isPassive()) {
                    System.out.println("\n You can't use the " + selectedItem.getName() + " right now.");
                    System.out.println("This is a PASSIVE item. It will activate automatically when you need it!");
                } else {
                    consumeItem(selectedItem.getName());
                }
            }
        }
    }
}