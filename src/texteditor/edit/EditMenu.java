package texteditor.edit;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.security.Key;

public class EditMenu {

    private static Menu editMenu = new Menu("_Edit");

    static {

        MenuItem undo = new MenuItem("Undo");
        undo.setOnAction(e -> Undo.undo());
        undo.setAccelerator(KeyCodeCombination.keyCombination("CTRL+Z"));

        MenuItem redo = new MenuItem("Redo");
        redo.setOnAction(e -> Redo.redo());
        redo.setAccelerator(KeyCodeCombination.keyCombination("CTRL+SHIFT+Z"));


        MenuItem copy = new MenuItem("Copy");
        copy.setOnAction(e -> Copy.copy());
        copy.setAccelerator(KeyCodeCombination.keyCombination("CTRL+C"));

        MenuItem cut = new MenuItem("Cut");
        cut.setOnAction(e -> Cut.cut());
        cut.setAccelerator(KeyCodeCombination.keyCombination("CTRL+X"));

        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> Paste.paste());
        paste.setAccelerator(KeyCodeCombination.keyCombination("CTRL+V"));

        MenuItem findAndReplace = new MenuItem("Find & Replace");
        findAndReplace.setOnAction(e -> {
            try {
                 (new FindAndReplace()).start(new Stage());
            } catch (Exception ex) {
                //ex.printStackTrace();
            }
        });
        findAndReplace.setAccelerator(KeyCodeCombination.keyCombination("CTRL+F"));

        MenuItem selectAll = new MenuItem("Select All");
        selectAll.setOnAction(e -> SelectAll.selectAll());
        selectAll.setAccelerator(KeyCodeCombination.keyCombination("CTRL+A"));

        editMenu.getItems().addAll(undo, redo, new SeparatorMenuItem(),
                copy, cut, paste, new SeparatorMenuItem(),
                findAndReplace, new SeparatorMenuItem(),
                selectAll);
    }

    public static Menu getEditMenu() {
        return editMenu;
    }
}
