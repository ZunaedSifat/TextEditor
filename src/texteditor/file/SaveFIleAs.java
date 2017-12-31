package texteditor.file;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import texteditor.data.FileInfo;
import texteditor.main.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFIleAs {

    public static void saveFileAs() {

        // chose the file to save first
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        File file = fileChooser.showSaveDialog(new Stage());


        if (file != null) {

            try {

                // write the file
                String text = Main.getCodeArea().getText();
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(text);
                fileWriter.close();

                // updating file info in the database
                FileInfo.setFilename(file.getAbsoluteFile().toString());
                FileInfo.addNewFileToRecentList(file.getAbsoluteFile().toString());

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        else {

            //todo: show prompt
        }
    }
}
