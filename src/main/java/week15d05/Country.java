package week15d05;

public class Country {

    private String name;
    private int population;
    private int caseNumber;

    public Country(String name, int population, int caseNumber) {
        this.name = name;
        this.population = population;
        this.caseNumber = caseNumber;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getCaseNumber() {
        return caseNumber;
    }

    public void addCase(int number) {
        caseNumber+=number;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", caseNumber=" + caseNumber +
                '}';
    }
}
