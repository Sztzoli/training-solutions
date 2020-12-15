package week08d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryStatisticsTest {




    @Test
    void testGetList() {
        CountryStatistics countryStatistics = new CountryStatistics();
        countryStatistics.readFile();
        assertEquals(11,countryStatistics.getCountries().size());
        assertEquals(new Country("Csad",13,3,6),countryStatistics.getCountries().get(1));

    }

    @Test
    void testMaxPopulation() {
        CountryStatistics countryStatistics = new CountryStatistics();
        countryStatistics.readFile();
        assertEquals(countryStatistics.getCountries().get(2), countryStatistics.maxPopulation());

    }

}