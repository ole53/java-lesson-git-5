import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.util.Objects.isNull;

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

    @Test
    public void test_findCommitsByAuthor() {
        Repository repo = new Repository();
        Branch branch = new Branch("master");
        Commit commit = new Commit("dif", "commit", "okhodakov");
        branch.addCommit(commit);
        repo.addBranch(branch);
        repo.findCommitsByAuthor("okhodakov");

        Assertions.assertEquals(repo.findCommitsByAuthor("okhodakov"), commit);
    }

    @Test
    public void test_findNullableCommit() {
        Repository repo = new Repository();
        Branch branch = new Branch("master");
        Commit commit = new Commit("dif", "commit", "okhodakov");
        branch.addCommit(commit);
        repo.addBranch(branch);
        repo.findCommitsByAuthor("okhodakov");

        Assertions.assertTrue(isNull(repo.findCommitsByAuthor("semenov")));
    }

    @Test
    public void test_removeCommit() {
        Branch branch = new Branch("master");
        String diffCommitFst = "dif";
        String diffCommitSec = "dif2";
        String messCommitFst = "Init";
        String messCommitSec = "Init2";
        String authorCommitFst = "Lera";
        String authorCommitSec = "Lera2";

        int hashFst = (diffCommitFst + messCommitFst + authorCommitFst).hashCode();

        Commit commit = new Commit(diffCommitFst, messCommitFst, authorCommitFst);
        Commit commitSec = new Commit(diffCommitSec, messCommitSec, authorCommitSec);

        branch.addCommit(commit);
        branch.addCommit(commitSec);
        branch.removeCommit(hashFst);

        Assertions.assertFalse(branch.getCommits().contains(commit));
    }

    @Test
    public void test_removeNotCreatedCommit() {
        Branch branch = new Branch("master");
        String diffCommitFst = "dif";
        String diffCommitSec = "dif2";
        String messCommitFst = "Init";
        String messCommitSec = "Init2";
        String authorCommitFst = "Lera";
        String authorCommitSec = "Lera2";

        int hashSec = (diffCommitSec + messCommitSec + authorCommitSec).hashCode();

        Commit commit = new Commit(diffCommitFst, messCommitFst, authorCommitFst);
        branch.addCommit(commit);
        branch.removeCommit(hashSec);

        Assertions.assertTrue(branch.getCommits().contains(commit));
    }
}