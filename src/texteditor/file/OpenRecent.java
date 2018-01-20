package texteditor.file;

import javafx.scene.control.MenuItem;

import java.io.*;

public class OpenRecent {

    private static String[] recentFiles = new String[5];
    private static String dataFile = "data/recent.txt";

    public static void add(String fileName) {

        System.out.println("add called with: " + fileName);

        for (String str : recentFiles)
            if (fileName.equals(str)) return;

        for(int i=0; i<4; ++i) {

            String filename = recentFiles[i];
            recentFiles[i+1] = fileName;
        }
        recentFiles[0] = fileName;

        MenuItem menuItem = new MenuItem(fileName);
        menuItem.setOnAction(e -> OpenFile.openFile(new File(fileName)));
        FileMenu.openRecent.getItems().add(menuItem);
    }

    public static void readData() {

        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {

            for (int i = 0; i < 5; i++) {

                String filename = reader.readLine();
                if (filename == null) return;
                recentFiles[i] = filename;
                MenuItem menuItem = new MenuItem(filename);
                menuItem.setOnAction(e -> OpenFile.openFile(new File(filename)));
                FileMenu.openRecent.getItems().add(menuItem);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeData() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile))) {

            for (String filename : recentFiles) {
                if (filename == null) return;
                writer.write(filename + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
