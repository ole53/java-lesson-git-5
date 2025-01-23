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

        Assertions.assertTrue(repo.findCommitsByAuthor("okhodakov").equals(commit));
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
    public void check_removeCommit() {
        Branch branch = new Branch("master");
        String diff1 = "dif";
        String diff2 = "dif2";
        String mess1 = "Init";
        String mess2 = "Init2";
        String author1 = "Lera";
        String author2 = "Lera2";

        int hash1 = (diff1 + mess1 + author1).hashCode();

        Commit commit = new Commit(diff1, mess1, author1);
        Commit commit2 = new Commit(diff2, mess2, author2);

        branch.addCommit(commit);
        branch.addCommit(commit2);

        branch.removeCommit(hash1);

        Assertions.assertFalse(branch.getCommits().contains(commit));
    }

    @Test
    public void check_removeNotCreatedCommit() {
        Branch branch = new Branch("master");
        String diff1 = "dif";
        String diff2 = "dif2";
        String mess1 = "Init";
        String mess2 = "Init2";
        String author1 = "Lera";
        String author2 = "Lera2";

        int hash2 = (diff2 + mess2 + author2).hashCode();

        Commit commit = new Commit(diff1, mess1, author1);
        branch.addCommit(commit);
        branch.removeCommit(hash2);

        Assertions.assertTrue(branch.getCommits().contains(commit));
    }
}