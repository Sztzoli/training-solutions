package ioreadstring.names;

public class Human {

    private String firstName;
    private String lastName;

    public Human(String firstName, String familyName) {
        this.firstName = firstName;
        this.lastName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
