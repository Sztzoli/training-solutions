package week06d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparatedSumTest {

    @Test
    void testCreate(){
        SeparatedSum separatedSum = new SeparatedSum();
        String s="4,5;-1.4;5";
        Result result=separatedSum.sum(s);
        System.out.println(result.getPositiveSum());
        System.out.println(result.getNegativeSum());
    }

}