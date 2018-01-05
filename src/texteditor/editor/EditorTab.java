package texteditor.editor;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

public class EditorTab extends CodeArea {

    private String path = null;

    public EditorTab(String path) {

        super();

        if (texteditor.view.LineNumber.isLineNumberEnabled())
            setParagraphGraphicFactory(LineNumberFactory.get(this));
        if (texteditor.view.WordWrap.isWordWrapEnabled())
            setWrapText(true);

        this.path = path;
        this.addSyntaxHighlighting();
    }

    public EditorTab(String path, String text) {

        super(text);
        if (texteditor.view.LineNumber.isLineNumberEnabled())
            setParagraphGraphicFactory(LineNumberFactory.get(this));
        if (texteditor.view.WordWrap.isWordWrapEnabled())
            setWrapText(true);

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

    }
}
