package week14d05;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class WordCounter {


    public static final String NAME_OF_THE_DOG = "Hach";

    public long counter() {
        Path file = Path.of("src/main/resources/week14d05/hachiko.srt");
        long result;
        try (Stream<String> s = Files.lines(file)) {
            result = s
                    .filter(WordCounter::containsTheName)
                    .flatMap(WordCounter::lineToWords)
                    .filter(WordCounter::containsTheName)
//                    .peek(System.out::println)
                    .count();
        } catch (IOException ioe) {
            throw new IllegalStateException("File cannot read");
        }
        return result;

    }

    private static Stream<? extends String> lineToWords(String value) {
        return Arrays.stream(value.split(" ").clone());
    }

    private static boolean containsTheName(String x) {
        return x.contains(NAME_OF_THE_DOG);
    }


    public static void main(String[] args) {
        System.out.println(new WordCounter().counter());
    }
}
