package week10d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Travel {

    public static final String REGEX = " ";
    public static final int INDEX_OF_STOP = 0;

    public String getStopWithMax(InputStream inputStream) {
        Map<String, Integer> stopList = new TreeMap<>(read(inputStream));

        return stopList.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get().getKey();

    }

    private Map<String, Integer> read(InputStream inputStream) {
        Map<String, Integer> stopsList = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(REGEX);
                String stop = parts[INDEX_OF_STOP];
                if (stopsList.containsKey(stop)) {
                    stopsList.put(stop, stopsList.get(stop) + 1);
                } else {
                    stopsList.put(stop, 1);
                }
            }
            return stopsList;
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }

    }

}
