package software;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class OfficeSoftwareTest {


    @Test
    void test(){
        Software software = new OfficeSoftware("name",100);
        software.increasePrice();
        assertEquals(105,software.getPrice(), 0.0001);
    }

}