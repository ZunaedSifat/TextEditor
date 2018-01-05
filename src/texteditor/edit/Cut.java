package texteditor.edit;

import javafx.scene.control.Tab;
import org.fxmisc.richtext.CodeArea;
import texteditor.main.CodeEditor;

public class Cut {

    public static void cut() {

        Tab tab = CodeEditor.getTabPane().getSelectionModel().getSelectedItem();
        CodeArea codeArea = (CodeArea) tab.getContent();
        codeArea.cut();
    }
}
