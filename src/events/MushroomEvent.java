package events;

import entities.Player;
import core.DisplayManager;
import java.util.Random;

public class MushroomEvent implements RandomEvent {

    @Override
    public void trigger(Player player) {
        System.out.println("\n--- ? MYSTERIOUS EVENT ? ---");
        DisplayManager.type("You find a glowing blue mushroom right in the middle of the path.", 50);
        DisplayManager.type("Alice, being Alice, takes a bite...", 60);
        DisplayManager.pause(1000);

        Random flip = new Random();
        if (flip.nextBoolean()) {
            DisplayManager.type("Oof... your stomach turns. You drop some chips in the confusion.");
            player.adjustChips(-15);
        } else {
            DisplayManager.type("You feel a surge of luck! You spot some hidden chips in the dirt.");
            player.adjustChips(30);
        }
        DisplayManager.pause(1500);
    }
}