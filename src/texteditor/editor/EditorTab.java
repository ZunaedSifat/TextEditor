package texteditor.editor;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

public class EditorTab {

    private CodeArea codeArea;
    private String path = null;
    private String filename = null;
    private String tabname;

    public EditorTab(String path, String filename) {

        codeArea = new CodeArea();

        if (texteditor.view.LineNumber.isLineNumberEnabled())
            codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        if (texteditor.view.WordWrap.isWordWrapEnabled())
            codeArea.setWrapText(true);

        if (path != null && filename != null) {

            this.path = path;
            this.filename = filename;
            this.addSyntaxHighlighting();
            this.tabname = filename;
        } else {
            this.tabname = "Untitled";
        }
    }

    public EditorTab(String path, String filename, String text) {

        codeArea = new CodeArea(text);

        if (texteditor.view.LineNumber.isLineNumberEnabled())
            codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        if (texteditor.view.WordWrap.isWordWrapEnabled())
            codeArea.setWrapText(true);

        if (path != null && filename != null) {

            this.path = path;
            this.filename = filename;
            this.addSyntaxHighlighting();
            this.tabname = filename;
        } else {
            this.tabname = "Untitled";
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

    public String getTabname() {
        return tabname;
    }

    public void setTabname(String tabname) {
        this.tabname = tabname;
    }
}
