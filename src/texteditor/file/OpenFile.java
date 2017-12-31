package texteditor.file;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

import texteditor.main.Main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class OpenFile {

    public static void openFile() { // todo: doesn't work properly, needs modification

        // choose the file first
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(new Stage());

        if (file != null) {

            try {
                FileReader reader = new FileReader(file);
                String text = reader.toString();

                CodeArea codeArea = new CodeArea(text);
                codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
                // check for more formatting

                Main.setCodeArea(codeArea);

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        else {
            // todo: prompt
        }
    }
}
