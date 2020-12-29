package clone.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {
    private String name;
    private LocalDateTime time;
    private Status status;
    private List<Comment> comments = new ArrayList<>();

    public Issue(String name, LocalDateTime time, Status status) {
        this.name = name;
        this.time = time;
        this.status = status;
    }

   public Issue(Issue another , CopyMode copyMode){
        if(copyMode.isWithout(copyMode)){
            this.name = another.name;
            this.time = another.time;
            this.status = another.status;
        }
        else {
            this.name = another.name;
            this.time = another.time;
            this.status = another.status;
            List<Comment> tmp = new ArrayList<>();
            for (Comment comment: another.comments) {
                tmp.add(new Comment(comment));
            }
            this.comments = tmp;
        }
   }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Status getStatus() {
        return status;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
