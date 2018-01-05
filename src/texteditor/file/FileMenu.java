package texteditor.file;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileMenu {

    private static Menu menu = new Menu("File");

    static {

        MenuItem newFile = new MenuItem("New File");
        newFile.setOnAction(e -> NewFile.createNewFile() );

        MenuItem openFile = new MenuItem("Open File");
        openFile.setOnAction(e -> OpenFile.openFile());

        MenuItem openRecent = new MenuItem("Open Recent...");
        openRecent.setOnAction(e -> {
            //todo: add open recent actions
        });

        MenuItem saveFile = new MenuItem("Save File");
        saveFile.setOnAction(e -> SaveFile.saveFile() );

        MenuItem saveFileAs = new MenuItem("Save File As...");
        saveFileAs.setOnAction(e -> SaveFileAs.saveFileAs());

        MenuItem saveAllFiles = new MenuItem("Save All Files");
        saveAllFiles.setOnAction(e -> {

        });

        MenuItem closeFile = new MenuItem("Close File");
        closeFile.setOnAction(e -> {

        });

        MenuItem fileProperties = new MenuItem("File Properties");
        fileProperties.setOnAction(e -> {

        });

        MenuItem exitProgram = new MenuItem("Exit Program");
        exitProgram.setOnAction(e -> {
            // exit program
        });

        menu.getItems().addAll(newFile, new SeparatorMenuItem(),
                openFile, openRecent, new SeparatorMenuItem(),
                saveFile, saveFileAs, saveAllFiles, new SeparatorMenuItem(),
                closeFile, fileProperties, new SeparatorMenuItem(),
                exitProgram);
    }

    public static Menu getMenu() {
        return menu;
    }
}
