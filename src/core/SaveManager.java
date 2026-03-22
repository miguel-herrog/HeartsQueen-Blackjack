package core;

import entities.Player;
import items.Item;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Handles the persistence of the game state.
 * Responsible for writing and reading the player's data to/from a local text file.
 */
public class SaveManager {
    private static final String FILE_NAME = "savegame.txt";

    /**
     * Saves the current player state and game progress to a file.
     *
     * @param player   The current player instance.
     * @param progress The current floor/boss index to save.
     */
    public void saveGame(Player player, int progress) {
        DisplayManager.type("\nSaving game...");

        // Using try-with-resources to ensure the FileWriter closes automatically
        try (FileWriter writer = new FileWriter(FILE_NAME)) {

            writer.write("chips:" + player.getChips() + "\n");
            writer.write("progress:" + progress + "\n");
            writer.write("inventory:");
            for (int i = 0; i < player.getInventory().size(); i++) {
                writer.write(player.getInventory().get(i).getName());

                // Append comma only if it's not the last item
                if (i < player.getInventory().size() - 1) {
                    writer.write(",");
                }
            }
            writer.write("\n");

            DisplayManager.type("Progress saved successfully!");
        } catch (IOException e) {
            DisplayManager.type(" Error saving game: " + e.getMessage());
        }
    }

    /**
     * Loads the game state from the save file.
     *
     * @param player The player instance to populate with saved data.
     * @return The saved progress level (floor number), or 1 if no save exists.
     */
    public int loadGame(Player player) {
        File file = new File(FILE_NAME);

        // Return floor 1 immediately if it's a new game
        if (!file.exists()) return 1;

        DisplayManager.type("Loading saved game...");
        int currentProgress = 1;

        try (Scanner reader = new Scanner(file)) {
            // Read the file line by line, allowing flexible data ordering
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(":");

                // Skip empty or malformed lines to prevent crashes
                if (parts.length < 2) continue;

                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "chips":
                        player.setChips(Integer.parseInt(value));
                        break;

                    case "progress":
                        currentProgress = Integer.parseInt(value);
                        break;

                    case "inventory":
                        String[] itemNames = value.split(",");
                        for (String name : itemNames) {
                            // Delegate instantiation to the ItemRegistry (Factory Pattern)
                            Item item = items.ItemRegistry.createItem(name.trim());
                            if (item != null) {
                                player.addItem(item);
                            }
                        }break;
                }
            }
            DisplayManager.type("Game loaded successfully!");
            return currentProgress;
        }
        catch (Exception e) {
            DisplayManager.type(" Error loading game: " + e.getMessage());
            return 1;
        }
    }

    public void deleteSave() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            file.delete();
            DisplayManager.type("🗑 Save file cleared for a new adventure!");
        }
    }
}