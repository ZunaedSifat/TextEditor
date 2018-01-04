package texteditor.view;

import javafx.scene.control.*;

public class ViewMenu {

    private static Menu viewMenu  = new Menu("View");
    static {

        CheckMenuItem showFileExplorer = new CheckMenuItem("Show File Explorer");
        showFileExplorer.setOnAction(e -> {

        });

        CheckMenuItem wordWrap = new CheckMenuItem("Word Wrap");
        wordWrap.setOnAction(e -> {

            if (wordWrap.isSelected()) {

            } else {

            }
        });

        CheckMenuItem showLineNumber = new CheckMenuItem("Show Line Number");
        showLineNumber.setOnAction(e -> {

            if (showLineNumber.isSelected()) {

            } else {

            }
        });

        MenuItem font = new MenuItem("Font");
        font.setOnAction(e -> {

        });

        ToggleGroup theme = new ToggleGroup();

        RadioMenuItem darkTheme = new RadioMenuItem("Dark Theme");
        darkTheme.setOnAction(e -> {

        });

        RadioMenuItem lightTheme = new RadioMenuItem("Light Theme");
        lightTheme.setOnAction(e -> {

        });

        darkTheme.setToggleGroup(theme);
        lightTheme.setToggleGroup(theme);

        //todo: read file and set the thing that needs to be checked

        viewMenu.getItems().addAll(showFileExplorer, new SeparatorMenuItem(),
                wordWrap, showLineNumber, new SeparatorMenuItem(),
                font, new SeparatorMenuItem(),
                lightTheme, darkTheme);
    }

    public static Menu getViewMenu() {
        return viewMenu;
    }

    public static void setViewMenu(Menu viewMenu) {
        ViewMenu.viewMenu = viewMenu;
    }
}
