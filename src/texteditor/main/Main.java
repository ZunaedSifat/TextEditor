package texteditor.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.fxmisc.richtext.CodeArea;

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

        codeArea = (new JavaKeywordsAsync()).getCodeArea();

        menuBar = new MenuBar();
        menuBar.getMenus().add(texteditor.file.FileMenu.getMenu());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(menuBar, codeArea);

        primaryStage.setTitle("Text Editor");
        primaryStage.setScene(new Scene(layout, 640, 480));
        primaryStage.show();
    }
}
