package texteditor.help;

import java.awt.Desktop;
import java.net.URI;

public class OpenUrl implements Runnable {

    private String url;
    private Thread t;

    public OpenUrl(String url) {
        this.url = url;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        if(Desktop.isDesktopSupported()) {
            try {
                System.out.println("browser: " + url);
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
