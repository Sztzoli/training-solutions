package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LottoReader {

    private int[] numbers = new int[90];

    public LottoReader(InputStream inputStream) {
       try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
           String line;
           while ((line= reader.readLine()) != null) {
               String[] parts = line.split(";");
               for (int i = 11; i < parts.length; i++) {
                   int actualNumber = Integer.parseInt(parts[i])-1;
                   numbers[actualNumber]++;
               }

           }
       } catch (IOException ioe) {
           throw new IllegalStateException("Cannot read file",ioe);
       }
    }

    public int getNumber(int number) {
        return numbers[number-1];
    }
}
