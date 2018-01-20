package texteditor.file;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import texteditor.editor.EditorTab;
import texteditor.main.CodeEditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class OpenFile {

    public static void openFile() {

        // choose the file first
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            File file = fileChooser.showOpenDialog(new Stage());

            openFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openFile(File file) {

        String path = file.getAbsolutePath();
        TabPane tabPane = CodeEditor.getTabPane();

        for (Tab tab : CodeEditor.getTabPane().getTabs()) {

            String tabPath = ((EditorTab) tab.getContent()).getPath();

            System.out.println(path);
            System.out.println(tabPath);

            if (path.equals(tabPath)) {
                tabPane.getSelectionModel().select(tab);
                return;
            }
        }

        StringBuffer stringBuffer = new StringBuffer("");
        if (file != null) {

            try (BufferedReader reader = new BufferedReader(new FileReader(file))){
                while (true) {
                    String str = reader.readLine();
                    if (str == null) break;
                    stringBuffer.append(str + "\n");
                }

                CodeEditor.addTab(file.getPath(), stringBuffer.toString());
                OpenRecent.add(file.getAbsolutePath());

            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Opened: " + file.getAbsoluteFile());
        }
    }
}
