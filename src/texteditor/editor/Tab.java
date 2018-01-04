package texteditor.editor;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

public class Tab {

    private CodeArea codeArea = new CodeArea();
    private String path = null;
    private String filename = null;

    public Tab(String path, String filename) {

        if (texteditor.view.LineNumber.isLineNumberEnabled())
            codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        if (texteditor.view.WordWrap.isWordWrapEnabled())
            codeArea.setWrapText(true);

        if (path != null && filename != null) {

            this.path = path;
            this.filename = filename;
            this.addSyntaxHighlighting();
        }

    }

    public CodeArea getCodeArea() {
        return codeArea;
    }

    public void setCodeArea(CodeArea codeArea) {
        this.codeArea = codeArea;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void addSyntaxHighlighting() {

        if (filename == null) return;

        if (filename.toLowerCase().endsWith(".java"))
            ; // java highlighting
        // ....
        // ....
    }
}
