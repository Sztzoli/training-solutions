package week05d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    @Test
    void testCreate(){
        Song song= new Song("zene",100,"John Doe");
        assertEquals("zene",song.getName());
        assertEquals(100,song.getLengthInSecond());
        assertEquals("John Doe",song.getArtist());

    }

    @Test
    void testException(){
        Exception songNull=assertThrows(IllegalArgumentException.class, ()->new Song(null,100,"John Doe"));
        assertEquals("Wrong name or artist", songNull.getMessage());

        Exception songBlank=assertThrows(IllegalArgumentException.class, ()->new Song("   ",100,"John Doe"));
        assertEquals("Wrong name or artist", songBlank.getMessage());

        Exception lengthInSecondNegative = assertThrows(IllegalArgumentException.class, ()-> new Song("zene",-1,"John Doe") );
        assertEquals("lengthInSecond is negative", lengthInSecondNegative.getMessage());

    }

}