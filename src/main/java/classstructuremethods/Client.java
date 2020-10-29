package classstructuremethods;

public class Client {
    private String name;
    private int yeorOfBirth;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYeorOfBirth() {
        return yeorOfBirth;
    }

    public void setYeorOfBirth(int yeorOfBirth) {
        this.yeorOfBirth = yeorOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void migrate(String newAddress) {
        address=newAddress;
    }
}
