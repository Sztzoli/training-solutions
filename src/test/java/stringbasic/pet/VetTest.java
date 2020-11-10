package stringbasic.pet;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class VetTest {

    @Test
    public void add() {
        Vet vet=new Vet();
        Pet pet=new Pet("János", LocalDate.of(2020,9,10), Sex.HÍM , "012345");
        Pet pet2=new Pet("János", LocalDate.of(2020,9,10), Sex.HÍM , "012346");

        vet.add(pet);
        vet.add(pet2);

        assertEquals(2,vet.getPets().size());
    }

    @Test
    public void Same() {
        Vet vet=new Vet();
        Pet pet=new Pet("János", LocalDate.of(2020,9,10), Sex.HÍM , "012345");
        Pet pet2=new Pet("Ferenc", LocalDate.of(2020,9,10), Sex.HÍM , "012345");

        vet.add(pet);
        vet.add(pet2);

        assertEquals(1,vet.getPets().size());
    }


}