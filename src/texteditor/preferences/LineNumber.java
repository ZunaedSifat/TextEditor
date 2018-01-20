package texteditor.preferences;

import javafx.scene.control.Tab;
import org.fxmisc.richtext.LineNumberFactory;
import texteditor.main.EditorTab;
import texteditor.main.CodeEditor;

public class LineNumber {

    public static void lineNumber() {

        for (Tab tab : CodeEditor.getTabPane().getTabs()) {

            EditorTab editorTab = (EditorTab) tab.getContent();
            if (!PreferenceData.isLineNumberEnabled())
                editorTab.setParagraphGraphicFactory(null);
            else
                editorTab.setParagraphGraphicFactory(LineNumberFactory.get(editorTab));
        }
    }
}
