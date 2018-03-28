import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MemoCreateAndEditPage {

    public static SelenideElement label_CreateTitle(){
        return $(".page-header>h3");
    }

    public static SelenideElement field_MemoTitle(){
        return $("#title");
    }

    public static SelenideElement field_MemoDescription(){
        return $("#Description");
    }

    public static SelenideElement selector_MemoStatus(){
        return $("#status");
    }

    public static SelenideElement btn_MemoSave(){
        return $(By.xpath("//button[@type=\"submit\"]"));
    }
}
