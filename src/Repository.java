import java.util.HashSet;
import java.util.Set;

public class Repository {

    private Set<Branch> branches;

    public Repository() {
        this.branches = new HashSet<>();
    }

    public void addBranch(Branch branch) {
        Boolean isExists = false;
        //TODO Нельзя добавлять ветки с однинаковыми именами
        for (Branch br : getBranches()) {
            if (br.getBranchName().equals(br.getBranchName())) {
                isExists = true;
                break;
            }
        }

        if (isExists) {
            System.out.println("Ветка с именем " + branch.getBranchName() + " уже создана!");
            System.out.println("Нельзя добавлять ветки с одинаковым именем!");
            return;
        }

        this.branches.add(branch);
    }

    public Set<Branch> getBranches() {
        return this.branches;
    }

    //TODO
    public Commit findCommitsByAuthor(String author) {
        Commit comm_res = null;
        Boolean isFind = false;
        for (Branch br : getBranches()) {
            for (Commit cm : br.getCommits()) {
                if (cm.getCommitAuthor().equals(author)) {
                    isFind = true;
                    comm_res = cm;
                    break;
                }
            }
            if (isFind) {
                break;
            }
        }

        return comm_res;
    }

    //TODO
    @Override
    public String toString() {
        String result = "Репозиторий." + "\n" + " Список веток:";
        for (Branch br : getBranches()) {
            result = result + "  Имя ветки: " + br.getBranchName() + "\n";
            result = result + "    Список коммитов:" + "\n";
            for (Commit cm : br.getCommits()) {
                result = "     - Коммит: " + cm.toString();
            }
        }
        return result;
    }
}