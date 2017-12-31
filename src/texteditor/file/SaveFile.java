package texteditor.file;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import texteditor.data.FileInfo;
import texteditor.main.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {

    public static void saveFile() {

        // If I know where to save the changes, why prompt again? :D
        if (FileInfo.getFilename() != null) {
            try {

                String text = Main.getCodeArea().getText();
                FileWriter fileWriter = new FileWriter(FileInfo.getFilename());
                fileWriter.write(text);
                fileWriter.close();

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        else SaveFIleAs.saveFileAs(); // No choice :'(
    }
}
