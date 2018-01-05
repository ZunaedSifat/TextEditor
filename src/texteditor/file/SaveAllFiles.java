package texteditor.file;

import javafx.scene.control.Tab;
import texteditor.main.CodeEditor;

public class SaveAllFiles {

    public static void saveAllFiles() {

        for (Tab tab : CodeEditor.getTabPane().getTabs())
            SaveFile.saveFile(tab);
    }
}
