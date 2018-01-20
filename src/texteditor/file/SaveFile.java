package texteditor.file;

import javafx.scene.control.Tab;
import texteditor.main.EditorTab;
import texteditor.main.CodeEditor;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class SaveFile {

    public static void saveFile() {

        Tab tab = CodeEditor.getTabPane().getSelectionModel().getSelectedItem();
        saveFile(tab);
    }

    public static void saveFile(Tab tab) {

        EditorTab editorTab = (EditorTab) tab.getContent();

        if (editorTab.getPath() != null) {

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(editorTab.getPath()));
                writer.write(editorTab.getText());
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            SaveFileAs.saveFileAs();
        }
    }
}
