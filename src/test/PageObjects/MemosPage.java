import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class MemosPage {

    public static SelenideElement label_MemosPageTitle() {
        return $("h3:not(.ng-hide)");
    }

    public static ArrayList<Memo> list_Memos() {
        sleep(2000);
        ElementsCollection memos = $$(By.xpath("//div[@ng-repeat=\"memo in filterMemosByAllStatuses(memoEntries)\"]"));
        ArrayList<Memo> listOfMemos = new ArrayList<Memo>();

        for (SelenideElement memo : memos) {
            listOfMemos.add(new Memo(memo));
        }
        return listOfMemos;
    }

    public static SelenideElement checkbox_Archived() {
        return $(By.xpath("//input[@ng-model=\"checkboxStatusModel.archived\"]"));
    }

    public static SelenideElement checkbox_Actual() {
        return $(By.xpath("//input[@ng-model=\"checkboxStatusModel.actual\"]"));
    }

    public static SelenideElement checkbox_Candidate() {
        return $(By.xpath("//input[@ng-model=\"checkboxStatusModel.candidate\"]"));
    }

    public static SelenideElement btn_CreateMemo() {
        return $(By.xpath("//a[@title=\"Create\"]"));
    }

    public static Boolean isListMemosContainMemo(String title, String description, String status) {
        Integer index = 0;

        for (Memo memo : MemosPage.list_Memos()) {
            if (memo.memoTitle.equals(title) && memo.memoDescription.equals(description) && memo.memoStatus.equals(status)) {
                index++;
                break;
            }
        }

        return index < list_Memos().size();
    }
}
