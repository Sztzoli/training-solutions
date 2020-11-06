package week02.modulproject;

public class MeetingRoom {
    private String name;
    private int length;
    private int width;

    public MeetingRoom(String name, int length, int width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int GetArea() {
        return getLength()*getWidth();
    }
}
