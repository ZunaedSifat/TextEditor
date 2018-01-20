package texteditor.preferences;

import javafx.scene.control.*;
import javafx.stage.Stage;

public class PreferenceMenu {

    private static Menu preferencesMenu  = new Menu("Preferences");
    private static CheckMenuItem autoSave;
    static {

        autoSave = new CheckMenuItem("Auto Save Files");
        autoSave.setOnAction(e -> {

            if (autoSave.isSelected()) {
                try {
                    (new AutoSaveGui()).start(new Stage());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                PreferenceData.setAutoSaveEnabled(false);
            }
        });

        CheckMenuItem wordWrap = new CheckMenuItem("Word Wrap");
        wordWrap.setSelected(PreferenceData.isWordWrapEnabled());
        wordWrap.setOnAction(e -> {
            PreferenceData.setWordWrapEnabled(wordWrap.isSelected());
            WordWrap.wordWrap();
        });

        CheckMenuItem showLineNumber = new CheckMenuItem("Show Line Number");
        showLineNumber.setSelected(PreferenceData.isLineNumberEnabled());
        showLineNumber.setOnAction(e -> {
            PreferenceData.setLineNumberEnabled(showLineNumber.isSelected());
            LineNumber.lineNumber();
        });

        MenuItem font = new MenuItem("Font");
        font.setOnAction(e -> {
            try {
                (new Font()).start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        MenuItem resetPreferences = new MenuItem("Reset Preferences");
        resetPreferences.setOnAction(e -> ResetPreference.resetPreference());

        preferencesMenu.getItems().addAll(autoSave, new SeparatorMenuItem(),
                wordWrap, showLineNumber, new SeparatorMenuItem(),
                font, new SeparatorMenuItem(),
                resetPreferences );
    }

    public static Menu getPreferencesMenu() {
        return preferencesMenu;
    }

    public static CheckMenuItem getAutoSave() {
        return autoSave;
    }
}
