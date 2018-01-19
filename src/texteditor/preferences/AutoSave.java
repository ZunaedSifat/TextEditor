package texteditor.preferences;

import javafx.scene.control.Tab;
import texteditor.editor.EditorTab;
import texteditor.file.SaveFile;
import texteditor.main.CodeEditor;

public class AutoSave implements Runnable {

    private static AutoSave object;
    private AutoSave() { }
    public static AutoSave getObject() {
        if (object == null) object = new AutoSave();
        return object;
    }

    @Override
    public void run() {

        if (PreferenceData.isAutoSaveEnabled()) {

            for (Tab tab : CodeEditor.getTabPane().getTabs()) {

                EditorTab editor = (EditorTab) tab.getContent();
                if (editor.getPath() != null)
                    SaveFile.saveFile(tab);
            }
        }

        try {
            Thread.sleep(PreferenceData.getAutoSaveDelay());
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
