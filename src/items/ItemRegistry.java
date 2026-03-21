package items;

public class ItemRegistry {

    public static Item createItem(String name) {
        switch (name) {
            case "Mad Tea": return new MadTeaItem();
            case "Aces High": return new AcesHighItem();
            case "Rabbit's Foot": return new RabbitFootItem();
            default: return null;
        }
    }
}