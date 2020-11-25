package week05d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    @Test
    void testStringCaseNull(){
        List<User> list= Arrays.asList(new User("Zé",12),new User(null,12));

        Exception ex=assertThrows(IllegalArgumentException.class, ()->new UserValidator().validate(list));
        assertEquals("Invalid argument:null",ex.getMessage());
    }

    @Test
    void testStringCaseEmpty(){
        List<User> list= Arrays.asList(new User("Zé",12),new User("",12));

        Exception ex=assertThrows(IllegalArgumentException.class, ()->new UserValidator().validate(list));
        assertEquals("Invalid argument:",ex.getMessage());
    }
    @Test
    void testIntCaseNegativ(){
        List<User> list= Arrays.asList(new User("Zé",12),new User("Jé",-1));

        Exception ex=assertThrows(IllegalArgumentException.class, ()->new UserValidator().validate(list));
        assertEquals("Invalid argument:-1",ex.getMessage());
    }
    @Test
    void testIntCaseBigger(){
        List<User> list= Arrays.asList(new User("Zé",12),new User("Jé",121));

        Exception ex=assertThrows(IllegalArgumentException.class, ()->new UserValidator().validate(list));
        assertEquals("Invalid argument:121",ex.getMessage());
    }

}