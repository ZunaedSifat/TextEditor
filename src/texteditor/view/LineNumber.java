package texteditor.view;

public class LineNumber {

    private static boolean lineNumberEnabled;
    static {
        lineNumberEnabled = true;
        //todo: read data from file
    }

    public static boolean isLineNumberEnabled() {
        return lineNumberEnabled;
    }

    public static void setLineNumberEnabled(boolean value) {
        lineNumberEnabled = value;
        //todo: write in file
    }
}
