package texteditor.file;

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
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(new Stage());

        openFile(file);
    }

    public static void openFile(File file) {

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
