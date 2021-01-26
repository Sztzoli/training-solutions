package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {
    private String name;
    private List<Subject> taughtSubject = new ArrayList<>();

    public Tutor(String name, List<Subject> taughtSubject) {
        this.name = name;
        this.taughtSubject = taughtSubject;
    }

    public String getName() {
        return name;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        boolean isContain = false;
        int i = 0;
        while (i < taughtSubject.size() && !isContain) {
            if (subject.getSubjectName().equals(taughtSubject.get(i).getSubjectName())) {
                isContain = true;
            }
            i++;
        }
        return isContain;
    }
}
