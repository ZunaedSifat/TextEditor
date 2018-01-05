package texteditor.edit;

import javafx.scene.control.Tab;
import org.fxmisc.richtext.CodeArea;
import texteditor.main.CodeEditor;

public class Redo {

    public static void redo() {

        Tab tab = CodeEditor.getTabPane().getSelectionModel().getSelectedItem();
        CodeArea codeArea = (CodeArea) tab.getContent();

        if (codeArea.isRedoAvailable())
            codeArea.redo();
    }
}
