package events;

import entities.Player;
import core.DisplayManager;

/**
 * A universal event template that gets its data from a text file.
 */
public class GenericEvent implements RandomEvent {

    private String name;
    private String description;
    private int chipModifier;

    public GenericEvent(String name, String description, int chipModifier) {
        this.name = name;
        this.description = description;
        this.chipModifier = chipModifier;
    }

    @Override
    public void trigger(Player player) {
        System.out.println("\n--- ? MYSTERIOUS EVENT: " + name.toUpperCase() + " ? ---");

        DisplayManager.type(description, 40);
        DisplayManager.pause(1000);

        // Apply the effect
        if (chipModifier > 0) {
            DisplayManager.type("You gained " + chipModifier + " chips!");
        } else if (chipModifier < 0) {
            DisplayManager.type("You lost " + Math.abs(chipModifier) + " chips!");
        }

        player.adjustChips(chipModifier);
        DisplayManager.pause(1500);
    }
}