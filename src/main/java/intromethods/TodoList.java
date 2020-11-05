package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Todo> todos=new ArrayList<>();

    public void addTodo(String caption){
        todos.add(new Todo(caption));
    }

    public void finishToTodos(String caption){
        for (Todo todo: todos
             ) {
            if (todo.getCaption().equals(caption)){
                todo.finish();
            }
        }
    }

    public void finishAllTodos(List<String> list){
        for (String caption: list
             ) {
            finishToTodos(caption);
        }
    }

    public List<String> todosToFinish() {
        List<String> finishedTodos=new ArrayList<>();
        for (Todo todo: todos
             ) {
            if (todo.isFinished()) {
                finishedTodos.add(todo.getCaption());
            }
        }
        return finishedTodos;
    }

    public int numberOfFinishedTodos(){
        int number=0;
        for (Todo todo : todos
                ) {
            if (todo.isFinished()){
                number++;
            }
        }
        return number;
    }

    @Override
    public String toString() {
        return todos.toString();
    }
}
