package texteditor.help;

import java.awt.*;
import java.net.URI;

public class GitHubRepository {

    public static void open() {

        Desktop desktop = Desktop.getDesktop();

        try {
            desktop.browse(new URI("http://github.com/ZunaedSifat/TextEditor"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
