package fileutils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class TxtUtils {
    private static final String FILEPATH = "src/main/resources/";
    private static final String FILEEXTENSION = ".txt";

    public static void writeResults(String filename, Map<String, Double> results) {
        try (FileWriter fileWriter = new FileWriter(FILEPATH + filename + FILEEXTENSION);
                BufferedWriter bw = new BufferedWriter(fileWriter)) {
            bw.write("Name                , Score");
            bw.write(System.getProperty("line.separator"));
            for (String key : results.keySet()) {
                bw.write(createLine(key, results.get(key)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String createLine(String name, double score) {
        StringBuilder sb = new StringBuilder(name);
        for (int i = 0; i < 20 - name.length(); i++)
            sb.append(" ");

        sb.append(", ");
        sb.append(score);
        sb.append(System.getProperty("line.separator"));

        return sb.toString();
    }
}
