package items;
import core.DisplayManager;
import core.SaveManager;
import entities.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Shop {
    private ArrayList<Item> catalog;

    public Shop() {
        this.catalog = new ArrayList<>();

        // 1. Get all possible item IDs from the registry
        List<String> availableIds = ItemRegistry.getAllRegisteredIds();

        // 2. Shuffle the list to make it random
        Collections.shuffle(availableIds);

        // 3. Pick the first 3 items (or less, if we have fewer than 3 registered)
        int itemsToStock = Math.min(3, availableIds.size());

        for (int i = 0; i < itemsToStock; i++) {
            String randomId = availableIds.get(i);
            catalog.add(ItemRegistry.createItem(randomId));
        }
    }

    public void visitShop(Player player, Scanner scanner, int progress) {
        System.out.println("\n=====================================");
        DisplayManager.type(" THE MYSTERIOUS MERCHANT ");
        DisplayManager.type("'Welcome, traveler... Care to trade some chips for survival?'");
        DisplayManager.type("Your current chips: " + player.getChips());
        System.out.println("-------------------------------------");

        boolean shopping = true;
        while (shopping) {
            // SHOW CATALOG
            for (int i = 0; i < catalog.size(); i++) {
                Item item = catalog.get(i);
                DisplayManager.type((i + 1) + ". " + item.getName() + " - " + item.getPrice() + " chips");
                DisplayManager.type("   * " + item.getDescription());
            }
            DisplayManager.type("9. Save Game");
            DisplayManager.type("0. Leave shop");
            System.out.println("-------------------------------------");

            DisplayManager.type("What would you like to buy? (Enter number):");

            int choice = -1;
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    String input = scanner.nextLine();
                    choice = Integer.parseInt(input);

                    if ((choice > catalog.size() && choice != 9) || choice < 0) {
                        DisplayManager.type("'I don't sell that. Pick a valid number.'");
                    } else {
                        validChoice = true;
                    }
                } catch (NumberFormatException e) {
                    DisplayManager.type("That's not even a number, Alice");
                    DisplayManager.type("Please, enter a valid number:");
                }
            }

            if (choice == 0) {
                DisplayManager.type("'Good luck out there... You'll need it.'");
                shopping = false;
            } else if (choice == 9) {
                SaveManager saveManager = new SaveManager();
                saveManager.saveGame(player, progress);
            } else {
                Item selectedItem = catalog.get(choice - 1);
                if (player.getChips() >= selectedItem.getPrice()) {
                    player.adjustChips(-selectedItem.getPrice());
                    catalog.remove(selectedItem);
                    player.addItem(selectedItem);
                    DisplayManager.type("'Great acquisition traveler'");
                } else {
                    DisplayManager.type("'You can't afford that, poor soul!'");
                }
            }
        }
    }
}