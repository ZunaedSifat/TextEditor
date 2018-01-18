package texteditor.edit;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import org.fxmisc.richtext.model.Paragraph;
import texteditor.editor.EditorTab;
import texteditor.main.CodeEditor;

public class FindAndReplace extends Application {

    TextField textToFindTextArea;
    TextField replaceWithTextField;
    int startCol = 0;
    int startRow = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label findLabel = new Label("Text to Find: ");
        GridPane.setConstraints(findLabel, 0, 0);

        textToFindTextArea = new TextField();
        GridPane.setConstraints(textToFindTextArea, 1, 0);

        Button findNextButton = new Button("Find Next");
        findNextButton.setOnAction(e -> findNext());
        GridPane.setConstraints(findNextButton, 2, 0);

        Button findPreviousButton = new Button("Find Previous");
        findPreviousButton.setOnAction(e -> findPrevious());
        GridPane.setConstraints(findPreviousButton, 3, 0);

        Label replaceLabel = new Label("Replace with");
        GridPane.setConstraints(replaceLabel, 0, 1);

        replaceWithTextField = new TextField();
        GridPane.setConstraints(replaceWithTextField, 1, 1);

        Button replaceButton = new Button("Replace");
        replaceButton.setOnAction(e -> replace());
        GridPane.setConstraints(replaceButton, 2, 1);

        Button replaceAllButton = new Button("Replace All");
        replaceAllButton.setOnAction(e -> replaceAll());
        GridPane.setConstraints(replaceAllButton, 3, 1);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> {

        });
        GridPane.setConstraints(closeButton, 1, 3);


        gridPane.getChildren().addAll(findLabel, textToFindTextArea, findNextButton, findPreviousButton,
                                      replaceLabel, replaceWithTextField, replaceButton, replaceAllButton,
                                      closeButton);


        Scene scene = new Scene(gridPane, 550, 140);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Find & Replace");
        primaryStage.show();

    }

    private void replaceAll() {

        EditorTab editorTab = (EditorTab) CodeEditor.getTabPane().getSelectionModel().getSelectedItem().getContent();
        if (textToFindTextArea.getText() == null || replaceWithTextField == null)
            return;

        String replacedText = editorTab.getText();
        replacedText = replacedText.replaceAll(textToFindTextArea.getText(), replaceWithTextField.getText());
        editorTab.selectAll();
        editorTab.replaceSelection(replacedText);
    }

    private void replace() {

        if (replaceWithTextField.getText() == null || textToFindTextArea.getText() == null) return;

        EditorTab editorTab = (EditorTab) CodeEditor.getTabPane().getSelectionModel().getSelectedItem().getContent();
        if (editorTab.getSelectedText() != textToFindTextArea.getText()) {
            findNext();
            if (editorTab.getSelection().getLength() == textToFindTextArea.getText().length())
                editorTab.replaceSelection(replaceWithTextField.getText());
            else {
                startCol = 0;
                startRow = 0;
            }
        }
    }

    private void findNext() {

        EditorTab editor = (EditorTab) CodeEditor.getTabPane().getSelectionModel().getSelectedItem().getContent();
        String findText = textToFindTextArea.getText();

        if (startRow >= editor.getParagraphs().size()) {
            startRow = 0;
            startCol = 0;
            return;
        }

        Paragraph paragraph = editor.getParagraph(startRow);
        String text = paragraph.getText();
        if (text.indexOf(findText, startCol) != -1) {

             int startPos = editor.position(startRow, text.indexOf(findText, startCol)).toOffset();
             editor.selectRange(startPos, startPos+findText.length());

             if (text.indexOf(findText, startCol) + findText.length() >= paragraph.getText().length()) {
                 startCol = 0;
                 startRow++;
             } else {
                 startCol = text.indexOf(findText, startCol) + findText.length() + 1;
             }
        } else {
            startCol = 0;
            startRow += 1;
            findNext();
        }
    }


    private void findPrevious() {

        EditorTab editor = (EditorTab) CodeEditor.getTabPane().getSelectionModel().getSelectedItem().getContent();
        String findText = textToFindTextArea.getText();

        if (startCol < 0 || startRow < 0) {
            startRow--;

            if (startRow < 0) {
                startRow = editor.getParagraphs().size() - 1;
                return;
            }
            startCol = editor.getParagraph(startRow).length()-1;
        }

        String text = editor.getParagraph(startRow).getText();
        if (text.lastIndexOf(findText, startCol) != -1) {

            int startPos = editor.position(startRow, text.lastIndexOf(findText, startCol)).toOffset();
            editor.selectRange(startPos, startPos+findText.length());

            startCol = text.lastIndexOf(findText, startCol) - 1;
        } else {

            startRow--;
            if (startRow >= 0) startCol = editor.getParagraph(startRow).length()-1;
            findPrevious();
        }


    }
}
