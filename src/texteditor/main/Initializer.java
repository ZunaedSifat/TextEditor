package texteditor.main;

import texteditor.file.OpenRecent;
import texteditor.preferences.AutoSave;
import texteditor.preferences.PreferenceData;

public class Initializer {

    public static void initialize() {

        Thread autoSave = new Thread(AutoSave.getObject());
        autoSave.start();

        PreferenceData.readData();
        OpenRecent.readData();
    }
}
