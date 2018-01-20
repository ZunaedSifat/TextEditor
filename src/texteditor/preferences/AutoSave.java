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

        while (!PreferenceData.isProgramClosed()) {

            if (PreferenceData.isAutoSaveEnabled()) {

                for (Tab tab : CodeEditor.getTabPane().getTabs()) {

                    EditorTab editor = (EditorTab) tab.getContent();
                    if (editor.getPath() != null)
                        SaveFile.saveFile(tab);

                    System.out.println("Saving: " + editor.getPath());
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
