package texteditor.main;

import javafx.scene.control.MenuBar;

public class MenuBarCreator {

    private static MenuBar menuBar;
    static {

        menuBar = new MenuBar();

        menuBar.getMenus().addAll(texteditor.file.FileMenu.getMenu(),
                texteditor.edit.EditMenu.getEditMenu(),
                texteditor.preferences.PreferenceMenu.getPreferencesMenu(),
                texteditor.help.HelpMenu.getHelp());
    }

    public static MenuBar getMenuBar() {
        return menuBar;
    }
}
