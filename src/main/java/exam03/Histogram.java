package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {


    public String createHistogram(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try (reader) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(lineConvert(line));
                sb.append("\n");
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File can not read", ioe);
        }
        return sb.toString();
    }

    private String lineConvert(String line) {
        int number = Integer.parseInt(line);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}
