package week10d05;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2 ,3);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream old = System.out;
        PrintStream newPS = new PrintStream(stream);
        System.setOut(newPS);
        System.out.println("x");


        System.setOut(old);

        System.out.println(Arrays.toString(stream.toByteArray()));

    }


}