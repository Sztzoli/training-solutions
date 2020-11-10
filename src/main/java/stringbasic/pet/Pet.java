package stringbasic.pet;

import java.time.LocalDate;

public class Pet {

    private String name;
    private LocalDate birthDate;
    private Sex sex;
    private String regNumber;

    public Pet(String name, LocalDate birthDate, Sex sex, String regNumber) {
        if (!new RegNumberValidator().validator(regNumber)){
            throw new IllegalArgumentException("Rossz a regNem: " +regNumber);
        }
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
        this.regNumber = regNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public String getRegNumber() {
        return regNumber;
    }


}
