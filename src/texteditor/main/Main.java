package texteditor.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.fxmisc.richtext.CodeArea;
import texteditor.editor.Tab;

public class Main extends Application{

    private static CodeArea codeArea;
    private static MenuBar menuBar;

    public static CodeArea getCodeArea() {
        return codeArea;
    }

    public static void setCodeArea(CodeArea codeAreaArg) {
        codeArea = codeAreaArg;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Tab tab1 = new Tab(null, null);
        Tab tab2 = new Tab(null, null);

        menuBar = new MenuBar();
        menuBar.getMenus().addAll(texteditor.file.FileMenu.getMenu(),
                                texteditor.edit.EditMenu.getEditMenu(),
                                texteditor.view.ViewMenu.getViewMenu(),
                                texteditor.help.HelpMenu.getHelp());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(menuBar, tab1.getCodeArea());

        primaryStage.setTitle("Text Editor");
        primaryStage.setScene(new Scene(layout, 640, 480));
        layout.getChildren().addAll(tab2.getCodeArea());
        primaryStage.show();
    }
}