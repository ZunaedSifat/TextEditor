package texteditor.preferences;

import javafx.scene.control.*;
import org.fxmisc.richtext.LineNumberFactory;
import texteditor.editor.EditorTab;
import texteditor.main.CodeEditor;

public class PreferenceMenu {

    private static Menu preferencesMenu  = new Menu("Preferences");
    static {

        CheckMenuItem autoSave = new CheckMenuItem("Auto Save Files");
        autoSave.setOnAction(e -> {

            //todo: implement a thread to save files every (30s/1m/2m/5m)

        });

        CheckMenuItem wordWrap = new CheckMenuItem("Word Wrap");
        wordWrap.setSelected(WordWrap.isWordWrapEnabled());
        wordWrap.setOnAction(e -> {

            for (Tab tab : CodeEditor.getTabPane().getTabs()) {

                EditorTab editorTab = (EditorTab) tab.getContent();
                editorTab.setWrapText(wordWrap.isSelected());
            }
        });

        CheckMenuItem showLineNumber = new CheckMenuItem("Show Line Number");
        showLineNumber.setSelected(LineNumber.isLineNumberEnabled());
        showLineNumber.setOnAction(e -> {

            for (Tab tab : CodeEditor.getTabPane().getTabs()) {

                EditorTab editorTab = (EditorTab) tab.getContent();
                if (!showLineNumber.isSelected())
                    editorTab.setParagraphGraphicFactory(null);
                else
                    editorTab.setParagraphGraphicFactory(LineNumberFactory.get(editorTab));
            }
        });

        MenuItem font = new MenuItem("Font");
        font.setOnAction(e -> {});

        MenuItem resetPreferences = new MenuItem("Reset Preferences");
        resetPreferences.setOnAction(e -> {});

        preferencesMenu.getItems().addAll(autoSave, new SeparatorMenuItem(),
                wordWrap, showLineNumber, new SeparatorMenuItem(),
                font, new SeparatorMenuItem(),
                resetPreferences );
    }

    public static Menu getPreferencesMenu() {
        return preferencesMenu;
    }
}
