import java.time.LocalDateTime;

public class Commit {

    private String diff;

    private String message;

    private String author;

    private LocalDateTime time;

    int hash;

    private String totalString;

    public Commit(String diff, String message, String author) {
        this.diff = diff;
        this.message = message;
        this.author = author;
        this.time = LocalDateTime.now();
        this.hash = (diff + message + author).hashCode();
        this.totalString = "Коммит: " + this.message + " Автор: " + this.author +
                           " Время события: " + this.time + " Hash: " + this.hash;
    }

    public String getCommitAuthor() {
        return this.author;
    }

    //TODO
    @Override
    public String toString() {
        return this.totalString;
    }
}