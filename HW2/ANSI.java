public class ANSI {
    //https://en.wikipedia.org/wiki/ANSI_escape_code

    // EFFECTS
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_ITALIC = "\u001B[3m";
    public static final String ANSI_CLEAR = "\033[2J";
    public static final String ANSI_CURSOR_TOPLEFT = "\033[H";
    public static final String ANSI_BLINK = "\u001B[5m";
    public static final String ANSI_NOT_BOLD = "\u001B[21m";
    public static final String ANSI_NOT_ITALIC = "\u001B[23m";
    public static final String ANSI_NOT_BLINK = "\u001B[25m";
    //final String ANSI_CURSOR_CUSTOM = "\033[y;xH";//(moves cursor to row y, column x)

    // FOREGROUND COLORS
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BRIGHT_GREY = "\u001B[90m";
    public static final String ANSI_BRIGHT_RED = "\u001B[91m";
    public static final String ANSI_BRIGHT_GREEN = "\u001B[92m";
    public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_BRIGHT_BLUE = "\u001B[94m";
    public static final String ANSI_BRIGHT_MAGENTA = "\u001B[95m";
    public static final String ANSI_BRIGHT_CYAN = "\u001B[96m";
    public static final String ANSI_BRIGHT_WHITE = "\u001B[97m";

    // BACKGROUND COLORS
    public static final String ANSI_BG_BLACK = "\u001B[40m";
    public static final String ANSI_BG_RED = "\u001B[41m";
    public static final String ANSI_BG_GREEN = "\u001B[42m";
    public static final String ANSI_BG_YELLOW = "\u001B[43m";
    public static final String ANSI_BG_BLUE = "\u001B[44m";
    public static final String ANSI_BG_MAGENTA = "\u001B[45m";
    public static final String ANSI_BG_CYAN = "\u001B[46m";
    public static final String ANSI_BG_WHITE = "\u001B[47m";
    public static final String ANSI_BG_GREY = "\u001B[100m";
    public static final String ANSI_BG_BRIGHT_RED = "\u001B[101m";
    public static final String ANSI_BG_BRIGHT_GREEN = "\u001B[102m";
    public static final String ANSI_BG_BRIGHT_YELLOW = "\u001B[103m";
    public static final String ANSI_BG_BRIGHT_BLUE = "\u001B[104m";
    public static final String ANSI_BG_BRIGHT_MAGENTA = "\u001B[105m";
    public static final String ANSI_BG_BRIGHT_CYAN = "\u001B[106m";
    public static final String ANSI_BG_BRIGHT_WHITE = "\u001B[107m";
}