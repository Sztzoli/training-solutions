package week05d05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    private Playlist playlist;

    @BeforeEach
    void setUp(){
        List<Song> list = Arrays.asList(
                new Song("zene1",100,"John Doe"),
                new Song("zene2",80,"Jane Doe"));
                playlist=new Playlist(list);
    }

    @Test
    void testCreate(){


        assertEquals("[name: zene1;length: 100;artist: John Doe, name: zene2;length: 80;artist: Jane Doe]",playlist.toString());
    }

    @Test
    void testFindByGreaterThan(){
        assertEquals("[name: zene1;length: 100;artist: John Doe]",playlist.findByGreaterThan(90).toString());
        }

}