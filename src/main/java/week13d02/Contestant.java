package week13d02;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static week13d02.AnswerFileReader.correctAnswer;


public class Contestant {



    private final String id;

    private final List<String> answers = new ArrayList<>();

    public Contestant(String id, String answer) {
        this.id = id;
        answers.add(answer);
    }

    public Contestant addAnswer(String answer) {
        answers.add(answer);
        return this;
    }

    public String getId() {
        return id;
    }

    public List<String> getAnswers() {
        return new ArrayList<>(answers);
    }

    public int xNumber() {
        return (int) answers.stream().filter(value -> value.equals("X")).count();
    }

    public int point() {
        int point = 0;
        for (int i = 0; i < answers.size(); i++) {
            if (correctAnswer.charAt(i) == answers.get(i).charAt(0)) {
                point += (i + 1);
            }
            else if ('X' != answers.get(i).charAt(0)){
                point += -2;
            }
        }
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contestant that = (Contestant) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + ": " + answers.toString();
    }
}
