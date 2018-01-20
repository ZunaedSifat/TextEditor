package texteditor.file;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import texteditor.editor.EditorTab;
import texteditor.main.CodeEditor;

import java.io.File;
import java.text.SimpleDateFormat;

public class Properties extends Application {

    static Stage window = new Stage();

    public static File getFile() {
        Tab tab = CodeEditor.getTabPane().getSelectionModel().getSelectedItem();
        EditorTab editorTab = (EditorTab) tab.getContent();
        String filePath = editorTab.getPath();

        System.out.println("Properties call for : " + filePath);

        if (filePath == null) window.close();

        return new File(filePath);
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label fileName = new Label("File Name: ");
        GridPane.setConstraints(fileName, 0, 0);
        Label fileNameValue = new Label(getFile().getName());
        GridPane.setConstraints(fileNameValue, 1, 0);

        Label fullPath = new Label("Full Path: ");
        GridPane.setConstraints(fullPath, 0, 1);
        Label fullPathValue = new Label(getFile().getAbsolutePath());
        GridPane.setConstraints(fullPathValue, 1, 1);

        Label lastModified = new Label("Last Modified: ");
        GridPane.setConstraints(lastModified, 0, 2);
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");
        Label lastModifiedValue = new Label(sdf.format(getFile().lastModified()));
        GridPane.setConstraints(lastModifiedValue, 1, 2);

        Label fileSize = new Label("Size: ");
        GridPane.setConstraints(fileSize, 0, 3);

        Label fileSizeValue = new Label(getFile().length() + " Bytes");
        GridPane.setConstraints(fileSizeValue, 1, 3);

        gridPane.getChildren().addAll(
                fileName, fileNameValue,
                fullPath, fullPathValue,
                lastModified, lastModifiedValue,
                fileSize, fileSizeValue
        );

        primaryStage.setScene(new Scene(gridPane, 500, 120));
        primaryStage.setTitle("File Properties");
        primaryStage.show();
    }
}
