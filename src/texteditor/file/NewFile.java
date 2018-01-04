package texteditor.file;

import texteditor.editor.EditorTab;
import texteditor.main.CodeEditor;

public class NewFile {

    public static void createNewFile() {
        CodeEditor.addTab(new EditorTab(null, null));
    }
}
