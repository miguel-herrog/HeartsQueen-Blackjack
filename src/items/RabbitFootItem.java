package items;
import core.DisplayManager;
import entities.Player;

public class RabbitFootItem extends Item {

    public RabbitFootItem() {
        super("Rabbit's Foot", "Saves you from busting once (max 21 becomes 21).", 100, true);
    }

    public boolean applyEffect(Player player) {
        DisplayManager.type("\n THE RABBIT'S FOOT GLOWS! ");
        DisplayManager.type("It crumbles to dust, but it saves you from busting!");
        DisplayManager.type("Your score is magically locked at 21.");
        return true;
    }
}