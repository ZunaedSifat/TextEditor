package texteditor.help;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class HelpMenu {

    private static Menu help;
    private static String aboutUrl;
    private static String faqUrl;
    private static String githubRepoUrl;

    static {

        help = new Menu("_Help");
        aboutUrl = "http://rebornplusplus.wordpress.com/about";
        faqUrl = "http://rebornplusplus.wordpress.com/faq";
        githubRepoUrl = "http://github.com/ZunaedSifat/TextEditor";

        MenuItem about = new MenuItem("About");
        about.setOnAction(e -> new OpenUrl(aboutUrl));

        MenuItem githubRepo = new MenuItem("Github Repository");
        githubRepo.setOnAction(e -> new OpenUrl(githubRepoUrl));

        MenuItem faq = new MenuItem("FAQ");
        faq.setOnAction(e -> new OpenUrl(faqUrl));

        MenuItem checkForUpdates = new MenuItem("Check for Updates");
        checkForUpdates.setOnAction(e -> new CheckForUpdates());

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
