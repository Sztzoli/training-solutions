package introjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GentlemanTest {

    @Test
    public void sayHello() {
        assertEquals("Hello Anonymous",new Gentleman().SayHello(null));
    }
}