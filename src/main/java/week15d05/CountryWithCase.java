package week15d05;

public class CountryWithCase extends Country {

    private int caseSum;

    public CountryWithCase(String name, int population, int caseSum) {
        super(name, population);
        this.caseSum = caseSum;
    }

    public int getCaseSum() {
        return caseSum;
    }
}
