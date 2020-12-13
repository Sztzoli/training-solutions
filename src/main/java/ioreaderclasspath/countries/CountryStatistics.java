package ioreaderclasspath.countries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    public static final String SEPARATOR = " ";
    public static final int INDEX_OF_NAME = 0;
    public static final int INDEX_OF_BORDERCOUNTRIES = 1;
    private List<Country> countryList = new ArrayList<>();

    public List<Country> getCountryList() {
        return new ArrayList<>(countryList);
    }

    public void readFromFile(String pathString) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader
                (CountryStatistics.class.getResourceAsStream(pathString)))) {
            String lines;
            while ((lines = reader.readLine()) != null) {
                String[] parts = lines.split(SEPARATOR);
                String name = parts[INDEX_OF_NAME];
                int borderCountries = Integer.parseInt(parts[INDEX_OF_BORDERCOUNTRIES]);
                countryList.add(new Country(name,borderCountries));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read file", ioe);
        }

    }


    public int numberOFCountries() {
        return countryList.size();
    }

    public Country mostBorderCountries() {
        int max = countryList.get(0).getBorderCountries();
        int index=0;
        for (int i = 1; i < countryList.size(); i++) {
            int actualBorderCountries = countryList.get(i).getBorderCountries();
            if (max < actualBorderCountries){
                max=actualBorderCountries;
                index=i;
            }
        }
        return countryList.get(index);
    }
}
