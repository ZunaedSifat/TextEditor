package texteditor.file;

public class OpenRecent {
    public static String[] recentFiles;

    static {
        recentFiles = new String[5];
    }

    public static void add(String fileName) {
        for(int i=0; i<4; ++i) {
            recentFiles[i+1] = recentFiles[i];
        }
        recentFiles[0] = fileName;
    }

    // todo. this is just a console printing funtion to display recent files.
    public static void displayRecentFiles() {
        System.out.println("Recent Files:");
        for(int i=0; i<recentFiles.length; ++i) {
            if(recentFiles[i] == null) break;
            System.out.println(recentFiles[i]);
        }
    }
}
