import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static com.codeborne.selenide.Selenide.open;

public class EditMemoTest {

    @Before
    public void setUp(){
        open("http://localhost:8080/#!/login");
        LoginPage.logInAsUser("publisher","publisher");

        Assert.assertTrue("Cannot login as publisher/publisher.", NavigationBar.isUserLoggedIn("publisher"));
    }

    @Test
    public void editMemo() throws Exception{
        MemosPage.checkbox_Candidate().setSelected(true);
        MemosPage.checkbox_Actual().setSelected(true);
        MemosPage.checkbox_Archived().setSelected(true);

        // suppose that there is at least one memo for edit
        Integer size = MemosPage.list_Memos().size();
        if (size > 0) {

            String title = "Autotest memo title" + LocalDateTime.now();
            String description = "Description of the memo from Autotest." + LocalDateTime.now();
            String status = "CANDIDATE";

            MemosPage.list_Memos().get(0).btn_Edit.click();
            MemoCreateAndEditPage.field_MemoTitle().clear();
            MemoCreateAndEditPage.field_MemoTitle().setValue(title);

            MemoCreateAndEditPage.field_MemoDescription().clear();
            MemoCreateAndEditPage.field_MemoDescription().setValue(description);

            MemoCreateAndEditPage.selector_MemoStatus().selectOption(status);

            MemoCreateAndEditPage.btn_MemoSave().click();

            Assert.assertTrue("The memo isn't saved.", MemosPage.label_MemosPageTitle().isDisplayed());

            MemosPage.checkbox_Candidate().setSelected(true);

            Assert.assertTrue("There isn't edited memo in the list.", MemosPage.isListMemosContainMemo(title, description, status));

        }
        else Assert.assertTrue("There is no memos for editing.",false);
    }
}
