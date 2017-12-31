package texteditor.file;

import org.fxmisc.richtext.CodeArea;
import texteditor.main.Main;

public class NewFile {

    public static void createNewFile() {

        CodeArea codeArea = Main.getCodeArea();
        codeArea.clear();
        Main.setCodeArea(codeArea);
    }
}
