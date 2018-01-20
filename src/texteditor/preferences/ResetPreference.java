package texteditor.preferences;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ResetPreference {

    public static void resetPreference() {
        String source = "./data/default.csv";
        String destination = "./data/user.csv";


        try {
            InputStream in = new FileInputStream(source);
            OutputStream out = new FileOutputStream(destination);
            while (true) {
                int c = in.read();
                if (c == -1) break;
                out.write(c);
            }

            in.close();
            out.close();

            PreferenceData.readData();
            LineNumber.lineNumber();
            WordWrap.wordWrap();
            Font.reset();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
