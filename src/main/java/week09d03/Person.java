package week09d03;

import java.util.Objects;
import java.util.Random;

public class Person {
    private String name;
    private int age;
    private Present present;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setPresent(Random rnd) {

        int presentIndex = rnd.nextInt(4);
        if (age>14){
            present=null;
        } else {
            present = Present.values()[presentIndex];
        }


    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Present getPresent() {
        return present;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
