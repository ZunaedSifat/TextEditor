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

        System.out.println(PreferenceData.isAutoSaveEnabled());

        while (true) {
            if (PreferenceData.isAutoSaveEnabled()) {

                for (Tab tab : CodeEditor.getTabPane().getTabs()) {

                    EditorTab editor = (EditorTab) tab.getContent();
                    if (editor.getPath() != null) {
                        SaveFile.saveFile(tab);
                        System.out.println("Automatically saved files: " + editor.getPath());
                    }
                }
            }

            try {
                Thread.sleep(PreferenceData.getAutoSaveDelay() * 1000);
            } catch ( Exception e) {
                e.printStackTrace();
            }
        }
    }
}
