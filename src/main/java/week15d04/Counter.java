package week15d04;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Counter {


    public Map<String, Long> count(Path path) {
        try  (Stream<String> s = Files.lines(path)) {
            return s.map(String::toLowerCase)
                    .flatMapToInt(String::chars)
                    .filter(i -> i!=(int) ' ')
                    .mapToObj(CharType::getType)
                    .collect(Collectors.groupingBy(CharType::getChars, Collectors.counting()));


        }catch (IOException ioe) {
            throw new IllegalStateException("File cannot read", ioe);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Counter().count(Path.of("src/main/java/week15d04/test.txt")));
    }

}


//    Senior feladat:
//        Számoljuk össze, hogy egy fájlban hány mássalhangzó, hány magánhangzó és hány egyéb karakter van. A space-eket ne vegyük figyelembe! A kis- és nagybetű különbség nem számít!
//        Remélem a juniorok is meg tudják oldani, azonban a senoiroknak streammel kell. Bonyi!!!
