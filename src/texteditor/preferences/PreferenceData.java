package texteditor.preferences;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class PreferenceData {

    private static boolean lineNumberEnabled = true;
    private static boolean wordWrapEnabled = true;
    private static boolean autoSaveEnabled = true;
    private static int autoSaveDelay = 5000;
    private static String fontFace = "Ubuntu Mono";
    private static int fontSize = 13;
    private static boolean boldFont = true;
    private static boolean italicFont = true;
    private static boolean programClosed = false;

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

    public static boolean isProgramClosed() {
        return programClosed;
    }

    public static void setProgramClosed(boolean programClosed) {
        PreferenceData.programClosed = programClosed;
    }

    public static String getFontStyle() {
        return String.format("-fx-font-family: %s; -fx-font-size: %spx;%s%s", fontFace, fontSize,
                (PreferenceData.isBoldFont() ? " -fx-font-weight: bold; " : ""),
                (PreferenceData.isItalicFont() ? " -fx-font-style: italic; " : ""));
    }

    public static void readData() {
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
            System.out.println("AutoSaveEnabled : " + autoSaveEnabled);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeData() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/user.csv"))) {
            writer.write("lineNumber:" + isLineNumberEnabled() + "\n");
            writer.write("wordWrap:" + isWordWrapEnabled() + "\n");
            writer.write("autoSave:" + isAutoSaveEnabled() + "\n");
            writer.write("autoSaveDelay:" + getAutoSaveDelay() + "\n");
            writer.write("fontFace:" + getFontFace() + "\n");
            writer.write("fontSize:" + getFontSize() + "\n");
            writer.write("boldFont:" + isBoldFont() + "\n");
            writer.write("italicFont:" + isItalicFont() + "\n");

            System.out.println("wrote data/user.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
