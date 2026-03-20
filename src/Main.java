public class Main {
    public static void main(String[] args) {
        Player alice = new Player("Alice");
        GameEngine engine = new GameEngine();

        System.out.println("Welcome to Wonderland! A game of life, death, and chips.");

        // Floor 1: MadHatter
        if (engine.startEncounter(alice, new MadHatter())) {
            // Floor 2: CheshireCat
            System.out.println("\n--- YOU ENTER THE DARK FOREST ---");
            if (engine.startEncounter(alice, new CheshireCat())){
                // Floor 3: Queen
                System.out.println("\n--- YOU ENTER THE ROYALE PALACE ---");
                if (engine.startEncounter(alice, new Queen())) {
                    System.out.println("\n===============================================");
                    System.out.println("👑 YOU BANKRUPTED THE QUEEN! YOU ESCAPED WONDERLAND! 👑");
                    System.out.println("Final Chips: " + alice.getChips());
                    System.out.println("===============================================");
                }
            }
        }
        System.out.println("\nThanks for playing!");
    }
}