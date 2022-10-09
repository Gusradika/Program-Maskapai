package maskapai_21410100039;

public class style {

    public static final String YELLOW = "\u001B[33m";
    public static final String BLACK = "\033[0;30m"; // BLACK
    public static final String RED = "\033[0;31m"; // RED
    public static final String GREEN = "\033[0;32m"; // GREEN
    public static final String BLUE = "\033[0;34m"; // BLUE
    public static final String PURPLE = "\033[0;35m"; // PURPLE
    public static final String CYAN = "\033[0;36m"; // CYAN
    public static final String WHITE = "\033[0;37m"; // WHITE
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW

    public static final String RESET = "\u001B[0m";

    public static final String GREEN_U = "\033[4;32m"; // GREEN

    public static final String RED_BG = "\033[41m"; // Red BG
    public static final String YELLOW_BG = "\033[43m"; // YELLOW

    public static final String CYAN_BG = "\033[46m"; // CYAN

    public static void cetakSpasi(int x) {
        for (int i = 0; i < x; i++) {
            System.out.println();
        }
    }
}
