import java.util.HashSet;
import java.util.Set;

public class Branch {

    private String name;

    private Set<Commit> commits;

    public Branch(String name) {
        this.name = name;
        this.commits = new HashSet<>();
    }

    public void addCommit(Commit commit) {
        this.commits.add(commit);
    }

    public Set<Commit> getCommits() {
        return this.commits;
    }

    //TODO
    public void removeCommit(int hash) {}

    //TODO
    @Override
    public String toString() {
        return null;
    }
}