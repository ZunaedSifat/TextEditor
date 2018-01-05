package texteditor.edit;

import javafx.scene.control.Tab;
import org.fxmisc.richtext.CodeArea;
import texteditor.main.CodeEditor;

public class Copy {

    public static void copy() {

        Tab tab = CodeEditor.getTabPane().getSelectionModel().getSelectedItem();
        CodeArea codeArea = (CodeArea) tab.getContent();
        codeArea.copy();
    }
}
