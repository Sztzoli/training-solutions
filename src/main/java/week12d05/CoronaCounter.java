package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CoronaCounter {

    private List<String> lines;

    public CoronaCounter() {
        this.lines = readFile();
    }

    private List<String> readFile() {
        List<String> result = new ArrayList<>();
        Path file = Path.of("src/main/java/week12d05/index.html");
        try (BufferedReader reader = Files.newBufferedReader(file)){
            String line;
            while ((line= reader.readLine()) != null){
                result.add(line.trim());
            }
            return result;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File can not read", ioe);
        }
    }

    public long countWordPerLine(String word) {
        return lines.stream()
                .map(String::toLowerCase)
                .filter(value -> value.contains(word.toLowerCase()))
                .count();
    }

    public static void main(String[] args) {
        CoronaCounter counter = new CoronaCounter();
        System.out.println(counter.countWordPerLine("koronavírus"));
        System.out.println(counter.countWordPerLine("trump"));
    }
}
