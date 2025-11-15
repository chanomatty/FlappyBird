import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreManager {
    private static final String FILE_PATH = "scores.txt";

    public static void saveScore(double score) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(score + "\n");
        } catch (IOException e) {
            System.out.println("Error saving score: " + e.getMessage());
        }
    }

    public static ArrayList<Double> loadScores() {
        ArrayList<Double> scores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                scores.add(Double.parseDouble(line));
            }
        } catch (IOException e) {
            System.out.println("No previous score file found, starting fresh.");
        }
        return scores;
    }

    public static double getHighestScore() {
        ArrayList<Double> scores = loadScores();
        if (scores.isEmpty()) return 0;
        return Collections.max(scores);
    }
}