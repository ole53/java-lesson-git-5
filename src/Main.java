public class Main {
    public static void main(String[] args) {

        Repository repository = new Repository();
        Branch branch = new Branch("ЖАБА-1.init");
        repository.addBranch(branch);

        Commit commit = new Commit("diff", "init", "me");
        branch.addCommit(commit);
    }
}