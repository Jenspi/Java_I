public class ANSI {
    //https://en.wikipedia.org/wiki/ANSI_escape_code
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_CLEAR = "\033[2J";
    public static final String ANSI_CURSOR_TOPLEFT = "\033[H";
    //final String ANSI_CURSOR_CUSTOM = "\033[y;xH";//(moves cursor to row y, column x)
}