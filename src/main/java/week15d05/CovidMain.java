package week15d05;

import collectionsmap.Entry;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class CovidMain {

    private List<Country> list;

    public void readFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            Map<String, Country> casePerCountry = new HashMap<>();
            reader.readLine();
            while ((line= reader.readLine())!=null) {
                String[] parts = line.split(",");
                String countryName = parts[4];
                int Population;
                try {
                    Population = Integer.parseInt(parts[7]);
                } catch (NumberFormatException numberFormatException) {
                    Population = 0;
                }

                int casePerWeek = Integer.parseInt(parts[2]);
               if (!casePerCountry.containsKey(countryName)) {
                   casePerCountry.put(countryName, new Country(countryName, Population, casePerWeek));
               }
               else {
                   casePerCountry.get(countryName).addCase(casePerWeek);
               }

            }
            list = new ArrayList<>(casePerCountry.values());

        } catch (IOException ioe) {
            throw new IllegalStateException("File cannot read");
        }

    }
    public List<Country> sortFirstThree() {
        List<Country> result = new ArrayList<>(list);
        result.sort(Comparator.comparingDouble(x -> ((double) x.getCaseNumber()/ x.getPopulation())));
        Collections.reverse(result);
        return result.subList(0,5);
    }
    public static void main(String[] args) {
        CovidMain covidMain = new CovidMain();
        covidMain.readFile(Path.of("src/main/java/week15d05/data.csv"));
        System.out.println(covidMain.list);
        System.out.println(covidMain.sortFirstThree());
    }
}
