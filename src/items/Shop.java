package items;
import core.DisplayManager;
import core.SaveManager;
import entities.Player;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private ArrayList<Item> catalog;

    public Shop() {
        this.catalog = new ArrayList<>();

        catalog.add(new AcesHighItem());
        catalog.add(new RabbitFootItem());
        catalog.add(new MadTeaItem());
    }

    public void visitShop(Player player, Scanner scanner, int progress) {
        System.out.println("\n=====================================");
        DisplayManager.type(" THE MYSTERIOUS MERCHANT ", 5);
        DisplayManager.type("'Welcome, traveler... Care to trade some chips for survival?'");
        DisplayManager.type("Your current chips: " + player.getChips(), 10);
        System.out.println("-------------------------------------");

        boolean shopping = true;
        while (shopping) {
            // SHOW CATALOG
            for (int i = 0; i < catalog.size(); i++) {
                Item item = catalog.get(i);
                DisplayManager.type((i + 1) + ". " + item.getName() + " - " + item.getPrice() + " chips", 5);
                DisplayManager.type("   * " + item.getDescription(), 10);
            }
            DisplayManager.type("9. Save Game", 5);
            DisplayManager.type("0. Leave shop", 5);
            System.out.println("-------------------------------------");

            DisplayManager.type("What would you like to buy? (Enter number):", 10);

            int choice = -1;
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    String input = scanner.nextLine();
                    choice = Integer.parseInt(input);

                    if ((choice > catalog.size() && choice != 9) || choice < 0) {
                        DisplayManager.type("'I don't sell that. Pick a valid number.'", 5);
                    } else {
                        validChoice = true;
                    }
                } catch (NumberFormatException e) {
                    DisplayManager.type("That's not even a number, Alice", 5);
                    DisplayManager.type("Please, enter a valid number:", 5);
                }
            }

            if (choice == 0) {
                DisplayManager.type("'Good luck out there... You'll need it.'", 10);
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
                    DisplayManager.type("'Great acquisition traveler'", 10);
                } else {
                    DisplayManager.type("'You can't afford that, poor soul!'", 10);
                }
            }
        }
    }
}