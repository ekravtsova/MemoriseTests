import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class FilterMemosByStatusTest {
    @Before
    public void setUp(){
        open("http://localhost:8080/#!/login");
        LoginPage.logInAsUser("publisher","publisher");

        Assert.assertTrue("Cannot login as publisher/publisher.", NavigationBar.isUserLoggedIn("publisher"));
    }

    @Test
    public void filterOnlyArchived() throws Exception{
        MemosPage.checkbox_Archived().setSelected(true);
        MemosPage.checkbox_Actual().setSelected(false);
        MemosPage.checkbox_Candidate().setSelected(false);

        if (MemosPage.list_Memos().size() > 0) {
            for (Memo memo : MemosPage.list_Memos()) {
                Assert.assertTrue("There is not ARCHIVED memo.", memo.memoStatus.contains("ARCHIVED"));
            }
        }
        else System.out.println("There are no ARCHIVED memos.");
    }

    @Test
    public void filterOnlyActual() throws Exception{
        MemosPage.checkbox_Archived().setSelected(false);
        MemosPage.checkbox_Actual().setSelected(true);
        MemosPage.checkbox_Candidate().setSelected(false);

        if (MemosPage.list_Memos().size() > 0) {
            for (Memo memo : MemosPage.list_Memos()) {
                Assert.assertTrue("There is not ACTUAL memo.", memo.memoStatus.contains("ACTUAL"));
            }
        }
        else System.out.println("There are no ACTUAL memos.");
    }

    @Test
    public void filterOnlyCandidate() throws Exception{
        MemosPage.checkbox_Archived().setSelected(false);
        MemosPage.checkbox_Actual().setSelected(false);
        MemosPage.checkbox_Candidate().setSelected(true);

        if (MemosPage.list_Memos().size() > 0) {
            for (Memo memo : MemosPage.list_Memos()) {
                Assert.assertTrue("There is not CANDIDATE memo.", memo.memoStatus.contains("CANDIDATE"));
            }
        }
        else System.out.println("There are no CANDIDATE memos.");
    }

    @Test
    public void filterByTwoStatuses() throws Exception{
        MemosPage.checkbox_Archived().setSelected(true);
        MemosPage.checkbox_Actual().setSelected(false);
        MemosPage.checkbox_Candidate().setSelected(true);

        if (MemosPage.list_Memos().size() > 0) {
            for (Memo memo : MemosPage.list_Memos()) {
                Assert.assertTrue("There is not CANDIDATE or ARCHIVED memo.",
                                memo.memoStatus.contains("CANDIDATE")||memo.memoStatus.contains("ARCHIVED"));
            }
        }
        else System.out.println("There are no CANDIDATE or ARCHIVED memos.");
    }

    // TODO: add test for filtering by three statuses. Should be DB with memos for every Status.
}
