package items;
import entities.Player;

public class RabbitFootItem extends Item {

    public RabbitFootItem() {
        super("Rabbit's Foot", "Saves you from busting once (max 21 becomes 21).", 100, true);
    }

    public boolean applyEffect(Player player) {
        System.out.println("\n✨ THE RABBIT'S FOOT GLOWS! ✨");
        System.out.println("It crumbles to dust, but it saves you from busting!");
        System.out.println("Your score is magically locked at 21.");
        return true;
    }
}