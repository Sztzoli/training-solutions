package stringconcat.employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {


   @Test
   public void testCreate() {
       Employee employee=new Employee("János","Chef",100_000);

       assertEquals("János", employee.getName());
       assertEquals("Chef", employee.getPosition());
       assertEquals(100_000, employee.getSalary());
   }


    @Test
    public void testToString() {
        Employee employee=new Employee("János","Chef",100_000);

        assertEquals("János - Chef - 100000",employee.toString());
    }



    @Test
    void testGetWrongSalary() {

        assertThrows(IllegalArgumentException.class,()->new Employee("János","Chef",100_001));
        assertThrows(IllegalArgumentException.class, () -> new Employee("János", "Chef", -1));
    }


}