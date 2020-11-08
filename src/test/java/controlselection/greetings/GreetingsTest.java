package controlselection.greetings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingsTest {

    @Test
    void greeting() {
        assertEquals("Jó éjt!",new Greetings().greeting(4,0));
        assertEquals("Jó reggelt!",new Greetings().greeting(6,0));
        assertEquals("Jó napot!",new Greetings().greeting(10,0));
        assertEquals("Jó estét!",new Greetings().greeting(19,0));
        assertEquals("Jó éjt!",new Greetings().greeting(22,0));
    }
}