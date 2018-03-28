import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.open;

public class MemosForNotLoginUserTest {

    @Before
    public void setUp(){
        open("http://localhost:8080/#");
        NavigationBar.btn_Memos().waitUntil(Condition.enabled, PropertiesForTests.timeout).click();

        Assert.assertTrue("The Memos page isn't opened",
                            MemosPage.label_MemosPageTitle().text().contains("List of not actual memos"));
    }

    @Test
    public void memosHaveStatusArchived() throws Exception{
        ArrayList<Memo> memosList = MemosPage.list_Memos();

        for (Memo memo: memosList){
            Assert.assertTrue("There is memo with status " + memo.memoStatus + " for the not logged in user.",
                    memo.memoStatus.contains("ARCHIVED"));
        }
    }

    @Test
    public void only10MemosUserSee() throws Exception{
        ArrayList<Memo> memosList = MemosPage.list_Memos();

        Assert.assertTrue("There are more than 10 memos in the list", memosList.size() <= 10);
    }

}
