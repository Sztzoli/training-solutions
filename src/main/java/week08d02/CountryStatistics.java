package week08d02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {

    public static final String SEPARATOR = " ";
    private List<Country> countries = new ArrayList<>();

    public List<Country> getCountries() {
        return List.copyOf(countries);
    }

    public void readFile() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        CountryStatistics.class.getResourceAsStream("/countries.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                addCounty(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("can not read file, ioe");
        }
    }

    private void addCounty (String line){
        String[] parts = line.split(SEPARATOR);
        String country = parts[0];
        int populations = Integer.parseInt(parts[1]);
        int numberOfColorInFlag = Integer.parseInt(parts[2]);
        int borderCountries = Integer.parseInt(parts[3]);
        countries.add(new Country(country, populations, numberOfColorInFlag, borderCountries));
    }


    public Country maxPopulation() {
        Country maxCountry = countries.get(0);
        for (int i = 1; i < countries.size() ; i++) {
            Country actualCountry = countries.get(i);
            if (maxCountry.getPopulation() < actualCountry.getPopulation()){
                maxCountry=actualCountry;
            }
        }
        return maxCountry;
    }
}
