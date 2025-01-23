import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RepositoryTest {

    @Test
    public void test_addBranch() {
        Repository repo = new Repository();
        Branch branch = new Branch("master");
        repo.addBranch(branch);

        Assertions.assertTrue(repo.getBranches().contains(branch));
    }

    @Test
    public void test_addCommit() {
        Branch branch = new Branch("master");
        Commit commit = new Commit("dif", "Init", "Lera");
        branch.addCommit(commit);

        Assertions.assertTrue(branch.getCommits().contains(commit));
    }
}