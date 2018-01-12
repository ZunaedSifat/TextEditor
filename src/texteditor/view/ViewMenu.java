package texteditor.view;

import javafx.scene.control.*;
import org.fxmisc.richtext.LineNumberFactory;
import texteditor.editor.EditorTab;
import texteditor.main.CodeEditor;

public class ViewMenu {

    private static Menu viewMenu  = new Menu("View");
    static {

        CheckMenuItem showFileExplorer = new CheckMenuItem("Show File Explorer");
        showFileExplorer.setOnAction(e -> {

        });

        CheckMenuItem wordWrap = new CheckMenuItem("Word Wrap");
        wordWrap.setSelected(WordWrap.isWordWrapEnabled());
        wordWrap.setOnAction(e -> {
            EditorTab editorTab = (EditorTab) CodeEditor.getTabPane().getSelectionModel().getSelectedItem().getContent();
            editorTab.setWrapText(wordWrap.isSelected());
        });

        CheckMenuItem showLineNumber = new CheckMenuItem("Show Line Number");
        showLineNumber.setSelected(LineNumber.isLineNumberEnabled());
        showLineNumber.setOnAction(e -> {

            EditorTab editorTab = (EditorTab) CodeEditor.getTabPane().getSelectionModel().getSelectedItem().getContent();
            if (!showLineNumber.isSelected())
                editorTab.setParagraphGraphicFactory(null);
            else
                editorTab.setParagraphGraphicFactory(LineNumberFactory.get(editorTab));
        });

        MenuItem font = new MenuItem("Font");
        font.setOnAction(e -> {

        });

        ToggleGroup theme = new ToggleGroup();

        RadioMenuItem darkTheme = new RadioMenuItem("Dark Theme");
        darkTheme.setOnAction(e -> {

        });

        RadioMenuItem lightTheme = new RadioMenuItem("Light Theme");
        lightTheme.setOnAction(e -> {

        });

        darkTheme.setToggleGroup(theme);
        lightTheme.setToggleGroup(theme);

        //todo: read file and set the thing that needs to be checked

        viewMenu.getItems().addAll(showFileExplorer, new SeparatorMenuItem(),
                wordWrap, showLineNumber, new SeparatorMenuItem(),
                font, new SeparatorMenuItem(),
                lightTheme, darkTheme);
    }

    public static Menu getViewMenu() {
        return viewMenu;
    }

    public static void setViewMenu(Menu viewMenu) {
        ViewMenu.viewMenu = viewMenu;
    }
}
