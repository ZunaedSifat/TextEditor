package texteditor.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

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

        //codeArea = (new JavaKeywordsAsync()).getCodeArea();
        codeArea = new CodeArea();
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));

        menuBar = new MenuBar();
        menuBar.getMenus().addAll(texteditor.file.FileMenu.getMenu());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(menuBar, codeArea);

        primaryStage.setTitle("Text Editor");
        primaryStage.setScene(new Scene(layout, 640, 480));
        primaryStage.show();
    }
}
