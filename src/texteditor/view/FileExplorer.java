package texteditor.view;

public class FileExplorer {

    private static boolean showFileExplorer;
    static {
        //todo: read from file
    }

    public static boolean isShowFileExplorer() {
        return showFileExplorer;
    }

    public static void setShowFileExplorer(boolean showFileExplorer) {
        FileExplorer.showFileExplorer = showFileExplorer;
        //todo: write in file
    }
}
