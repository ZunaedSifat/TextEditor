package texteditor.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LineNumber {

    private static boolean lineNumberEnabled = true;
    static {
        try {
            BufferedReader reader = new BufferedReader( new FileReader("data/user.csv"));

            while (true) {

                String line = reader.readLine();
                if (line == null) break;

                if (line.startsWith("view.lineNumber") && line.endsWith("false"))
                    lineNumberEnabled = false;
            }
            reader.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isLineNumberEnabled() {
        return lineNumberEnabled;
    }

    public static void setLineNumberEnabled(boolean value) {
        lineNumberEnabled = value;
        //todo: write in file
    }
}
