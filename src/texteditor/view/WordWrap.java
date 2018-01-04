package texteditor.view;

public class WordWrap {

    private static boolean wordWrapEnabled;
    static {
        //todo: read from file
    }

    public static boolean isWordWrapEnabled() {
        return wordWrapEnabled;
    }

    public static void setWordWrapEnabled(boolean wordWrapEnabled) {
        WordWrap.wordWrapEnabled = wordWrapEnabled;
        //todo: write in files
    }
}
