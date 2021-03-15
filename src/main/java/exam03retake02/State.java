package exam03retake02;

public enum State {
    COMPLETED,
    NON_COMPLETED;


    public static boolean isNotCompleted(Todo todo) {
        return todo.getState()==NON_COMPLETED;
    }
}
