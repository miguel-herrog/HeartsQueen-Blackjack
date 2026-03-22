package events;

import entities.Player;
import core.DisplayManager;

/**
 * A simple positive event where the player finds abandoned chips.
 */
public class FoundChipsEvent implements RandomEvent {

    @Override
    public void trigger(Player player) {
        System.out.println("\n--- ? MYSTERIOUS EVENT ? ---");
        DisplayManager.type("As you walk through the twisted paths of Wonderland...");
        DisplayManager.type("You trip over a small, velvet bag.");

        DisplayManager.pause(1000);

        System.out.println("You found 50 chips inside!");
        player.adjustChips(50);

        DisplayManager.pause(1500);
    }
}