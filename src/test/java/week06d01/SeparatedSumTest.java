package week06d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedSumTest {

    @Test
    void testCreate(){
        SeparatedSum separatedSum = new SeparatedSum();
        String s="4,5;-1.4;5";
        Result result=separatedSum.sum(s);
        assertEquals(9.5, result.getPositiveSum(),0.005);
        assertEquals(-1.4,result.getNegativeSum(),0.005);

    }

    @Test
    void ExceptionNull(){

        Exception ex= assertThrows(IllegalArgumentException.class, ()->new SeparatedSum().sum(null));
        assertEquals("String can't be null or blank",ex.getMessage());
    }

    @Test
    void ExceptionEmpty(){

        Exception ex= assertThrows(IllegalArgumentException.class, ()->new SeparatedSum().sum("    "));
        assertEquals("String can't be null or blank",ex.getMessage());
    }


}