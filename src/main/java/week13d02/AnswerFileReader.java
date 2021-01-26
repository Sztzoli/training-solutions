package week13d02;

import ioreader.states.State;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class AnswerFileReader {

    public static String correctAnswer;

    private final Map<String, Contestant> contestantMap = new HashMap<>();

    public Map<String, Contestant> getContestantMap() {
        return new HashMap<>(contestantMap);
    }

    public void read(BufferedReader reader) {
        try (reader) {

            String line;
            correctAnswer = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                Contestant temp = new Contestant(parts[0], parts[1]);
                addToMap(temp);
            }
        } catch (
                IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void addToMap(Contestant temp) {
        if (contestantMap.containsKey(temp.getId())) {
            contestantMap.put(temp.getId(), contestantMap.get(temp.getId()).addAnswer(temp.getAnswers().get(0)));
        } else {
            contestantMap.put(temp.getId(), temp);
        }
    }

    public boolean correctAnswerById(String id, int number) {
        Contestant contestant = contestantMap.get(id);
        return contestant.getAnswers().get(number - 1).charAt(0) ==
                (correctAnswer.charAt(number - 1));
    }

    public String idWithMostX() {
         Contestant contestant = contestantMap.values().
                stream().
                max(Comparator.comparingInt(Contestant::xNumber)).
                get();
        return contestant.getId();
    }


    public String getMostScore() {
        Contestant contestant = contestantMap.values().
                stream().
                max(Comparator.comparingInt(Contestant::point)).
                get();
        return contestant.getId();
    }


}
