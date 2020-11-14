package week4.modulproject2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private List<Mark> marks = new ArrayList<>();
    private String name;

    public Student(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark) {
        if (mark==null){
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    public double calculateAverage() {
        double average=0;
        for (Mark mark: marks) {
            average+=mark.getMarkType().getValue();
        }
        return Math.round(average/(double) marks.size()*100)/100D;
    }

    public double calculateSubjectAverage(Subject subject) {
        double averageSubject=0;
        int count=0;
        for (Mark mark : marks) {
            if(subject.getSubjectName().equals(mark.getSubject().getSubjectName())){
                averageSubject+=mark.getMarkType().getValue();
                count++;
            }
        }
        if (count==0){
            return 0.;
        }
        else {
            return averageSubject/(double)count;
        }

    }


    public String markToString() {
        String str="";
        for (Mark mark : marks) {
            str+=mark.getSubject().getSubjectName()+": "+ mark.toString();
        }
        return str;
    }



    public String toString() {
        return name +" marks: "  +markToString();
    }
}
