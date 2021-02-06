package dateduration;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class StringCreationStudies {

    static final int leftLimit = 97; // letter 'a'
    static final int rightLimit = 122; // letter 'z'
    static final int targetStringLength = 10;
    private Random random = new Random();

    public long measureStringCreationTimeRequiredOnHeap(int objectsCount){
        LocalDateTime start = LocalDateTime.now();
             String[] str = new String[objectsCount];
        for (int i = 0; i < str.length; i++) {
            str[i] = new String(generatedString());
        }
        LocalDateTime over = LocalDateTime.now();

        return Duration.between(start, over).toMillis();
    }


    public long measureStringCreationTimeRequiredInPool(int objectsCount) {
        LocalDateTime start = LocalDateTime.now();
        String[] str = new String[objectsCount];
        for (int i = 0; i < str.length; i++) {
            str[i] = generatedString();
        }
        LocalDateTime over = LocalDateTime.now();

        return Duration.between(start, over).toMillis();
    }

    private String generatedString() {
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        StringCreationStudies studies = new StringCreationStudies();
        System.out.println(studies.measureStringCreationTimeRequiredOnHeap(100000));
        System.out.println(studies.measureStringCreationTimeRequiredInPool(100000));
    }
}
