package texteditor.edit;

import javafx.scene.control.Tab;
import org.fxmisc.richtext.CodeArea;
import texteditor.main.CodeEditor;

public class Paste {

    public static void paste() {
        Tab tab = CodeEditor.getTabPane().getSelectionModel().getSelectedItem();
        CodeArea codeArea = (CodeArea) tab.getContent();
        codeArea.paste();
    }
}
