import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class DeleteMemoTest {

    @Before
    public void setUp(){
        open("http://localhost:8080/#!/login");
        LoginPage.logInAsUser("publisher","publisher");

        Assert.assertTrue("Cannot login as publisher/publisher.", NavigationBar.isUserLoggedIn("publisher"));
    }

    @Test
    public void deleteExistingMemo() throws Exception {
        MemosPage.checkbox_Candidate().setSelected(true);
        MemosPage.checkbox_Actual().setSelected(true);
        MemosPage.checkbox_Archived().setSelected(true);

        Integer size = MemosPage.list_Memos().size();

        // suppose that there is at least one memo for deletion
        if (size > 0) {
            MemosPage.list_Memos().get(0).btn_Delete.click();
            Assert.assertTrue("The memo isn't deleted.", MemosPage.list_Memos().size() == size-1);
            // It will be better to show message about deleted memo to the user
        }
        else Assert.assertTrue("There is no memos for deletion.",false);
    }
}
