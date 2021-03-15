package exam03retake02;

public class Todo {
    private String text;
    private State state;
    private int priority;

    public Todo(String text, int priority) {
        chechPiority(priority);
        this.text = text;
        this.priority = priority;
        this.state = State.NON_COMPLETED;
    }

    private void chechPiority(int priority) {
        if (priority<1 || priority>5) {
            throw new IllegalArgumentException("Wrong piority number: "+priority);
        }
    }

    public String getText() {
        return text;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }

    public void complete() {
        this.state = State.COMPLETED;
    }
}
