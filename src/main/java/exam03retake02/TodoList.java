package exam03retake02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public List<Todo> getTodos() {
        return new ArrayList<>(todos);
    }

    public int getNumberOfItemsLeft() {
        return (int) todos.stream()
                .filter(State::isNotCompleted)
                .count();
    }

    private int minPriority() {
        return todos.stream()
                .mapToInt(Todo::getPriority)
                .min()
                .orElseThrow(() -> new IllegalStateException("empty list"));
    }

    public List<String> getMostImportantTodosText() {
        return todos.stream()
                .filter(td -> td.getPriority() == minPriority())
                .map(Todo::getText)
                .collect(Collectors.toList());
    }

    public void deleteCompleted() {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()){
            Todo todo = iterator.next();
            if (todo.getState()==State.COMPLETED) {
                iterator.remove();
            }
        }
    }
}
