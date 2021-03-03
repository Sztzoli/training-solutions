package covid;

import java.time.LocalDateTime;

public class Citizen {
    private Long id;
    private final String name;
    private final String zip;
    private final int age;
    private final String email;
    private final String taj;
    private int numberOfVaccination = 0;
    private LocalDateTime lastVaccinationDate;

    public Citizen(String name, String zip, int age, String email, String taj) {
        checkAllParams(name, zip, age, email, taj);
        this.name = name;
        this.zip = zip;
        this.age = age;
        this.email = email;
        this.taj = taj;
    }


    public Citizen(Long id, String name, String zip, int age, String email, String taj) {
        this(name, zip, age, email, taj);
        this.id = id;
    }

    public Citizen(Long id, String name, String zip, int age, String email, String taj, int numberOfVaccination, LocalDateTime lastVaccinationDate) {
        this(id, name, zip, age, email, taj);
        this.numberOfVaccination = numberOfVaccination;
        this.lastVaccinationDate = lastVaccinationDate;
    }

    public String getName() {
        return name;
    }

    public String getZip() {
        return zip;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getTaj() {
        return taj;
    }

    public Long getId() {
        return id;
    }

    public int getNumberOfVaccination() {
        return numberOfVaccination;
    }

    public LocalDateTime getLastVaccinationDate() {
        return lastVaccinationDate;
    }

    public void addVaccination() {
        if (numberOfVaccination == 2) {
            throw new IllegalStateException("Citizen have already two vaccination");
        }
        numberOfVaccination++;
    }

    public void setLastVaccinationDate(LocalDateTime lastVaccinationDate) {
        this.lastVaccinationDate = lastVaccinationDate;
    }

    private void checkAllParams(String name, String zip, int age, String email, String taj) {
        CitizenDataCheck dataCheck = new CitizenDataCheck();
        if (!dataCheck.checkName(name)) {
            throw new IllegalArgumentException("Name can not be empty");
        }
        if (!dataCheck.checkZip(zip)) {
            throw new IllegalArgumentException("Invalid zip code");
        }
        if (!dataCheck.checkAge(age)) {
            throw new IllegalArgumentException("Invalid age: " + age + ", age is between 1 and 150");
        }
        if (!dataCheck.checkEmail(email)) {
            throw new IllegalArgumentException("Invalid email: " + email);
        }
        if (!dataCheck.checkTaj(taj)) {
            throw new IllegalArgumentException("Invalid TAJ: " + taj);
        }
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", zip='" + zip + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", taj='" + taj + '\'' +
                '}';
    }
}
