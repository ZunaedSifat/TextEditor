package texteditor.edit;

import texteditor.editor.Tab;

public class Copy implements Runnable {

    public Copy() {
    }

    @Override
    public void run() {

        Tab tab = new Tab(null, null);
        tab.getCodeArea().copy();
    }
}
