package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;


public class CityDataMain {

    private List<CityData> cities;

    public CityDataMain(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filename)));
        this.cities = new CityReader().readFile(reader);
    }

    public CityData firstCityOrderByCityName() {
        cities.sort(Comparator.comparing(CityData::getCity, Collator.getInstance(new Locale("hu", "HU"))));
        return cities.get(0);
    }

    public CityData firstCityOrderByCityNameTreeSet() {
        if (cities.size()==0) {
            throw new IllegalArgumentException("list is empty");
        }
        cities.sort(Comparator.comparing(CityData::getCity, Collator.getInstance(new Locale("hu", "HU"))));
        return cities.get(0);
    }

    public List<CityData> getCities() {
        return new ArrayList<>(cities);
    }
}
