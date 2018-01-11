package test;

import java.awt.*;
import java.net.URI;

public class HyperlinkTest {

    public static void main(String[] args) {

        String url = "http://github.com/ZunaedSifat/TextEditor";
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
