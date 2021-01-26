package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {
    private String className;
    private Random rmd;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rmd) {
        this.className = className;
        this.rmd = rmd;
    }

    public String getClassName() {
        return className;
    }

    // felvesz egy diákot az osztályba
    public boolean addStudent(Student student) {
        boolean isAdd = true;
        for (Student element : students) {
            if (student.getName().equals(element.getName())) {
                isAdd = false;
            }
        }
        if (isAdd) {
            students.add(student);
        }
        return isAdd;


    }

    //kivesz egy diákot az osztályból
    public boolean removeStudent(Student student) {
        boolean isContain = false;
        int i = 0;
        while (i < students.size() && !isContain) {
            if (student.getName().equals(students.get(i).getName())) {
                isContain = true;
                students.remove(i);
            }
            i++;
        }
        return isContain;
    }

    //osztályátlagot számol, minden diákot figyelembe véve
    public double calculateClassAverage() {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double average = 0.;
        for (Student student : students) {
            average += student.calculateAverage();
        }
        if (average == 0) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return average / (double) students.size();
    }

    //tantárgy szerinti osztályátlagot számol,
    // kihagyja azon diákokat, akiknek az adott tantárgyból nincs jegye
    public double calculateClassAverageBySubject(Subject subject) {
        double average = 0.;
        int count = 0;
        for (Student student : students) {
            if (student.calculateSubjectAverage(subject) != 0.0) {
                average += student.calculateSubjectAverage(subject);
                count++;
            }
        }
        return average / (double) count;
    }

    // név szerint megkeres egy diákot az osztályban
    public Student findStudentByName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to search!");
        }
        int i = 0;
        boolean isFind = false;
        while (i < students.size() && !isFind) {
            if (name.equals(students.get(i).getName())) {
                isFind = true;
                return students.get(i);
            }
            i++;
        }
        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }

    //felelethez a listából random módon kiválaszt egy diákot
    public Student repetition() {
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(rmd.nextInt(students.size()));
    }

    //a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi,
    // és azok listáját adja vissza
    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> studyResultByNames = new ArrayList<>();
        for (Student student : students) {
            studyResultByNames.add(new StudyResultByName(student.getName(), student.calculateAverage()));
        }
        return studyResultByNames;
    }

    //kilistázza a diákok neveit, vesszővel elválasztva
    public String listStudentNames() {
        String str = "";
        for (int i = 0; i < students.size() - 1; i++) {
            str += students.get(i).getName() + ", ";
        }
        str += students.get(students.size() - 1).getName();
        return str;
    }
}
