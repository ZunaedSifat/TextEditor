package texteditor.help;

import java.awt.*;
import java.net.URI;

public class GitHubRepository {

    public static void open() {

        String url = "http://github.com/ZunaedSifat/TextEditor";
        System.out.println(1);

        try {
            System.out.println(2);
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            System.out.println(3);
            e.printStackTrace();
        }
        System.out.println(4);
    }
}
