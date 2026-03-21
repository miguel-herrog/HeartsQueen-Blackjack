package items;
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

    public void visitShop(Player player, Scanner scanner) {
        System.out.println("\n=====================================");
        System.out.println("⛺ THE MYSTERIOUS MERCHANT ⛺");
        System.out.println("'Welcome, traveler... Care to trade some chips for survival?'");
        System.out.println("Your current chips: " + player.getChips());
        System.out.println("-------------------------------------");

        boolean shopping = true;
        while (shopping) {
            // SHOW CATALOG
            for (int i = 0; i < catalog.size(); i++) {
                Item item = catalog.get(i);
                System.out.println((i + 1) + ". " + item.getName() + " - " + item.getPrice() + " chips");
                System.out.println("   * " + item.getDescription());
            }
            System.out.println("0. Leave shop");
            System.out.println("-------------------------------------");

            System.out.println("What would you like to buy? (Enter number):");

            int choice = -1;
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    String input = scanner.nextLine();
                    choice = Integer.parseInt(input);

                    if (choice > catalog.size() || choice < 0) {
                        System.out.println("'I don't sell that. Pick a valid number.'");
                    } else {
                        validChoice = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("That's not even a number, Alice");
                    System.out.println("Please, enter a valid number:");
                }
            }

            if (choice == 0) {
                System.out.println("'Good luck out there... You'll need it.'");
                shopping = false;
            } else {
                Item selectedItem = catalog.get(choice - 1);
                if (player.getChips() >= selectedItem.getPrice()) {
                    player.adjustChips(-selectedItem.getPrice());
                    catalog.remove(selectedItem);
                    player.addItem(selectedItem);
                    System.out.println("'Great acquisition traveler'");
                } else {
                    System.out.println("'You can't afford that, poor soul!'");
                }
            }
        }
    }
}