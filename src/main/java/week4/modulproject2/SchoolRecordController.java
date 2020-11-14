package week4.modulproject2;


import java.util.*;

public class SchoolRecordController {
    private ClassRecords classRecords;
    private List<Subject> subjects = new ArrayList<>();
    private List<Tutor> tutors = new ArrayList<>();

    public static void main(String[] args) {
        SchoolRecordController schoolRecordController = new SchoolRecordController();
        schoolRecordController.initSchool();
        schoolRecordController.printMenu();
        schoolRecordController.runMenu();
    }

    public void initSchool() {

        classRecords = new ClassRecords("4A", new Random());
        Subject matematika = new Subject("matematika");
        Subject geo = new Subject("földrajz");
        Subject bio = new Subject("biológia");
        Subject fizika = new Subject("fizika");
        Subject kemia = new Subject("kémia");
        subjects = Arrays.asList(matematika, geo, bio, fizika, kemia);

        Tutor tutor1 = new Tutor("Nagy Csilla", Arrays.asList(matematika, geo, bio, kemia));
        Tutor tutor2 = new Tutor("Kovács Előd", Arrays.asList(fizika, kemia));
        tutors = Arrays.asList(tutor1, tutor2);

        Student student1 = new Student("Kiss Árpád");
        Student student2 = new Student("Nagy Ferenc");
        Student student3 = new Student("Közepes Géza");
        Student student4 = new Student("Pici Peti");
        Student student5 = new Student("Hatalmas Pál");
        classRecords.addStudent(student1);
        classRecords.addStudent(student2);
        classRecords.addStudent(student3);
        classRecords.addStudent(student4);
        classRecords.addStudent(student5);
        student1.grading(new Mark(MarkType.A, matematika, tutor1));
        student1.grading(new Mark(MarkType.A, fizika, tutor2));
        student2.grading(new Mark(MarkType.B, matematika, tutor1));
        student3.grading(new Mark(MarkType.C, matematika, tutor1));
        student4.grading(new Mark(MarkType.D, matematika, tutor1));
        student5.grading(new Mark(MarkType.E, matematika, tutor1));

    }

    public void printMenu() {
        System.out.println("""
                1. Diákok nevének listázása
                2. Diák név alapján keresése
                3. Diák létrehozása
                4. Diák név alapján törlése
                5. Diák feleltetése
                6. Osztályátlag kiszámolása
                7. Tantárgyi átlag kiszámolása
                8. Diákok átlagának megjelenítése
                9. Diák átlagának kiírása
                10. Diák tantárgyhoz tartozó átlagának kiírása
                11. Kilépés""");
    }

