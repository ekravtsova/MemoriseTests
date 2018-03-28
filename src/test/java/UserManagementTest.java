import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.open;

public class UserManagementTest {

    Logger logger = Logger.getLogger(UserManagementTest.class.getName());

    @Before
    public void setUp(){
        logger.info("Test start.");
        open("http://localhost:8080/#!/login");
        LoginPage.logInAsUser("user","user");

        Assert.assertTrue("Cannot login as user/user.", NavigationBar.isUserLoggedIn("user"));
    }


    @Test
    public void userShouldNotCreateMemo() throws Exception{
        logger.info("Test that 'user' cannot create new memo");

        Assert.assertTrue("There is Create memo button for the user.", !MemosPage.btn_CreateMemo().isDisplayed());
    }

    @Test
    public void userShouldNotEditMemo() throws Exception{
        logger.info("Test that 'user' cannot edit memo");

        MemosPage.checkbox_Actual().setSelected(true);
        MemosPage.checkbox_Archived().setSelected(true);

        if (MemosPage.list_Memos().size() >0)
        Assert.assertTrue("There is Edit memo button for the user.", !MemosPage.list_Memos().get(0).btn_Edit.isDisplayed());
        else logger.info("There is no memo.");

    }

    @Test
    public void userShouldNotDeleteMemo() throws Exception{
        logger.info("Test that 'user' cannot delete memo");

        MemosPage.checkbox_Actual().setSelected(true);
        MemosPage.checkbox_Archived().setSelected(true);

        if (MemosPage.list_Memos().size() >0)
            Assert.assertTrue("There is Delete memo button for the user.", !MemosPage.list_Memos().get(0).btn_Delete.isDisplayed());
        else logger.info("There is no memo.");
    }

    @Test
    public void userShouldFilterActualAndArchivedMemos() throws Exception{
        logger.info("Test that 'user' can filter memos by Actual and Archived statuses.");

        Assert.assertTrue("There is no Actual checkbox.", MemosPage.checkbox_Actual().isDisplayed());

        Assert.assertTrue("There is no Archived checkbox.", MemosPage.checkbox_Archived().isDisplayed());
    }

    @Test
    public void userShouldNotFilterCandidateMemos() throws Exception{
        logger.info("Test that 'user' cannot filter memos by Candidate statuses.");

        Assert.assertTrue("There is Candidate checkbox, but should not be.", !MemosPage.checkbox_Candidate().isDisplayed());

    }
}
