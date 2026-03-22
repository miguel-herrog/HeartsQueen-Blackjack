package items;

import java.util.Arrays;
import java.util.List;

public class ItemRegistry {

    public static Item createItem(String name) {
        switch (name) {
            case "Mad Tea": return new MadTeaItem();
            case "Aces High": return new AcesHighItem();
            case "Rabbit's Foot": return new RabbitFootItem();
            default: return null;
        }
    }

    /**
     * Returns a list of all registered item IDs.
     * Useful for picking random items for the shop.
     */
    public static List<String> getAllRegisteredIds() {
        return Arrays.asList("Mad Tea", "Aces High", "Rabbit's Foot");
    }
}