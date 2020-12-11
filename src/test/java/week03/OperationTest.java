package week03;


import org.junit.jupiter.api.Test;
import week03d05.Operation;

import static org.junit.jupiter.api.Assertions.*;

public class OperationTest {

    @Test
    public void TestCreate() {
        Operation operation = new Operation("123+45");

        assertEquals(123+45,operation.getResult());
    }


}