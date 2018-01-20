package texteditor.file;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;
import texteditor.main.EditorTab;
import texteditor.main.CodeEditor;
import texteditor.main.Main;

public class FileMenu {

    private static Menu menu = new Menu("File");

    public static MenuItem[] recents = new MenuItem[5];
    public static Menu openRecent;

    static {

        MenuItem newFile = new MenuItem("New File");
        newFile.setOnAction(e -> NewFile.createNewFile() );

        MenuItem openFile = new MenuItem("Open File");
        openFile.setOnAction(e -> OpenFile.openFile());

        openRecent = new Menu("Open Recent...");

        MenuItem saveFile = new MenuItem("Save File");
        saveFile.setOnAction(e -> SaveFile.saveFile() );

        MenuItem saveFileAs = new MenuItem("Save File As...");
        saveFileAs.setOnAction(e -> SaveFileAs.saveFileAs());

        MenuItem saveAllFiles = new MenuItem("Save All Files");
        saveAllFiles.setOnAction(e -> SaveAllFiles.saveAllFiles());

        MenuItem closeFile = new MenuItem("Close File");
        closeFile.setOnAction(e -> CloseFile.closeFile());

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

        MenuItem exitProgram = new MenuItem("Exit Program");
        exitProgram.setOnAction(e -> Main.close());

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
