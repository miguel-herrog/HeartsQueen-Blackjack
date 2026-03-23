package core;

public class StoryManager {

    /**
     * Plays the opening sequence of the game.
     */
    public static void playIntro() {

        System.out.println("\n==================================================");
        DisplayManager.pause(1000);

        DisplayManager.type("Your head is spinning...", 70);
        DisplayManager.pause(1000);

        DisplayManager.type("The last thing you remember is following a man with rabbit ears into an alleyway.", 50);
        DisplayManager.pause(800);

        DisplayManager.type("Now, you wake up on a cold, checkered floor.", 50);
        DisplayManager.pause(1000);

        System.out.println();
        DisplayManager.type("A mechanical voice echoes from the speakers above:", 50);
        DisplayManager.pause(500);

        DisplayManager.type("\"Welcome to Wonderland Casino. The Queen is waiting at the top floor.\"", 100);
        DisplayManager.type("\"Win the games, survive the rooms, or lose your head.\"", 100);
        DisplayManager.pause(1500);

        System.out.println();
        DisplayManager.type("You reach into your pocket and find a handful of heavy, golden chips.", 50);
        DisplayManager.type("The game has already begun.", 50);

        DisplayManager.pause(2000);
        System.out.println("\n==================================================\n");
    }

    /**
     * Plays the Game Over sequence when Alice loses all chips.
     */
    public static void playGameOver() {
        DisplayManager.pause(1000);
        System.out.println("\n==================================================");

        DisplayManager.type("The dealer collects your final chip.", 60);
        DisplayManager.pause(1000);

        DisplayManager.type("Suddenly, the casino lights turn a deep, blood red.", 50);
        DisplayManager.pause(1000);

        System.out.println();
        DisplayManager.type("Robotic Voice: \"BANKRUPTCY DETECTED. ELIMINATION PROTOCOL INITIATED.\"", 80);
        DisplayManager.pause(1000);

        DisplayManager.type("You hear the mechanical whirring of a blade descending from the ceiling...", 60);
        DisplayManager.pause(1500);

        System.out.println();
        DisplayManager.type("OFF WITH HER HEAD!", 150);

        DisplayManager.pause(2000);
        System.out.println("==================================================\n");
    }

    /**
     * Plays the Victory sequence when Alice defeats the Queen.
     */
    public static void playVictory(int finalChips) {
        DisplayManager.pause(1000);
        System.out.println("\n==================================================");

        DisplayManager.type("The Queen stares at her empty hands in absolute disbelief.", 50);
        DisplayManager.pause(1000);

        DisplayManager.type("Queen: \"Bankrupt... Me? THE QUEEN OF HEARTS?!\"", 60);
        DisplayManager.pause(1500);

        System.out.println();
        DisplayManager.type("The mechanical guards immediately power down. The heavy casino doors slowly creak open, revealing the bright sunlight outside.", 50);
        DisplayManager.pause(1500);

        System.out.println();
        DisplayManager.type("You walk out of Wonderland Casino with " + finalChips + " golden chips in your pockets.", 60);
        DisplayManager.pause(1000);

        DisplayManager.type("You kept your head. You beat the house.", 80);

        DisplayManager.pause(2000);
        System.out.println("\n==================================================");
        System.out.println("                 THE END - YOU WIN                ");
        System.out.println("==================================================\n");
    }
    /**
     * Plays the introductory sequence for the first boss: The Mad Hatter.
     */
    public static void playMadHatterIntro() {
        System.out.println("\n==================================================");
        DisplayManager.pause(1000);

        DisplayManager.type("You push open a heavy oak door. The room inside is filled with ticking clocks.", 50);
        DisplayManager.pause(800);

        DisplayManager.type("At the center of a long, velvet-covered table sits a man with an oversized top hat.", 50);
        DisplayManager.pause(1000);

        System.out.println();
        DisplayManager.type("Mad Hatter: \"A new guest! How delightfully punctual! You're just in time for tea... and cards!\"", 40);
        DisplayManager.pause(800);

        DisplayManager.type("Mad Hatter: \"But here, we don't play for pennies. We play for time, sanity, and chips!\"", 40);
        DisplayManager.pause(1500);

        System.out.println();
        DisplayManager.type("He slams a massive stack of casino chips onto the table.", 60);
        DisplayManager.type("\"Let's see if you can empty my pockets before I take your head!\"", 40);

        DisplayManager.pause(2000);
        System.out.println("\n==================================================\n");
    }

    /**
     * Plays the introductory sequence for the second boss: The Cheshire Cat.
     */
    public static void playCheshireIntro() {
        System.out.println("\n==================================================");
        DisplayManager.pause(1000);

        DisplayManager.type("You step into a dark, neon-lit lounge.", 50);
        DisplayManager.pause(800);

        DisplayManager.type("Only a wide, glowing grin is visible in the shadows above the VIP table.", 50);
        DisplayManager.pause(1000);

        System.out.println();
        DisplayManager.type("Cheshire Cat: \"Well, well... Alice survived the Hatter.\"", 60);
        DisplayManager.pause(800);

        DisplayManager.type("Cheshire Cat: \"Care for a game? The rules here are... flexible.\"", 60);
        DisplayManager.pause(1500);

        System.out.println();
        DisplayManager.type("A stack of chips materializes out of thin air.", 50);

        DisplayManager.pause(2000);
        System.out.println("\n==================================================\n");
    }

    /**
     * Plays the introductory sequence for the final boss: The Queen of Hearts.
     */
    public static void playQueenIntro() {
        System.out.println("\n==================================================");
        DisplayManager.pause(1000);

        DisplayManager.type("The elevator doors open to the penthouse suite.", 50);
        DisplayManager.pause(1000);

        DisplayManager.type("Red carpets. Golden chandeliers. And at the end, a massive throne.", 50);
        DisplayManager.pause(1000);

        System.out.println();
        DisplayManager.type("The Queen of Hearts glares down at you, shuffling a deck of blood-red cards.", 50);
        DisplayManager.pause(1000);

        DisplayManager.type("Queen: \"You've caused quite a mess in my casino, little girl.\"", 60);
        DisplayManager.pause(1000);

        DisplayManager.type("Queen: \"Let's finish this. All in. If you win, you walk.\"", 60);
        DisplayManager.pause(1500);

        System.out.println();
        DisplayManager.type("Queen: \"If you lose... well, you know the drill.\"", 80);

        DisplayManager.pause(2000);
        System.out.println("\n==================================================\n");
    }
}