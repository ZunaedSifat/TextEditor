package texteditor.preferences;

import java.io.BufferedReader;
import java.io.FileReader;

public class PreferenceData {

    private static boolean lineNumberEnabled = true;
    private static boolean wordWrapEnabled = true;
    private static boolean autoSaveEnabled = true;
    private static int autoSaveDelay = 5000;
    private static String fontFace = "Ubuntu Mono";
    private static int fontSize = 13;
    private static boolean boldFont = true;
    private static boolean italicFont = true;
    static {
        AutoSave.getObject().run();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/user.csv"))) {
            while (true) {

                String line = reader.readLine();
                if (line == null) break;

                if (line.startsWith("lineNumber") && line.endsWith("false"))
                    lineNumberEnabled = false;
                else if (line.startsWith("wordWrap") && line.endsWith("false"))
                    wordWrapEnabled = false;
                else if (line.startsWith("autoSave") && line.endsWith("false"))
                    autoSaveEnabled = false;
                else if (line.startsWith("autoSaveDelay")) {
                    try {
                        String delay = line.split(":")[line.split(":").length - 1];
                        autoSaveDelay = Integer.parseInt(delay);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if (line.startsWith("fontFace")) {
                    try {
                        String face = line.split(":")[line.split(":").length - 1];
                        fontFace = face;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if (line.startsWith("fontSize")) {
                    try {
                        String size = line.split(":")[line.split(":").length - 1];
                        fontSize = Integer.parseInt(size);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isLineNumberEnabled() {
        return lineNumberEnabled;
    }

    public static void setLineNumberEnabled(boolean lineNumberEnabled) {
        PreferenceData.lineNumberEnabled = lineNumberEnabled;
    }

    public static boolean isWordWrapEnabled() {
        return wordWrapEnabled;
    }

    public static void setWordWrapEnabled(boolean wordWrapEnabled) {
        PreferenceData.wordWrapEnabled = wordWrapEnabled;
    }

    public static boolean isAutoSaveEnabled() {
        return autoSaveEnabled;
    }

    public static void setAutoSaveEnabled(boolean autoSaveEnabled) {
        PreferenceData.autoSaveEnabled = autoSaveEnabled;
    }

    public static int getAutoSaveDelay() {
        return autoSaveDelay;
    }

    public static void setAutoSaveDelay(int autoSaveDelay) {
        PreferenceData.autoSaveDelay = autoSaveDelay;
    }

    public static String getFontFace() {
        return fontFace;
    }

    public static void setFontFace(String fontFace) {
        PreferenceData.fontFace = fontFace;
    }

    public static int getFontSize() {
        return fontSize;
    }

    public static void setFontSize(int fontSize) {
        PreferenceData.fontSize = fontSize;
    }

    public static boolean isBoldFont() {
        return boldFont;
    }

    public static void setBoldFont(boolean boldFont) {
        PreferenceData.boldFont = boldFont;
    }

    public static boolean isItalicFont() {
        return italicFont;
    }

    public static void setItalicFont(boolean italicFont) {
        PreferenceData.italicFont = italicFont;
    }

    public static String getFontStyle() {
        return String.format("-fx-font-family: %s; -fx-font-size: %spx;%s%s", fontFace, fontSize,
                (PreferenceData.isBoldFont() ? " -fx-font-weight: bold; " : ""),
                (PreferenceData.isItalicFont() ? " -fx-font-style: italic; " : ""));
    }

    //todo: write data on close
    public static void writeData() {

    }
}
