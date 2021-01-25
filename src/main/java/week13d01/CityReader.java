package week13d01;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityReader {

    public static final String REGEX = ";";

    public List<CityData> readFile(BufferedReader reader) {
        List<CityData> cities = new ArrayList<>();
        try (reader) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                cities.add(CityData.createCityByLine(line));
            }
            return cities;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }

    }

}
