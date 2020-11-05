package introconstructors;


import java.time.LocalDateTime;

public class Task {
    private String title;
    private String description;
    private LocalDateTime startDateTime;

    /**
     * package introconstructors;
     * <p>
     * import java.time.LocalDateTime;
     * <p>
     * public class Task {
     * private String title;
     * private String description;
     * private LocalDateTime startDateTime;
     * <p>
     * public Task() {
     * }
     * }
     **/
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }
    /**
     *     public Task(String var1, String var2) {
     *         this.title = var1;
     *         this.description = var2;
     *
     *
     */
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void start(){
        this.startDateTime=LocalDateTime.now();
    }

    public static void main(String[] args) {
        Task task=new Task("venni sört","mert szereted");
        task.start();
        System.out.println(task.getTitle()+" "+task.getDescription()+" "+task.startDateTime);
    }
}
