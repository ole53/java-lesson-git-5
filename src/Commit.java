import java.time.LocalDateTime;

public class Commit {

    private String diff;

    private String message;

    private String author;

    private LocalDateTime time;

    int hash;

    public Commit(String diff, String message, String author) {
        this.diff = diff;
        this.message = message;
        this.author = author;
        this.time = LocalDateTime.now();
        this.hash = (diff + message + author).hashCode();
    }

    //TODO
    @Override
    public String toString() {
        return null;
    }
}