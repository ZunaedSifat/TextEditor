package texteditor.help;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class HelpMenu {

    private static Menu help;
    static {

        help = new Menu("_Help");

        MenuItem about = new MenuItem("About");

        MenuItem githubRepo = new MenuItem("Github Repository");
        githubRepo.setOnAction(e -> GitHubRepository.open());
        MenuItem faq = new MenuItem("FAQ");
        MenuItem checkForUpdates = new MenuItem("Check for updates");

        help.getItems().addAll(about, faq, new SeparatorMenuItem(),
                githubRepo, checkForUpdates);
    }

    public static Menu getHelp() {
        return help;
    }

    public static void setHelp(Menu help) {
        HelpMenu.help = help;
    }
}
