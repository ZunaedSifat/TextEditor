package texteditor.main;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import texteditor.main.CodeEditor;
import texteditor.preferences.PreferenceData;


public class EditorTab extends CodeArea {

    private String path = null;

    public EditorTab(String path) {

        this.setBasicStyle();
        this.path = path;
        this.addSyntaxHighlighting();

        System.out.println("Created editor tab at path: " + path);
    }

    public EditorTab(String path, String text) {

        super(text);
        this.setBasicStyle();
        this.path = path;
        this.addSyntaxHighlighting();

        System.out.println("Creadted editor tab at path: " + path);
    }

    private void setBasicStyle() {
        if (texteditor.preferences.PreferenceData.isLineNumberEnabled())
            setParagraphGraphicFactory(LineNumberFactory.get(this));
        if (texteditor.preferences.PreferenceData.isWordWrapEnabled())
            setWrapText(true);
        this.setStyle(PreferenceData.getFontStyle());
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void addSyntaxHighlighting() {

        if (path == null) return;
        if (path.length() < 5) return;

        String extension = path.substring(path.length()-5, path.length());
        if (extension.equalsIgnoreCase(".java")) {
            (new JavaKeywords()).start(this);
        }
    }
}
