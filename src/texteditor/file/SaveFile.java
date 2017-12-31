package texteditor.file;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import texteditor.main.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {

    // todo: this code should have been placed in SaveFileAs. If I know which file I am editing,
    // todo: I should not call this window. just save here. Unless known, call SaveFileAs

    public static void saveFile(Stage saveWindow) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        File file = fileChooser.showSaveDialog(saveWindow);

        if (file != null) {

            try {

                String text = Main.getCodeArea().getText();
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(text);
                fileWriter.close();

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
}
