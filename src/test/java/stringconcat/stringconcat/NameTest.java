package stringconcat.stringconcat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NameTest {

    @Test
    public void ConcatStyleTest() {
        Name name= new Name("Kovács","Ferenc","János",Title.DR);
        Name nameWithoutTitle=new Name("Kovács","Ferenc","János");
        Name middleNameIsNull=new Name("Kovács",null,"János",Title.DR);
        Name middleNameIsEmpty = new Name("Kovács","","János",Title.DR);
        //Western
        assertEquals("Dr.János Ferenc Kovács",name.concatNameWesternStyle());
        assertEquals("János Ferenc Kovács",nameWithoutTitle.concatNameWesternStyle());
        assertEquals("Dr.János Kovács",middleNameIsNull.concatNameWesternStyle());
        assertEquals("Dr.János Kovács",middleNameIsNull.concatNameWesternStyle());

        //Hungarian
        assertEquals("Dr.Kovács János Ferenc",name.concatNameHungarianStyle());
        assertEquals("Dr.Kovács János",middleNameIsNull.concatNameHungarianStyle());
        assertEquals("Dr.Kovács János",middleNameIsNull.concatNameHungarianStyle());
    }

    @Test
    public void illegalArgumentExceptionTest() {
        // Family name
            //null
        Exception exFamilyName = assertThrows(IllegalArgumentException.class , ()->new Name(null,"Ferenc","János",Title.DR));
        assertEquals("üres a név",exFamilyName.getMessage());
            //empty
        Exception exFamilyNameEmpty = assertThrows(IllegalArgumentException.class , ()->new Name("","Ferenc","János",Title.DR));
        assertEquals("üres a név",exFamilyNameEmpty.getMessage());
        //Given Name
            //null
        Exception exGivenName = assertThrows(IllegalArgumentException.class , ()->new Name("János","Ferenc",null,Title.DR));
        assertEquals("üres a név",exGivenName.getMessage());
            //empty
        Exception exGivenNameEmpty = assertThrows(IllegalArgumentException.class , ()->new Name("János","Ferenc","",Title.DR));
        assertEquals("üres a név",exGivenNameEmpty.getMessage());
    }
}