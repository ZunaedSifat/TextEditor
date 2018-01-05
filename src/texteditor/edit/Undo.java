package texteditor.edit;

import javafx.scene.control.Tab;
import org.fxmisc.richtext.CodeArea;
import texteditor.main.CodeEditor;

public class Undo {

    public static void undo() {

        Tab tab = CodeEditor.getTabPane().getSelectionModel().getSelectedItem();
        CodeArea codeArea = (CodeArea) tab.getContent();

        if (codeArea.isUndoAvailable())
            codeArea.undo();
    }
}
