package events;

import entities.Player;


public interface RandomEvent {

    /**
     * Executes the event's logic.
     * @param player The player who triggered the event.
     */
    void trigger(Player player);
}