package texteditor.main;

import texteditor.editor.Tab;

import java.util.ArrayList;

public class Commons {

    private static Tab currentTab = new Tab(null, null);
    private static ArrayList <Tab> tabs = new ArrayList<>();

    static {
        tabs.add(currentTab);
    }

    public static Tab getCurrentTab() {
        return currentTab;
    }

    public static void setCurrentTab(Tab currentTab) {
        Commons.currentTab = currentTab;
        //todo: make change in the editor
    }

    public static void addTab(String path, String filename) {

        for (Tab item : tabs) {
            if (item.getFilename().equals(filename) && item.getPath().equals(path)) {
                setCurrentTab(item);
                return;
            }
        }

        Tab tab = new Tab(path, filename);
        tabs.add(tab);
        setCurrentTab(tab);
    }
}
