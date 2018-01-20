package texteditor.main;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import texteditor.editor.EditorTab;
import texteditor.file.CloseFile;

public class CodeEditor {

    private static TabPane tabPane;
    static {

        Tab tab = new Tab("Untitled");
        tab.setContent(new EditorTab(null));
        tab.setOnCloseRequest(e -> CloseFile.closeFile(tab));

        tabPane = new TabPane();
        tabPane.getTabs().add(tab);
    }

    public static TabPane getTabPane() {
        return tabPane;
    }

    public static void addTab(String path) {

        String title = (path == null) ? "Untitled" : path;

        Tab tab = new Tab(title);
        EditorTab editor = new EditorTab(path);
        tab.setContent(editor);
        tab.setOnCloseRequest(e -> CloseFile.closeFile(tab));

        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);
    }

    public static void addTab(String path, String text) {

        String title = (path == null) ? "Untitled" : path.split("/")[path.split("/").length-1];
        Tab tab = new Tab(title);
        tab.setContent(new EditorTab(path, text));
        tab.setOnCloseRequest(e -> CloseFile.closeFile(tab));

        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);
    }
}
