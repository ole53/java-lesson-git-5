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
    public void removeCommit(int hash) {
        Set<Commit> commits = getCommits();

        if (commits.isEmpty()) {
            System.out.println("В ветке не найдено ни одного коммита!");
            return;
        };

        for (Commit i : commits) {
            if (i.hash == hash) {
                commits.remove(i);
                System.out.println("Коммит с hash-значением: " + hash + " удален!");
                return;
            }
        }

        System.out.println("Коммит с hash-значением: " + hash + " не найден!");
    }

    public String getBranchName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Имя ветки: ");
        str.append(this.name);
        str.append("\n");
        for (Commit c: getCommits()) {
            str.append(c.toString());
            str.append("\n");
        }
        return str.toString();
    }
}