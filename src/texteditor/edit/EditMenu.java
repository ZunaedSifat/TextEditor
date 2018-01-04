package texteditor.edit;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class EditMenu {

    private static Menu editMenu = new Menu("Edit");
    static {

        MenuItem undo = new MenuItem("Undo");
        undo.setOnAction(e -> {

        });

        MenuItem redo = new MenuItem("Redo");
        redo.setOnAction(e -> {

        });

        MenuItem copy = new MenuItem("Copy");
        copy.setOnAction(e -> {

        });

        MenuItem cut = new MenuItem("Cut");
        cut.setOnAction(e -> {

        });

        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> {

        });

        MenuItem find = new MenuItem("Find");
        find.setOnAction(e -> {

        });

        MenuItem replace = new MenuItem("Replace");
        replace.setOnAction(e -> {

        });

        MenuItem selectAll = new MenuItem("Select All");
        selectAll.setOnAction(e -> {

        });

        MenuItem invertSelection = new MenuItem("Invert Selection");
        invertSelection.setOnAction(e -> {

        });

        editMenu.getItems().addAll(undo, redo, new SeparatorMenuItem(),
                copy, cut, paste, new SeparatorMenuItem(),
                find, replace, new SeparatorMenuItem(),
                selectAll, invertSelection);
    }

    public static Menu getEditMenu() {
        return editMenu;
    }

    public static void setEditMenu(Menu editMenu) {
        EditMenu.editMenu = editMenu;
    }
}
