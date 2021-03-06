package week08d02;

import java.util.Objects;

public class Country {

    private final String name;
    private final int population;
    private final int numberOfColorInFlag;
    private final int borderCountries;

    public Country(String name, int population, int numberOfColorInFlag, int borderCountries) {
        this.name = name;
        this.population = population;
        this.numberOfColorInFlag = numberOfColorInFlag;
        this.borderCountries = borderCountries;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getNumberOfColorInFlag() {
        return numberOfColorInFlag;
    }

    public int getBorderCountries() {
        return borderCountries;
    }

    @Override
    public String toString() {
        return String.format("%s populations: %s number of color in flag: %d border countries: %d",
                name, population, numberOfColorInFlag, borderCountries);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return population == country.population && numberOfColorInFlag == country.numberOfColorInFlag && borderCountries == country.borderCountries && Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population, numberOfColorInFlag, borderCountries);
    }
}
