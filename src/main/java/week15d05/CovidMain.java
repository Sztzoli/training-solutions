package week15d05;

import collectionsmap.Entry;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CovidMain {

    private List<CountryWithCase> list = new ArrayList<>();

    public void readFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            Map<Country, Integer> casePerCountry = new HashMap<>();
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
                casePerCountry.merge(new Country(countryName,Population), 0, Integer::sum);
            }
            for (Map.Entry<Country, Integer> cases : casePerCountry.entrySet()) {
                list.add(new CountryWithCase(cases.getKey().getName(),cases.getKey().getPopulation(), cases.getValue()));
            }

        } catch (IOException ioe) {
            throw new IllegalStateException("File cannot read");
        }

    }
    public List<CountryWithCase> sortFirstThree() {
        List<CountryWithCase> result = new ArrayList<>(list);
        result.sort(Comparator.comparingDouble(x -> (double) x.getCaseSum()/ x.getPopulation()));
        return result.subList(0,3);
    }
    public static void main(String[] args) {
        CovidMain covidMain = new CovidMain();
        covidMain.readFile(Path.of("src/main/java/week15d05/data.csv"));
        System.out.println(covidMain.list);
        System.out.println(covidMain.sortFirstThree());
    }
}
