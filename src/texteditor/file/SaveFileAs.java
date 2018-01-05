package texteditor.file;

import javafx.scene.control.Tab;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.fxmisc.richtext.CodeArea;
import texteditor.editor.EditorTab;
import texteditor.main.CodeEditor;

import java.io.*;

public class SaveFileAs {

    public static void saveFileAs() {

        Tab tab = CodeEditor.getTabPane().getSelectionModel().getSelectedItem();
        EditorTab codeArea = (EditorTab) tab.getContent();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File As");
        File file = fileChooser.showSaveDialog(new Stage());

        System.out.println(file.getPath());

        if (file != null) {

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(codeArea.getText());
                System.out.println(codeArea.getText());
                writer.close();

                tab.setText(file.getPath());
                codeArea.setPath(file.getPath());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
