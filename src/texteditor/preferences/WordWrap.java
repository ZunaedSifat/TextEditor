package texteditor.preferences;

import javafx.scene.control.Tab;
import texteditor.main.EditorTab;
import texteditor.main.CodeEditor;

public class WordWrap {

    public static void wordWrap() {
        for (Tab tab : CodeEditor.getTabPane().getTabs()) {
            EditorTab editorTab = (EditorTab) tab.getContent();
            editorTab.setWrapText(PreferenceData.isWordWrapEnabled());
        }
    }
}
