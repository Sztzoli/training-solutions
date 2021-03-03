package covid;

public class Riport {
    private String zip;
    private int zeroVaccination;
    private int oneVaccination;
    private int twoVaccination;

    public Riport(String zip, int zeroVaccination, int oneVaccination, int twoVaccination) {
        this.zip = zip;
        this.zeroVaccination = zeroVaccination;
        this.oneVaccination = oneVaccination;
        this.twoVaccination = twoVaccination;
    }

    public String getZip() {
        return zip;
    }

    public int getZeroVaccination() {
        return zeroVaccination;
    }

    public int getOneVaccination() {
        return oneVaccination;
    }

    public int getTwoVaccination() {
        return twoVaccination;
    }

    @Override
    public String toString() {
        return "Riport{" +
                "zip='" + zip + '\'' +
                ", zeroVaccination=" + zeroVaccination +
                ", oneVaccination=" + oneVaccination +
                ", twoVaccination=" + twoVaccination +
                '}';
    }
}
