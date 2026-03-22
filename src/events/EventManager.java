package events;

import entities.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Handles the random generation and execution of events between floors.
 */
public class EventManager {

    // A static list holding one instance of every possible event
    private static final List<RandomEvent> eventPool = new ArrayList<>(Arrays.asList(
            new FoundChipsEvent(),
            new MushroomEvent(),
            new RingingPhoneEvent()
    ));

    public static void rollForEvent(Player player) {
        Random dice = new Random();
        int roll = dice.nextInt(100) + 1;

        // 40% chance to trigger an event
        if (roll <= 40) {
            // 1. Pick a random index from the event pool
            int randomIndex = dice.nextInt(eventPool.size());

            // 2. Grab that specific event
            RandomEvent chosenEvent = eventPool.get(randomIndex);

            // 3. Trigger it without knowing which one it actually is! (Polymorphism)
            chosenEvent.trigger(player);

        } else {
            System.out.println("\n... The path to the next floor is eerily quiet ...");
            core.DisplayManager.pause(1500);
        }
    }
}