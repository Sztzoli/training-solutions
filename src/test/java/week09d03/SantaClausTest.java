package week09d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SantaClausTest {

    private SantaClaus santaClaus;

    @BeforeEach
    void init() {
        List<Person> persons = List.of(
                new Person("Zé",13),
                new Person("Jé",15),
                new Person("Té",10));
        santaClaus = new SantaClaus(persons);
    }

    @Test


    void createTest(){
        assertEquals(3,santaClaus.getPersons().size());
        assertEquals(new Person("Zé",13),santaClaus.getPersons().get(0));
    }



}