package controladvanced.duplicates;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DuplicatesTest {

    @Test
    public void TestFindDuplicates() {
        Duplicates duplicates = new Duplicates();
        List<Integer> list=Arrays.asList(1,2,3,2,3,2);

        assertEquals(Arrays.asList(2,3),duplicates.findDuplicates(list));

    }
    @Test
    public void TestPlaceOfDuplicate(){
        Duplicates duplicates = new Duplicates();
        List<Integer> list=Arrays.asList(1,2,3,2,3,2);

        assertEquals(1,list.indexOf(2));
        assertNotEquals(3,list.indexOf(2));
        assertNotEquals(5,list.indexOf(2));
    }
}