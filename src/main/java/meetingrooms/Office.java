package meetingrooms;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void AddMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void PrintNames() {
        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.println(meetingRoom.getName());
        }
    }

    public void PrintNamesReverse() {
        for (int i = meetingRooms.size() - 1; i > -1; i--) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void PrintEvenNames() {
        for (int i = 1; i < meetingRooms.size(); i += 2) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas() {
        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.println(meetingRoom.GetArea());
        }
    }

    public void printMeetingRoomsWithName(String name) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (name.equals(meetingRoom.getName())) {
                System.out.println(meetingRoom.getName());
            }
        }
    }

    public void printMeetingRoomsContains(String part) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getName().toLowerCase().contains(part.toLowerCase())) {
                System.out.println(meetingRoom.getName());
            }

        }
    }

    public void printAreasLargerThan(int area) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.GetArea() > area) {
                System.out.println(meetingRoom.getName() + ": " + meetingRoom.getWidth() + "x" + meetingRoom.getLength() + "=" + meetingRoom.GetArea());
            }
        }
    }


}
