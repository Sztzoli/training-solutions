package stringbasic.pet;

import java.time.LocalDate;

public class Pet {

    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private String regNumber;

    public Pet(String name, LocalDate birthDate, Gender gender, String regNumber) {
        if (!new RegNumberValidator().validator(regNumber)){
            throw new IllegalArgumentException("Rossz a regNem: " +regNumber);
        }
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getSex() {
        return gender;
    }

    public String getRegNumber() {
        return regNumber;
    }


}
