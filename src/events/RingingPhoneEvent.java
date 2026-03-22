package events;

import entities.Player;
import core.DisplayManager;

public class RingingPhoneEvent implements RandomEvent {

    @Override
    public void trigger(Player player) {
        System.out.println("\n--- ?️ MYSTERIOUS EVENT ?️ ---");
        DisplayManager.type("Riiiing... Riiiiing...", 80);
        DisplayManager.pause(500);
        DisplayManager.type("An old, disconnected black rotary phone sits on a tree stump.", 50);
        DisplayManager.type("You pick it up. A raspy whisper breathes into your ear...", 60);

        DisplayManager.pause(1500);

        DisplayManager.type("'Leave your chips... or leave your life...'", 5);
        DisplayManager.type("Terrified, you throw some chips into the woods and run!", 25);
        player.adjustChips(-20);

        DisplayManager.pause(2000);
    }
}