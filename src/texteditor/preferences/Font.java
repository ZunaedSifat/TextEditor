package texteditor.preferences;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import texteditor.editor.EditorTab;
import texteditor.main.CodeEditor;

public class Font extends Application {

    private static TextField fontFaceTextField;
    private static TextField fontSizeTextField;
    private static CheckBox italicCheckBox;
    private static CheckBox boldCheckBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(30);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        Label fontNameLabel = new Label("Font Name: ");
        GridPane.setConstraints(fontNameLabel, 0, 0);

        fontFaceTextField = new TextField(PreferenceData.getFontFace());
        GridPane.setConstraints(fontFaceTextField, 1, 0);

        Label fontSizeLabel = new Label("Font Size: ");
        GridPane.setConstraints(fontSizeLabel, 0, 1);

        fontSizeTextField = new TextField(((Integer)PreferenceData.getFontSize()).toString());
        GridPane.setConstraints(fontSizeTextField, 1, 1);

        boldCheckBox = new CheckBox("Bold");
        boldCheckBox.setSelected(PreferenceData.isBoldFont());
        GridPane.setConstraints(boldCheckBox, 0, 2);

        italicCheckBox = new CheckBox("Italic");
        italicCheckBox.setSelected(PreferenceData.isItalicFont());
        GridPane.setConstraints(italicCheckBox, 1, 2);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> primaryStage.close());
        GridPane.setConstraints(closeButton, 0, 3);

        Button saveButton = new Button("Save Changes");
        saveButton.setOnAction(e -> save());
        GridPane.setConstraints(saveButton, 1, 3);

        gridPane.getChildren().addAll(fontNameLabel, fontFaceTextField,
                fontSizeLabel, fontSizeTextField,
                boldCheckBox, italicCheckBox,
                closeButton, saveButton);

        Scene scene = new Scene(gridPane, 300, 240);
        primaryStage.setTitle("Font");
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    private void save() {

        for (Tab tab : CodeEditor.getTabPane().getTabs()) {

            PreferenceData.setFontFace(fontFaceTextField.getText());
            PreferenceData.setFontSize(Integer.parseInt(fontSizeTextField.getText()));
            PreferenceData.setBoldFont(boldCheckBox.isSelected());
            PreferenceData.setItalicFont(italicCheckBox.isSelected());

            EditorTab editor = (EditorTab) tab.getContent();
            editor.setStyle(PreferenceData.getFontStyle());
        }
    }

    public static void reset() {
        for (Tab tab : CodeEditor.getTabPane().getTabs()) {

            EditorTab editor = (EditorTab) tab.getContent();
            editor.setStyle(PreferenceData.getFontStyle());
        }


    }
}
