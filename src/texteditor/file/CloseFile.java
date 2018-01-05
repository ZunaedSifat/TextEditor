package texteditor.file;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import texteditor.editor.EditorTab;
import texteditor.main.CodeEditor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

public class CloseFile {

    public static void closeFile() {

        Tab tab = CodeEditor.getTabPane().getSelectionModel().getSelectedItem();

        if (!isFileUpdated(tab)) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("File Not Saved");
            alert.setHeaderText("The file is not saved. All the recent changes will be discarded.");
            alert.setContentText("Do you want to save file?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                SaveFile.saveFile(tab);
            }
        }

        tab.getTabPane().getTabs().remove(tab);
    }

    private static boolean isFileUpdated(Tab tab) {

        String currentText = ((EditorTab) tab.getContent()).getText();
        StringBuffer savedText = new StringBuffer("");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(((EditorTab) tab.getContent()).getPath()));

            while (true) {

                String line = reader.readLine();
                if (line == null) break;
                savedText.append(line + "\n");
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //todo: always returns false, check why
        return savedText.equals(currentText);
    }
}
