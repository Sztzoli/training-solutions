package week05d05;

public class Song {
    private String name;
    private long lengthInSecond;
    private String artist;

    public Song(String name, long lengthInSecond, String artist) {
        if (isEmpty(name) || isEmpty(artist)){
            throw new IllegalArgumentException("Wrong name or artist");
        }
        this.name = name;
        if (lengthInSecond<0){
            throw new IllegalArgumentException("lengthInSecond is negative");
        }
        this.lengthInSecond = lengthInSecond;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public long getLengthInSecond() {
        return lengthInSecond;
    }

    public String getArtist() {
        return artist;
    }

    private boolean isEmpty(String str) {
        if (str==null || str.isBlank()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("name: %s;length: %d;artist: %s",name,lengthInSecond,artist);
    }
}
