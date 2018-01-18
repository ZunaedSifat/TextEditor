package texteditor.edit;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;

public class EditMenu {

    private static Menu editMenu = new Menu("Edit");

    static {

        MenuItem undo = new MenuItem("Undo");
        undo.setOnAction(e -> Undo.undo());

        MenuItem redo = new MenuItem("Redo");
        redo.setOnAction(e -> Redo.redo());

        MenuItem copy = new MenuItem("Copy");
        copy.setOnAction(e -> Copy.copy());

        MenuItem cut = new MenuItem("Cut");
        cut.setOnAction(e -> Cut.cut());

        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> Paste.paste());

        MenuItem findAndReplace = new MenuItem("Find & Replace");
        findAndReplace.setOnAction(e -> {
            try {
                 (new FindAndReplace()).start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        MenuItem selectAll = new MenuItem("Select All");
        selectAll.setOnAction(e -> SelectAll.selectAll());

        MenuItem invertSelection = new MenuItem("Invert Selection");
        invertSelection.setOnAction(e -> {

        });

        editMenu.getItems().addAll(undo, redo, new SeparatorMenuItem(),
                copy, cut, paste, new SeparatorMenuItem(),
                findAndReplace, new SeparatorMenuItem(),
                selectAll, invertSelection);
    }

    public static Menu getEditMenu() {
        return editMenu;
    }
}
