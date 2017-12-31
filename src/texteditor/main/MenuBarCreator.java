package texteditor.main;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuBarCreator {

    private MenuBar menuBar;

    public MenuBarCreator() {

        Menu file = new Menu("File");
        file.getItems().add(new MenuItem("New"));

        Menu edit = new Menu("Edit");
        file.getItems().add(new MenuItem("Cut"));

        menuBar.getMenus().addAll(file, edit);
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }
}
