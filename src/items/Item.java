package items;

import entities.Player;

public class Item {
    private String name;
    private String description;
    private int price;
    private boolean isPassive;

    public Item(String name, String description, int price, boolean isPassive) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isPassive = isPassive;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public boolean isPassive() {
        return isPassive;
    }

    public boolean applyEffect(Player player) {
        return false;
    }
}

