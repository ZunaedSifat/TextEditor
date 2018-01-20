package texteditor.preferences;

import javafx.scene.control.Tab;
import texteditor.editor.EditorTab;
import texteditor.main.CodeEditor;

import java.io.BufferedReader;
import java.io.FileReader;

public class WordWrap {

    public static void wordWrap() {
        for (Tab tab : CodeEditor.getTabPane().getTabs()) {
            EditorTab editorTab = (EditorTab) tab.getContent();
            editorTab.setWrapText(PreferenceData.isWordWrapEnabled());
        }
    }
}
