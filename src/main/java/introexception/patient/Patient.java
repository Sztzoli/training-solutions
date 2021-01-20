package introexception.patient;

public class Patient {
    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        if (name==null || name.isEmpty()){
            throw new  IllegalArgumentException("üres a név");
        }
        if (yearOfBirth<1900){
            throw new IllegalArgumentException("hibás születési év");
        }
        if (!new SsnValidator().isValidSsn(socialSecurityNumber)){
            throw new IllegalArgumentException("rossz TAJ szám: " +socialSecurityNumber);
        }
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
