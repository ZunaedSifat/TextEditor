package texteditor.file;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class FileMenu {

    private static Menu menu = new Menu("File");

    static {
        MenuItem newFile = new MenuItem("New File");
        newFile.setOnAction(e -> {
            NewFile.createNewFile();
        });
        MenuItem openFile = new MenuItem("Open File");
        menu.getItems().addAll(newFile, new SeparatorMenuItem(), openFile);
    }

    public static Menu getMenu() {
        return menu;
    }
}
