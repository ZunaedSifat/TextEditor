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
        closeFile(tab);
    }

    public static void closeFile(Tab tab) {

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

        // to save in recent files
        EditorTab editorTab = (EditorTab) tab.getContent();
        String fileName = (String) editorTab.getPath();
        OpenRecent.add(fileName);
    }

    private static boolean isFileUpdated(Tab tab) {

        EditorTab editorTab = (EditorTab) CodeEditor.getTabPane().getSelectionModel().getSelectedItem().getContent();
        if (editorTab.getPath() == null) return false;

        String currentText = editorTab.getText();
        if (!currentText.endsWith("\n") && (currentText != null || currentText != ""))
            currentText = currentText + "\n";

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

        for (int i = 0; i < Math.max(savedText.length(), currentText.length()); i++) {

            if (i >= savedText.length() || i >= currentText.length())
                return false;
            else if (savedText.charAt(i) != currentText.charAt(i))
                return false;
        }

        return true;
    }
}
