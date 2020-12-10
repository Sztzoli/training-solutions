package week07d04;


import iowriter.names.NameWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListTest {





    @Test
    public void testCalculateSum() throws IOException {
        System.out.println(Path.of(".").toRealPath());
        ShoppingList shoppingList = new ShoppingList();
        long result = shoppingList.calculateSum("src/test/resources/week07d04/list.csv");


        assertEquals(2000, result);



    }



}