package core;

public class DisplayManager {

    public static boolean fastMode = false;

    /**
     * Imprime un texto letra a letra (Efecto máquina de escribir).
     * @param text El texto a imprimir.
     * @param delay El tiempo de espera entre cada letra (en milisegundos).
     */
    public static void type(String text, int delay) {
        if (fastMode) {
            System.out.println(text);
            return;
        }

        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            System.out.flush();
            pause(delay);
        }
        System.out.println();
    }

    /**
     * Type method overload. uses 30ms by default.
     */
    public static void type(String text) {
        type(text, 30);
    }

    // Utility method to add pacing and suspense to the game flow
    public static void pause(int milliseconds) {
        if (fastMode) {
            return;
        }

        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // Buena práctica: Restaurar el estado de interrupción del hilo
            Thread.currentThread().interrupt();
        }
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /**
     * Clears any leftover input from the System.in buffer.
     */
    public static void clearInputBuffer() {
        try {
            while (System.in.available() > 0) {
                System.in.read();
            }
        } catch (Exception e) {
        }
    }
}
