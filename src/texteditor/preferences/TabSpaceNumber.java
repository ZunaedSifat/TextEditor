package texteditor.preferences;

public class TabSpaceNumber {


    private static boolean replaceWithSpaces;
    private static int numberOfSpaces;

    static {
        // read from files
    }

    public static boolean isReplaceWithSpaces() {
        return replaceWithSpaces;
    }

    public static void setReplaceWithSpaces(boolean replaceWithSpaces) {
        TabSpaceNumber.replaceWithSpaces = replaceWithSpaces;
    }

    public static int getNumberOfSpaces() {
        return numberOfSpaces;
    }

    public static void setNumberOfSpaces(int numberOfSpaces) {
        TabSpaceNumber.numberOfSpaces = numberOfSpaces;
    }
}
