package texteditor.file;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;

public class FileMenu {

    private static Menu menu = new Menu("File");

    static {

        MenuItem newFile = new MenuItem("New File");
        newFile.setOnAction(e -> NewFile.createNewFile() );

        MenuItem openFile = new MenuItem("Open File");
        openFile.setOnAction(e -> {
            //todo: add fileSelector and open it.
        });

        MenuItem openRecent = new MenuItem("Open Recent...");
        openRecent.setOnAction(e -> {
            //todo: add open recent actions
        });

        MenuItem saveFile = new MenuItem("Save File");
        saveFile.setOnAction(e -> SaveFile.saveFile(new Stage()) );

        MenuItem saveFileAs = new MenuItem("Save File As...");
        saveFileAs.setOnAction(e -> {
            //todo: save file as action
        });

        MenuItem exitProgram = new MenuItem("Exit Program");
        exitProgram.setOnAction(e -> {
            // exit program
        });

        menu.getItems().addAll(newFile, new SeparatorMenuItem(),
                openFile, openRecent, new SeparatorMenuItem(),
                saveFile, saveFileAs, new SeparatorMenuItem(),
                exitProgram);
    }

    public static Menu getMenu() {
        return menu;
    }
}
