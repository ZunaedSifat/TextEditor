package texteditor.edit;

import texteditor.main.EditorTab;
import texteditor.main.CodeEditor;

public class SelectAll {

    public static void selectAll() {

        EditorTab editorTab = (EditorTab) CodeEditor.getTabPane().getSelectionModel().getSelectedItem().getContent();
        editorTab.selectAll();
    }

}
