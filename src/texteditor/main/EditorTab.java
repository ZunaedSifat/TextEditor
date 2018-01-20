package texteditor.main;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import texteditor.main.CodeEditor;
import texteditor.preferences.PreferenceData;

public class EditorTab extends CodeArea {

    private String path = null;

    public EditorTab(String path) {

        super();

        if (texteditor.preferences.PreferenceData.isLineNumberEnabled())
            setParagraphGraphicFactory(LineNumberFactory.get(this));
        if (texteditor.preferences.PreferenceData.isWordWrapEnabled())
            setWrapText(true);

        this.setStyle(PreferenceData.getFontStyle());

        this.path = path;
        this.addSyntaxHighlighting();
    }

    public EditorTab(String path, String text) {

        super(text);
        if (texteditor.preferences.PreferenceData.isLineNumberEnabled())
            setParagraphGraphicFactory(LineNumberFactory.get(this));
        if (texteditor.preferences.PreferenceData.isWordWrapEnabled())
            setWrapText(true);

        this.setStyle(PreferenceData.getFontStyle());

        this.path = path;
        this.addSyntaxHighlighting();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void addSyntaxHighlighting() {

        if (path == null) return;
        if (path.endsWith(".java")) {
            (new JavaKeywords()).start(this);
            this.replaceText(0, 0, this.getText());
        }

    }
}
