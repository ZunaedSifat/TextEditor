package texteditor.file;

import javafx.scene.control.Tab;
import texteditor.editor.EditorTab;
import texteditor.main.CodeEditor;

import java.io.File;
import java.text.SimpleDateFormat;

public class Properties {

    public static void showProperties() {
        Tab tab = CodeEditor.getTabPane().getSelectionModel().getSelectedItem();
        EditorTab editorTab = (EditorTab) tab.getContent();
        String filePath = (String) editorTab.getPath();

        /* todo: show in GUI */
        File curFile = new File(filePath);
        System.out.println("File Name: " + curFile.getName());
        System.out.println("Path: " + curFile.getPath());
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");
        System.out.println("Last Modified: " + sdf.format(curFile.lastModified()));
        System.out.println("File size: " + curFile.length() + " bytes");
    }
}
