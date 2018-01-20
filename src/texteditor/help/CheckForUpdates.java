package texteditor.help;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.Scanner;

public class CheckForUpdates implements Runnable {

    private static String updatesUrl;
    private static String updatesFile;
    private Thread t;

    static {
        updatesUrl = "https://raw.githubusercontent.com/rebornplusplus/CodeX/master/Meh/updates";
        updatesFile = "./data/updates";
    }

    CheckForUpdates() {
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            String localVersion = new String();
            String localUpdateFile = new String();
            BufferedReader in = new BufferedReader(new FileReader(updatesFile));

            String line;
            while((line = in.readLine()) != null) {
                if (line.startsWith("version")) {
                    localVersion = line.substring(line.lastIndexOf(" : ") + 3);
                }
                else if (line.startsWith("updated")) {
                    localUpdateFile = line.substring(line.lastIndexOf(" : ") + 3);
                }
            }

            String onlineVersion = new String();
            String onlineUpdateFile = new String();
            URL url = new URL(updatesUrl);
            in = new BufferedReader(new InputStreamReader(url.openStream()));

            while((line = in.readLine()) != null) {
                if (line.startsWith("version")) {
                    onlineVersion = line.substring(line.lastIndexOf(" : ") + 3);
                }
                else if (line.startsWith("updated")) {
                    onlineUpdateFile = line.substring(line.lastIndexOf(" : ") + 3);
                }
            }

            System.out.println(localVersion + " - " + localUpdateFile);
            System.out.println(onlineVersion + " - " + onlineUpdateFile);

            if(localVersion.equals(onlineVersion)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Updates");
                alert.setHeaderText("Meh is already up-to-date!");
                System.out.println("Same version, do didn't update");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Updates");
                alert.setHeaderText("Updates available!");
                alert.setContentText("Do you want to install them?");

                Optional<ButtonType> result = alert.showAndWait();
                if(result.get() == ButtonType.OK) {
                    url = new URL(onlineUpdateFile);
                    InputStream getUpdate = url.openStream();
                    OutputStream setUpdate = new FileOutputStream(localUpdateFile);

                    while(true) {
                        int c = getUpdate.read();
                        if(c == -1) break;
                        setUpdate.write(c);
                    }
                    getUpdate.close();
                    setUpdate.close();

                    System.out.println("updating complete");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
