package exam03retake02;

import exceptionclass.course.SimpleTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class BalatonStorm {

    public List<String> getStationsInStorm(BufferedReader reader) {
        List<String> result = new ArrayList<>();
        try (reader) {
            reader.readLine();
            String line;
            String station = null;
            while ((line = reader.readLine()) != null) {

                if (line.contains("allomas")) {
                    station = line.substring(line.indexOf(':')+3,line.lastIndexOf('"'));
                }
                if (line.contains("level")) {
                    String levelString = line.substring(line.indexOf(':')+2,line.lastIndexOf(','));
                    int level = Integer.parseInt(levelString);
                    if (level>=3 && station!=null) {
                        result.add(station);
                    }

                }

            }
            Collections.sort(result, Collator.getInstance(new Locale("hu", "HU")));
            return result;
        } catch (IOException ioe) {
            throw new IllegalStateException("File cannot read", ioe);
        }


    }
}
