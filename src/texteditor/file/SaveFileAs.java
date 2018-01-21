package texteditor.file;

import javafx.scene.control.Tab;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import texteditor.main.EditorTab;
import texteditor.main.CodeEditor;

import java.io.*;

public class SaveFileAs {

    public static void saveFileAs() {

        Tab tab = CodeEditor.getTabPane().getSelectionModel().getSelectedItem();
        EditorTab codeArea = (EditorTab) tab.getContent();

        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save \"" + tab.getText() + "\" As");
            File file = fileChooser.showSaveDialog(new Stage());

            System.out.println(file.getPath());

            if (file != null) {

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(codeArea.getText());
                    System.out.println("saved: " + codeArea.getText());

                    tab.setText(file.getPath().split("/")[file.getPath().split("/").length-1]);
                    codeArea.setPath(file.getPath());
                    OpenRecent.add(file.getAbsolutePath());

                    if (file.getPath().endsWith(".java"))
                        codeArea.addSyntaxHighlighting();

                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
