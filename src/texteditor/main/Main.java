package texteditor.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import texteditor.preferences.AutoSave;
import texteditor.preferences.PreferenceData;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Thread autoSave = new Thread(AutoSave.getObject());
        autoSave.start();

        VBox layout = new VBox(10);
        layout.getChildren().addAll(MenuBarCreator.getMenuBar(), CodeEditor.getTabPane());

        primaryStage.setTitle("Text Editor");
        primaryStage.setScene(new Scene(layout, 640, 480));
        primaryStage.setOnCloseRequest(e -> {
            PreferenceData.writeData();
            PreferenceData.setProgramClosed(true);
            System.exit(0);
        });
        primaryStage.show();
    }
}