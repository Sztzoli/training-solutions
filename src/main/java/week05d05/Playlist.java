package week05d05;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> songs = new ArrayList<>();

    public Playlist(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> getSongs() {
        return List.copyOf(songs);
    }

    public List<Song> findByGreaterThan (int min) {
        if (min<0){
            throw new IllegalArgumentException("min is negative");
        }
        List<Song> newSongs = new ArrayList<>();
        for (Song song: songs ) {
            if (song==null){
                throw new IllegalArgumentException("song is null");
            }
            if (song.getLengthInSecond() > min){
                newSongs.add(song);
            }
        }
        return newSongs;
    }

    @Override
    public String toString() {
        return songs.toString();
    }
}
