import java.util.HashSet;
import java.util.Set;

public class Repository {

    private Set<Branch> branches;

    public Repository() {
        this.branches = new HashSet<>();
    }

    public void addBranch(Branch branch) {
        //TODO Нельзя добавлять ветки с однинаковыми именами
        this.branches.add(branch);
    }

    public Set<Branch> getBranches() {
        return this.branches;
    }

    //TODO
    public Commit findCommitsByAuthor(String author) {
        return null;
    }

    //TODO
    @Override
    public String toString() {
        return null;
    }
}