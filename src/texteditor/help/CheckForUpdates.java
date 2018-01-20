package texteditor.help;

import java.awt.Desktop;
import java.net.URI;

public class CheckForUpdates implements Runnable {

    private static String url;

    static {
        url = "http://rebornplusplus.wordpress.com/blog";
    }

    @Override
    public void run() {
        if(Desktop.isDesktopSupported()) {
            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.browse(new URI(url));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {
            /* todo: only done for linux systems, do for others */
            Runtime runtime = Runtime.getRuntime();
            try {
                System.out.println("xdg-open");
                runtime.exec("xdg-open " + url);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
