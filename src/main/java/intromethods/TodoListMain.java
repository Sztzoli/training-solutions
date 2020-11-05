package intromethods;

import java.util.Arrays;

public class TodoListMain {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.addTodo("venni sört");
        todoList.addTodo("venni pálinkát");
        todoList.addTodo("venni sört");
        todoList.addTodo("venni bort");
        todoList.addTodo("venni kenyér");
        todoList.addTodo("venni víz");

        System.out.println(todoList);

        todoList.finishToTodos("venni kenyér");
        System.out.println(todoList);

        todoList.finishAllTodos(Arrays.asList("venni pálinkát", "venni bort"));
        System.out.println(todoList);

        System.out.println(todoList.todosToFinish());

        System.out.println(todoList.numberOfFinishedTodos());
    }

}
