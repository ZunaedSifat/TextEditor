package texteditor.main;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import texteditor.editor.EditorTab;

public class CodeEditor {

    private static TabPane tabPane;
    static {

        Tab tab = new Tab("Untitled");
        tab.setContent(new EditorTab(null));
        // todo: close actions and others

        tabPane = new TabPane();
        tabPane.getTabs().add(tab);
    }

    public static TabPane getTabPane() {
        return tabPane;
    }

    public static void addTab(String path) {

        String title = (path == null) ? "Untitled" : path;
        Tab tab = new Tab(title);
        tab.setContent(new EditorTab(path));
        // todo: close actions and others
        tabPane.getTabs().add(tab);
    }

    public static void addTab(String path, String text) {

        String title = (path == null) ? "Untitled" : path;
        Tab tab = new Tab(title);
        tab.setContent(new EditorTab(path, text));
        // todo: close actions and others
        tabPane.getTabs().add(tab);
        //todo: set selection
    }
}
