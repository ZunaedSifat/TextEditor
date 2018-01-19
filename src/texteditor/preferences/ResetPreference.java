package texteditor.preferences;

public class ResetPreference {

    public static void resetPreference() {
        //todo: data/default.csv to data/user.csv
        PreferenceData.readData();
    }
}
