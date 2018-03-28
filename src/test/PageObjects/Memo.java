import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class Memo {
    public SelenideElement btn_Delete;
    public SelenideElement btn_Edit;
    public String memoDate;
    public String memoTitle;
    public String memoDescription;
    public String memoStatus;

    Memo (SelenideElement memoElement) {
        btn_Delete = memoElement.$(By.xpath("//a[@title=\"delete\"]"));
        btn_Edit = memoElement.$(By.xpath("//a[@title=\"edit\"]"));
        memoDate = memoElement.$("h4").text();
        memoTitle = memoElement.$(By.xpath("//p[1]")).text();
        memoDescription = memoElement.$(By.xpath("//p[2]")).text();
        memoStatus = memoElement.$(By.xpath("//p[3]")).text();
    }

}
