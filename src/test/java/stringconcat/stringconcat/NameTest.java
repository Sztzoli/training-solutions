package stringconcat.stringconcat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NameTest {

    @Test
    public void testConcatNameWesternStyle() {
        Name name= new Name("Kovács","Ferenc","János",Title.DR);
        System.out.println(name.concatNameWesternStyle());
    }

    @Test
    public void concatNameHungarianStyle() {
        Name name= new Name("Kovács","Ferenc","János",Title.DR);
        System.out.println(name.concatNameHungarianStyle());
    }
}