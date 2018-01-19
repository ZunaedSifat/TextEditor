package texteditor.preferences;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Font extends Application {

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

        TextField fontFaceTextField = new TextField();
        GridPane.setConstraints(fontFaceTextField, 1, 0);

        Label fontSizeLabel = new Label("Font Size: ");
        GridPane.setConstraints(fontSizeLabel, 0, 1);

        TextField fontSizeTextField = new TextField();
        GridPane.setConstraints(fontSizeTextField, 1, 1);

        CheckBox boldCheckBox = new CheckBox("Bold");
        GridPane.setConstraints(boldCheckBox, 0, 2);

        CheckBox italicCheckBox = new CheckBox("Italic");
        GridPane.setConstraints(italicCheckBox, 1, 2);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> {

        });
        GridPane.setConstraints(closeButton, 0, 3);

        Button saveButton = new Button("Save Changes");
        saveButton.setOnAction(e -> {});
        GridPane.setConstraints(saveButton, 1, 3);

        gridPane.getChildren().addAll(fontNameLabel, fontFaceTextField,
                fontSizeLabel, fontSizeTextField,
                boldCheckBox, italicCheckBox,
                closeButton, saveButton);

        Scene scene = new Scene(gridPane, 300, 240);
        primaryStage.setTitle("Font");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
