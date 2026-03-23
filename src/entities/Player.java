package entities;
import core.DisplayManager;
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

    public Player(String name, int startingChips) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.chips = startingChips;
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
        DisplayManager.type("\n--- " + name.toUpperCase() + "'s Hand ---", 10);

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
        DisplayManager.type("Current Score: " + calculateScore(), 10);
        System.out.println("-------------------");
    }

    public void showFirstCard() {
        DisplayManager.type("\n--- " + name.toUpperCase() + "'s Hand ---", 10);

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
        DisplayManager.type("\n ALICE'S INVENTORY ", 10);

        boolean inInventory = true;
        while (inInventory) {
            System.out.println("-------------------------------------");
            if (inventory.isEmpty()) {
                DisplayManager.type("Your inventory is empty.", 10);
            } else {
                for (int i = 0; i < inventory.size(); i++) {
                    Item item = inventory.get(i);
                    System.out.println((i + 1) + ". " + item.getName());
                    System.out.println("   * " + item.getDescription());
                }
            }
            DisplayManager.type("0. Leave inventory", 5);
            System.out.println("-------------------------------------");

            DisplayManager.type("What would you like to use? (Enter number):", 10);

            int choice = -1;
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    String input = scanner.nextLine();
                    choice = Integer.parseInt(input);

                    if (choice > inventory.size() || choice < 0) {
                        DisplayManager.type("Not so fast, Alice! Pick a valid number.", 10);
                    } else {
                        validChoice = true;
                    }
                } catch (NumberFormatException e) {
                    DisplayManager.type("That's not even a number, Alice", 10);
                    DisplayManager.type("Please, enter a valid number:", 10);
                }
            }
            if (choice == 0) {
                DisplayManager.type("Closing inventory...", 10);
                inInventory = false;
            } else {
                Item selectedItem = inventory.get(choice - 1);

                if (selectedItem.isPassive()) {
                    DisplayManager.type("\n You can't use the " + selectedItem.getName() + " right now.", 5);
                    DisplayManager.type("This is a PASSIVE item. It will activate automatically when you need it!", 5);
                } else {
                    consumeItem(selectedItem.getName());
                }
            }
        }
    }
}