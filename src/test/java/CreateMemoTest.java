import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.open;

public class CreateMemoTest {

    Logger logger = Logger.getLogger(CreateMemoTest.class.getName());

    @Before
    public void setUp(){

        logger.info("Test start.");
        open("http://localhost:8080/#!/login");
        LoginPage.logInAsUser("publisher","publisher");

        Assert.assertTrue("Cannot login as publisher/publisher.", NavigationBar.isUserLoggedIn("publisher"));
    }

    @Test
    public void addNewMemo() throws Exception{
        logger.info("Test of correct addition of new memo is started.");

        MemosPage.btn_CreateMemo().click();
        String title = "Title for test memo" + LocalDateTime.now();
        String description = "Description for test memo." + LocalDateTime.now();
        String status = "ACTUAL";

        MemoCreateAndEditPage.field_MemoTitle().setValue(title);
        MemoCreateAndEditPage.field_MemoDescription().setValue(description);
        MemoCreateAndEditPage.selector_MemoStatus().selectOption(status);

        MemoCreateAndEditPage.btn_MemoSave().click();

        Assert.assertTrue("The memo page isn't opened after save new memo.",
                MemosPage.label_MemosPageTitle().waitUntil(Condition.visible, PropertiesForTests.timeout).isDisplayed());

        MemosPage.checkbox_Actual().setSelected(true);

        Assert.assertTrue("There is no changed memo.", MemosPage.isListMemosContainMemo(title, description, status));
    }

}
