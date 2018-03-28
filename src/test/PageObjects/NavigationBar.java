import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;

public class NavigationBar {

    public static SelenideElement btn_Memos(){
        return $(".navbar-header");
    }

    public static SelenideElement btn_Home(){
        return $(By.xpath("//ul[contains(@class, \"navbar-nav\")]//a[contains(text(),\"Home\")]"));
    }

    public static SelenideElement btn_Login(){
        return $(By.xpath("//ul[contains(@class, \"navbar-nav\")]//a[contains(text(),\"Login\")]"));
    }

    public static SelenideElement btn_Register(){
        return $(By.xpath("//ul[contains(@class, \"navbar-nav\")]//a[contains(text(),\"Register\")]"));
    }

    public static SelenideElement btn_Crawler(){
        return $(By.xpath("//ul[contains(@class, \"navbar-nav\")]//a[contains(text(),\"Crawler\")]"));
    }

    public static SelenideElement btn_UserName(String userName){
        return $(By.xpath("//ul[contains(@class, \"navbar-nav\")]//a[contains(text(),\"" + userName + "\")]"));
    }

    public static SelenideElement btn_Logout(){
        return $(By.xpath("//ul[contains(@class, \"navbar-nav\")]//a[contains(text(),\"Logout\")]"));
    }

    public static Boolean isUserLoggedIn(String userName){
        try {
            btn_UserName(userName).waitUntil(Condition.exist, PropertiesForTests.timeout);
        }
        catch (NoSuchElementException ex) {
            System.out.println("There is no username " + userName + " on the page.");
            return btn_UserName(userName).exists();
        }
        finally {
            return btn_UserName(userName).exists();
        }

    }
}
