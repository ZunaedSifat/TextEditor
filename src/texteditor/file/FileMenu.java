package texteditor.file;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import texteditor.main.EditorTab;
import texteditor.main.CodeEditor;
import texteditor.main.Main;

public class FileMenu {

    private static Menu menu = new Menu("_File");
    public static Menu openRecent;

    static {

        MenuItem newFile = new MenuItem("New File");
        newFile.setOnAction(e -> NewFile.createNewFile());
        newFile.setAccelerator(KeyCodeCombination.keyCombination("CTRL+N"));

        MenuItem openFile = new MenuItem("Open File");
        openFile.setOnAction(e -> OpenFile.openFile());
        openFile.setAccelerator(KeyCodeCombination.keyCombination("CTRL+O"));

        openRecent = new Menu("Open Recent...");

        MenuItem saveFile = new MenuItem("Save File");
        saveFile.setOnAction(e -> SaveFile.saveFile() );
        saveFile.setAccelerator(KeyCodeCombination.keyCombination("CTRL+S"));

        MenuItem saveFileAs = new MenuItem("Save File As...");
        saveFileAs.setOnAction(e -> SaveFileAs.saveFileAs());
        saveFileAs.setAccelerator(KeyCodeCombination.keyCombination("CTRL+SHIFT+S"));

        MenuItem saveAllFiles = new MenuItem("Save All Files");
        saveAllFiles.setOnAction(e -> SaveAllFiles.saveAllFiles());
        saveAllFiles.setAccelerator(KeyCodeCombination.keyCombination("CTRL+SHIFT+A"));

        MenuItem closeFile = new MenuItem("Close File");
        closeFile.setOnAction(e -> CloseFile.closeFile());
        closeFile.setAccelerator(KeyCodeCombination.keyCombination("CTRL+W"));

        MenuItem fileProperties = new MenuItem("File Properties");
        fileProperties.setOnAction(e -> {

            EditorTab editor = (EditorTab) CodeEditor.getTabPane().getSelectionModel().getSelectedItem().getContent();
            if (editor.getPath() != null) {
                try {
                    new Properties().start(new Stage());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        fileProperties.setAccelerator(KeyCodeCombination.keyCombination("CTRL+P"));;

        MenuItem exitProgram = new MenuItem("Exit Program");
        exitProgram.setOnAction(e -> Main.close());
        exitProgram.setAccelerator((KeyCodeCombination.keyCombination("ALT+F4")));

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
