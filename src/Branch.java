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
        Boolean isDel = false;

        if (commits.size() == 0) {
            System.out.println("В ветке не найдено ни одного коммита!");
            return;
        };

        for (Commit i : this.commits ) {
            if (i.hash == hash) {
                isDel = true;
                this.commits.remove(i);
                break;
            }
        }

        if (isDel) {
            System.out.println("Коммит с hash-значением: " + hash + " удален!");
        } else {
            System.out.println("Коммит с hash-значением: " + hash + " не найден!");
        }

    }

    public String getBranchName() {
        return this.name;
    }

    //TODO
    @Override
    public String toString() {
        String result;
        result = "Имя ветки: " + this.name + "\n";
        for (Commit c: getCommits()) {
            result = result + c.toString() + "\n";
        }
        return result;
    }
}