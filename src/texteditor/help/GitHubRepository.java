package texteditor.help;

import java.awt.*;
import java.net.URI;

public class GitHubRepository {

    public static void open() {

        String url = "http://github.com/ZunaedSifat/TextEditor";

        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
