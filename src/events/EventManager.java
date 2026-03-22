package events;

import entities.Player;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EventManager {

    private static final List<RandomEvent> eventPool = new ArrayList<>();

    // Static block runs once when the class is loaded into memory
    static {
        loadEventsFromFile();
    }

    /**
     * Reads events.txt and populates the event pool dynamically.
     */
    private static void loadEventsFromFile() {
        try {
            File file = new File("events.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Skip empty lines or comments
                if (line.trim().isEmpty() || line.startsWith("#")) {
                    continue;
                }

                // Split the line by the pipe character '|'
                // '|' is a special character, escape it with '\\|'
                String[] parts = line.split("\\|");

                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String description = parts[1].trim();
                    int modifier = Integer.parseInt(parts[2].trim());

                    eventPool.add(new GenericEvent(name, description, modifier));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("[WARNING] events.txt not found! Event pool will be empty.");
        } catch (Exception e) {
            System.out.println("[WARNING] Error parsing events.txt: " + e.getMessage());
        }
    }

    public static void rollForEvent(Player player) {
        // Failsafe: if the file wasn't read properly, just return quietly
        if (eventPool.isEmpty()) {
            return;
        }

        Random dice = new Random();
        int roll = dice.nextInt(100) + 1;

        if (roll <= 40) {
            int randomIndex = dice.nextInt(eventPool.size());
            RandomEvent chosenEvent = eventPool.get(randomIndex);
            chosenEvent.trigger(player);
        } else {
            System.out.println("\n... The path to the next floor is eerily quiet ...");
            core.DisplayManager.pause(1500);
        }
    }
}