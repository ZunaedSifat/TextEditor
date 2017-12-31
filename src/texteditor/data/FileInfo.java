package texteditor.data;

public class FileInfo {

    private static String filename;
    private static String[] recentFiles = new String[5];
    static {
        // todo: read from file the list of saved recent files
    }

    public static String getFilename() {
        return filename;
    }

    public static void setFilename(String filename) {
        FileInfo.filename = filename;
    }

    public static String[] getRecentFiles() {
        return recentFiles;
    }

    public static void addNewFileToRecentList(String filename) {

        boolean fileAlreadyInList = false;

        for (String file : recentFiles)
            if (file.equals(filename))
                fileAlreadyInList = true;

        if (fileAlreadyInList) {

            String[] temp = new String[5];
            temp[0] = filename;

            int tempIdx = 1;
            for (String file : recentFiles)
                if (!file.equals(filename))
                    temp[tempIdx++] = file;

            recentFiles = temp;
        }
        else {

            for (int i = 3; i > 0; i--)
                recentFiles[i+1] = recentFiles[i];
            recentFiles[0] = filename;
        }

        // todo: write the new entry to the file
    }
}
