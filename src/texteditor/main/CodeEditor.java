package texteditor.main;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import texteditor.editor.EditorTab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Optional;

public class CodeEditor {

    private static TabPane tabPane = new TabPane();
    private static ArrayList <EditorTab> list = new ArrayList<>();

    static {
        EditorTab editorTab = new EditorTab(null, null);
        addTab(editorTab);
    }

    public static TabPane getTabPane() {
        return tabPane;
    }

    public static void setTabPane(TabPane tabPane) {
        CodeEditor.tabPane = tabPane;
    }

    public static ArrayList<EditorTab> getList() {
        return list;
    }

    public static void setList(ArrayList<EditorTab> list) {
        CodeEditor.list = list;
    }

    public static void addTab(EditorTab editorTab) {

        Tab tab = new Tab(editorTab.getTabname());
        tab.setContent(editorTab.getCodeArea());
        tab.setOnCloseRequest(e -> {

            for (EditorTab item : list) {

                if (item.getCodeArea() == tab.getContent())
                    System.out.println("yes");
                    closeTab(item);
            }
            //todo: check whether the file is updated
            // show prompt about saving the changes.
        });

        tabPane.getTabs().add(tab);
    }

    public static void closeTab(EditorTab tab) {

        if (tab.getFilename() == null || tab.getPath() == null) {

            if (tab.getCodeArea().getText() == null || tab.getCodeArea().getText() == "")
                return;

            texteditor.file.SaveFile.saveFile(tab);
            return;
        }

        String currentText = tab.getCodeArea().getText();
        StringBuffer savedText = new StringBuffer("");

        try {
            BufferedReader reader = new BufferedReader( new FileReader(tab.getPath() + tab.getFilename()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (!currentText.equals(savedText)) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("File Not Saved");
            alert.setHeaderText("This file is not saved. All changes will be forgot.");
            alert.setContentText("Save without exit?");

            Optional <ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
                ; // do nothing
            else ; // todo: save file
        }
    }
}
