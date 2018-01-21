package texteditor.help;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.net.URL;
import java.util.Optional;
import java.util.Scanner;

public class CheckForUpdates implements Runnable {

    private enum State { CHECKING, FOUND, NOT_FOUND, OPENING, CLOSING }
    private State state;
    private String downloadUrl;

    public CheckForUpdates() {
        this.state = State.CHECKING;
        this.downloadUrl = null;
    }

    @Override
    public void run() {

        try {

            while (state != State.CLOSING) {

                if (state == State.CHECKING) {

                    URL url = new URL("https://github.com/ZunaedSifat/TextEditor/blob/master/data/updates");
                    Scanner data = new Scanner(url.openStream());

                    if (data.nextLine().split(" : ")[1].equalsIgnoreCase("1.0")) {

                        this.downloadUrl = data.nextLine().split(" : ")[1];
                        state = State.FOUND;
                    } else {
                        state = State.NOT_FOUND;
                    }

                } else if (state == State.FOUND) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Updates");
                    alert.setHeaderText("An update has been found.");
                    alert.setContentText("Do you want the updated file?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK)
                        state = State.OPENING;
                    else state = State.CLOSING;

                } else if (state == State.NOT_FOUND) {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Updates");
                    alert.setHeaderText(null);
                    alert.setContentText("Your Application is updated!");
                    alert.showAndWait();

                    state = State.CLOSING;

                } else if (state == State.OPENING) {

                    new OpenUrl(downloadUrl);
                    state = State.CLOSING;

                }
            }
        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Ooops, there was an error!");

            alert.showAndWait();

        }
    }
}