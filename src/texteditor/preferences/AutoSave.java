package texteditor.preferences;

import javafx.scene.control.Tab;
import texteditor.editor.EditorTab;
import texteditor.file.SaveFile;
import texteditor.main.CodeEditor;

public class AutoSave implements Runnable {

    private boolean autosaveOn;
    private static AutoSave object;
    private int delay;

    private AutoSave() {

        autosaveOn = false;
        //todo: read from file
    }

    @Override
    public void run() {

        if (autosaveOn) {

            for (Tab tab : CodeEditor.getTabPane().getTabs()) {

                EditorTab editor = (EditorTab) tab.getContent();
                if (editor.getPath() != null)
                    SaveFile.saveFile(tab);
            }
        }

        try {
            Thread.sleep(delay);
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public void autoSaveEnable(int delay) {

        if (object == null) object = new AutoSave();
        object.delay = delay;
        object.autosaveOn = true;
    }

    public void setAutosaveDisable() {

        if (object == null) object = new AutoSave();
        object.autosaveOn = false;
    }
}
