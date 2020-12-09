package ioprintwriter.talentshow;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {


    private final List<Production> productions = new ArrayList<>();
    private final List<Vote> votes = new ArrayList<>();


    public void readTalents(Path path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        for (String line : lines) {
            String[] parts = line.split(" ");
            productions.add(new Production(Integer.parseInt(parts[0]), parts[1]));
        }
    }

    public void calculateVotes(Path path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        for (String line : lines) {
            createVote(line);
        }
    }

    private void createVote(String line) {
        long id = Long.parseLong(line);
        Vote vote = searchById(id);
        if (vote == null) {
            votes.add(new Vote(id, 1));
        } else {
            vote.incNum();
        }
    }

    private Vote searchById(long id) {
        for (Vote vote : votes) {
            if (id == vote.getId()) {
                return vote;
            }
        }
        return null;
    }


    public List<Production> getProductions() {
        return List.copyOf(productions);
    }

    public List<Vote> getVotes() {
        return List.copyOf(votes);
    }


    public void writeResultToFile(Path resultFile) {
        try (PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(resultFile))) {
            for (Production production : productions) {
                String str = String.format("%d %s %d", production.getId(), production.getName(), searchById(production.getId()).getNumber());
                printWriter.write(str + "\n");
            }
            String str = String.format("Winner: %s", winner().getName());
            printWriter.write(str);
        } catch (IOException | NullPointerException ioe) {
            throw new IllegalStateException("Can not write file");
        }
    }

    private Production winner() {
        for (Production production : productions  ) {
            if (production.getId()== max().getId()) {
                return production;
            }
        }
        throw new IllegalArgumentException("not find");
    }

    private Vote max() {
        int max = votes.get(0).getNumber();
        int index = 0;
        for (int i = 1; i < votes.size(); i++) {
            if (votes.get(i).getNumber() > max) {
                max = votes.get(i).getNumber();
                index = i;
            }
        }
        return votes.get(index);
    }
}