    public void runMenu() {
        boolean exit = false;
        while (!exit) {
            Scanner scanner = new Scanner(System.in);
            Integer number = null;
            boolean correctNumber = false;
            while (!correctNumber) {
                try {
                    System.out.println("Válasza ki a menű pontot");
                    number = Integer.parseInt(scanner.nextLine());
                    correctNumber = true;
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                    System.out.println("1-11 válaszd a számot");
                }
            }
            switch (number) {
                case 1:
                    System.out.println(classRecords.listStudentNames());
                    break;

                case 2:
                    System.out.println(classRecords.findStudentByName(getName()));
                    break;

                case 3:
                    System.out.println("Név:");
                    Student newStudent;
                    boolean correctCase3 = false;
                    while (!correctCase3) {
                        try {
                            newStudent = new Student(getName());
                            classRecords.addStudent(newStudent);
                            System.out.println("Hozzá adva: " + newStudent.getName());
                            correctCase3 = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 4:
                    boolean correctCase4 = false;
                    while (!correctCase4) {
                        try {
                            Student deleteStudent = classRecords.findStudentByName(getName());
                            classRecords.removeStudent(deleteStudent);
                            correctCase4 = true;
                            System.out.println("törölve:" + deleteStudent.getName());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 5:
                    Student student = classRecords.repetition();
                    MarkType mark = checkedMark();
                    Subject subject = checkedSubject();
                    Tutor tutor = checkedTutor(subject);
                    student.grading(new Mark(mark, subject, tutor));
                    System.out.println("név: " + student.getName() + " jegy: " + mark.getValue() + " tantárgy: " + subject.getSubjectName() + " tanár: " + tutor.getName());
                    break;

                case 6:
                    try {
                        System.out.println(classRecords.calculateClassAverage());
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:

                    System.out.println(classRecords.calculateClassAverageBySubject(checkedSubject()));

                    break;
                case 8:

                    System.out.println(classRecords.listStudyResults());
                    break;
                case 9:
                    boolean correctCase9 = false;
                    while (!correctCase9) {
                        try {
                            System.out.println(classRecords.findStudentByName(getName()).calculateAverage());
                            correctCase9 = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 10:
                    boolean correctCase10 = false;
                    while (!correctCase10)
                        try {
                            System.out.println(classRecords.findStudentByName(getName()).calculateSubjectAverage(checkedSubject()));
                            correctCase10=true;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    break;

                case 11:
                    exit = true;
                    System.out.println("viszlát");
                    break;


            }

        }
    }

    private Tutor getTutor(Subject subject) {
        Scanner scanner = new Scanner(System.in);
        Integer index = null;
        boolean correct = false;
        List<Tutor> tutorsOfSubject = new ArrayList<>();
        for (Tutor tutor : tutors) {
            if (tutor.tutorTeachingSubject(subject)) {
                tutorsOfSubject.add(tutor);
            }
        }
        for (int i = 0; i < tutorsOfSubject.size(); i++) {
            System.out.println((i + 1) + ". " + tutorsOfSubject.get(i).getName());
        }
        while (!correct) {
            try {

                System.out.println("Válaszd  ki a tanárt 1-" + tutorsOfSubject.size());
                index = Integer.parseInt(scanner.nextLine()) - 1;
                correct = true;
            } catch (IllegalArgumentException | NullPointerException | IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }

        return tutorsOfSubject.get(index);
    }

    private String getName() {
        Scanner scanner = new Scanner(System.in);
        String name = null;
        boolean correct = false;
        while (!correct) {
            try {
                System.out.println("Név:");
                name = scanner.nextLine();
                correct = true;
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return name;
    }

    private MarkType getMark() {
        Scanner scanner = new Scanner(System.in);
        Integer mark = null;
        boolean correct = false;
        while (!correct) {
            try {
                System.out.println("Érdemjegy 1-5");
                mark = 5 - Integer.parseInt(scanner.nextLine());
                correct = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return MarkType.values()[mark];
    }

    private Subject getSubject() {
        Scanner scanner = new Scanner(System.in);
        Integer index = null;
        boolean correct = false;
        while (!correct) {
            try {
                for (int i = 0; i < subjects.size(); i++) {
                    System.out.println((i + 1) + " : " + subjects.get(i).getSubjectName());
                }
                System.out.println("válaszd ki a tantárgyat 1-" + subjects.size());
                index = Integer.parseInt(scanner.nextLine()) - 1;
                correct = true;
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
        return subjects.get(index);
    }

    private MarkType checkedMark() {
        MarkType mark = null;
        boolean correctMark = false;
        while (!correctMark) {
            try {
                mark = getMark();
                correctMark = true;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        return mark;
    }

    private Subject checkedSubject() {
        Subject subject = null;
        boolean correctSubject = false;
        while (!correctSubject) {
            try {
                subject = getSubject();
                correctSubject = true;
            } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
        return subject;
    }

    private Tutor checkedTutor(Subject subject) {
        Tutor tutor = null;
        boolean correctTutor = false;
        while (!correctTutor) {
            try {
                tutor = getTutor(subject);
                correctTutor = true;
            } catch (NullPointerException | IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        return tutor;
    }
}
