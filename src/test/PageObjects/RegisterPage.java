import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {

    public static SelenideElement field_RegisterUserName(){
        return $(By.xpath("//input[@id=\"username\"][contains(@ng-model,\"registerUsername\")]"));
    }

    public static SelenideElement field_RegisterPassword(){
        return $(By.xpath("//input[@id=\"password\"][contains(@ng-model,\"registerPassword\")]"));
    }

    public static SelenideElement btn_Register(){
        return $(By.xpath("//input[@value=\"Register\"][contains(@class,\"btn\")]"));
    }

    public static void registerAsUser(String login, String password) {
        field_RegisterUserName().setValue(login);
        field_RegisterPassword().setValue(password);
        btn_Register().click();
    }

    public static SelenideElement alertAboutRegistration(){
        return $(".alert-danger");
    }

    public static SelenideElement registerPageTitle(){
        return $(By.xpath("//h2[contains(text(), \"Register\")]"));
    }
}
