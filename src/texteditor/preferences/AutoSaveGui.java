package texteditor.preferences;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class AutoSaveGui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(30);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        Label delayLabel = new Label("Delay (s) :");
        GridPane.setConstraints(delayLabel, 0, 0);

        TextField delayTextField = new TextField();
        delayTextField.setPromptText("Enter delay time");
        GridPane.setConstraints(delayTextField, 1, 0);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> primaryStage.close());
        GridPane.setConstraints(closeButton, 0, 1);

        Button toggleAutoSaveButton = new Button();
        toggleAutoSaveButton.setText(PreferenceData.isAutoSaveEnabled() ? "Disable Auto Save" : "Enable Auto Save");
        toggleAutoSaveButton.setOnAction(e -> PreferenceData.setAutoSaveEnabled(!PreferenceData.isAutoSaveEnabled()));
        GridPane.setConstraints(toggleAutoSaveButton, 1, 1);

        gridPane.getChildren().addAll(delayLabel, delayTextField,
                closeButton, toggleAutoSaveButton);

        Scene scene = new Scene(gridPane, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Auto Save Dialog");
        primaryStage.show();
    }
}
