import java.util.HashSet;
import java.util.Set;

public class Repository {

    private Set<Branch> branches;

    public Repository() {
        this.branches = new HashSet<>();
    }

    public void addBranch(Branch branch) {
        for (Branch br : getBranches()) {
            if (br.getBranchName().equals(branch.getBranchName())) {
                System.out.println("Ветка с именем " + branch.getBranchName() + " уже создана!");
                System.out.println("Нельзя добавлять ветки с одинаковым именем!");
                return;
            }
        }

        this.branches.add(branch);
    }

    public Set<Branch> getBranches() {
        return this.branches;
    }

    public Commit findCommitsByAuthor(String author) {
        Commit commitResult = null;
        for (Branch br : getBranches()) {
            Boolean isFind = false;
            for (Commit cm : br.getCommits()) {
                if (cm.getCommitAuthor().equals(author)) {
                    isFind = true;
                    commitResult = cm;
                    break;
                }
            }
            if (isFind) {
                break;
            }
        }

        return commitResult;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Репозиторий.");
        str.append("\n");
        str.append(" Список веток:");
        for (Branch br : getBranches()) {
            str.append("  Имя ветки: ");
            str.append(br.getBranchName());
            str.append("\n");
            str.append("    Список коммитов:");
            str.append("\n");

            for (Commit cm : br.getCommits()) {
                str.append("     - Коммит: ");
                str.append(cm.toString());
            }
        }
        return str.toString();
    }
}