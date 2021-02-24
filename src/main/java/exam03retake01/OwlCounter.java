package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    private Map<String, Integer> owlsMap = new HashMap<>();

    public void readFromFile(BufferedReader reader) {
        try (reader){
            String line;
            while ((line= reader.readLine())!=null) {
                String[] parts = line.split("=");
                owlsMap.put(parts[0], Integer.valueOf(parts[1]) );
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Cannot read file", ioException);
        }
    }

    public int getNumberOfOwls(String county) {
        return owlsMap.get(county);
    }
}
