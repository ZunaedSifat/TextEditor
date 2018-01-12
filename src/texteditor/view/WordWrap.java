package texteditor.view;

import sun.security.ec.ECDHKeyAgreement;

import java.io.BufferedReader;
import java.io.FileReader;

public class WordWrap {

    private static boolean wordWrapEnabled;
    static {
        wordWrapEnabled = true;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/user.csv"));

            while (true) {

                String line = reader.readLine();
                if (line == null) break;

                if (line.startsWith("view.wordWrap") && line.endsWith("false"))
                    wordWrapEnabled = false;
            }
        } catch (Exception e) {

        }
    }
    public static boolean isWordWrapEnabled() {
        return wordWrapEnabled;
    }

    public static void setWordWrapEnabled(boolean wordWrapEnabled) {
        WordWrap.wordWrapEnabled = wordWrapEnabled;
        //todo: write in files
    }
}
