package texteditor.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import texteditor.file.CloseFile;
import texteditor.file.OpenFile;
import texteditor.file.OpenRecent;
import texteditor.preferences.PreferenceData;

public class Main extends Application{

    public static void main(String[] args) {
        Initializer.initialize();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane layout = new BorderPane();
        layout.setTop(MenuBarCreator.getMenuBar());
        layout.setCenter(CodeEditor.getTabPane());

        primaryStage.setTitle("Text Editor");
        primaryStage.setScene(new Scene(layout, 640, 480));

        primaryStage.setOnCloseRequest(e -> close());
        primaryStage.show();
    }

    public static void close() {
        PreferenceData.writeData();
        PreferenceData.setProgramClosed(true);
        OpenRecent.writeData();
        CloseFile.closeAll();
    }
}