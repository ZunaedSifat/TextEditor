package texteditor.main;

import java.net.URL;
import java.time.Duration;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

public class EditorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem newFileMenuItem;

    @FXML
    private MenuItem openFIleMenuItem;

    @FXML
    private MenuItem openRecentMenuItem;

    @FXML
    private MenuItem saveFileMenuItem;

    @FXML
    private MenuItem saveFileAsMenuItem;

    @FXML
    private MenuItem closeFileMenuItem;

    @FXML
    private MenuItem exitProgramMenuItem;

    @FXML
    private MenuItem undoMenuItem;

    @FXML
    private MenuItem redoMenuItem;

    @FXML
    private MenuItem cutMenuItem;

    @FXML
    private MenuItem copyMenuItem;

    @FXML
    private MenuItem pasteMenuItem;

    @FXML
    private MenuItem findReplaceMenuItem;

    @FXML
    private CodeArea codeArea;

    @FXML
    void closeFileOnAction(ActionEvent event) {

    }

    @FXML
    void copyOnAction(ActionEvent event) {

    }

    @FXML
    void cutOnAction(ActionEvent event) {

        if (codeArea.getSelectedText() != null)
            codeArea.cut();
    }

    @FXML
    void exitProgramOnAction(ActionEvent event) {

    }

    @FXML
    void findReplaceOnAction(ActionEvent event) {

    }

    @FXML
    void newFileOnAction(ActionEvent event) {

    }

    @FXML
    void openFIleOnAction(ActionEvent event) {

    }

    @FXML
    void openRecentOnAction(ActionEvent event) {

    }

    @FXML
    void pasteOnAction(ActionEvent event) {
        codeArea.paste();
    }

    @FXML
    void redoOnAction(ActionEvent event) {

        if (codeArea.isRedoAvailable())
            codeArea.redo();
    }

    @FXML
    void saveFileAsOnAction(ActionEvent event) {

    }

    @FXML
    void saveFileOnAction(ActionEvent event) {

    }

    @FXML
    void undoOnAction(ActionEvent event) {
        if (codeArea.isUndoAvailable())
            codeArea.undo();
    }

    @FXML
    void initialize() {
        assert newFileMenuItem != null : "fx:id=\"newFileMenuItem\" was not injected: check your FXML file 'editorwindow.fxml'.";
        assert openFIleMenuItem != null : "fx:id=\"openFIleMenuItem\" was not injected: check your FXML file 'editorwindow.fxml'.";
        assert openRecentMenuItem != null : "fx:id=\"openRecentMenuItem\" was not injected: check your FXML file 'editorwindow.fxml'.";
        assert saveFileMenuItem != null : "fx:id=\"saveFileMenuItem\" was not injected: check your FXML file 'editorwindow.fxml'.";
        assert saveFileAsMenuItem != null : "fx:id=\"saveFileAsMenuItem\" was not injected: check your FXML file 'editorwindow.fxml'.";
        assert closeFileMenuItem != null : "fx:id=\"closeFileMenuItem\" was not injected: check your FXML file 'editorwindow.fxml'.";
        assert exitProgramMenuItem != null : "fx:id=\"exitProgramMenuItem\" was not injected: check your FXML file 'editorwindow.fxml'.";
        assert undoMenuItem != null : "fx:id=\"undoMenuItem\" was not injected: check your FXML file 'editorwindow.fxml'.";
        assert redoMenuItem != null : "fx:id=\"redoMenuItem\" was not injected: check your FXML file 'editorwindow.fxml'.";
        assert cutMenuItem != null : "fx:id=\"cutMenuItem\" was not injected: check your FXML file 'editorwindow.fxml'.";
        assert copyMenuItem != null : "fx:id=\"copyMenuItem\" was not injected: check your FXML file 'editorwindow.fxml'.";
        assert pasteMenuItem != null : "fx:id=\"pasteMenuItem\" was not injected: check your FXML file 'editorwindow.fxml'.";
        assert findReplaceMenuItem != null : "fx:id=\"findReplaceMenuItem\" was not injected: check your FXML file 'editorwindow.fxml'.";

        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));

    }
}

