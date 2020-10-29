package classstructuremethods;

public class NoteMain {
    public static void main(String[] args) {
            Note note= new Note();
            note.setName("John Doe");
            note.setTopic("Java");
            note.setText("qwertzuiodséifahgfdgre");

        System.out.println(note.getNoteText());
    }
}
