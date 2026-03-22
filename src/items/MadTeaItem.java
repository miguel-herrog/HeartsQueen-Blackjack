package items;

import core.DisplayManager;
import entities.Player;

public class MadTeaItem extends Item {

    public MadTeaItem() {
        super("Mad Tea", "A sip of madness! Instantly gives you 50 extra chips.", 25, false);
    }

    public boolean applyEffect(Player player) {
        DisplayManager.type("\n YOU DRINK THE MAD TEA! ", 5);
        DisplayManager.type("You feel a rush of chaotic energy... and find 50 chips in your pocket!", 10);
        player.adjustChips(50);
        return true;
    }
}