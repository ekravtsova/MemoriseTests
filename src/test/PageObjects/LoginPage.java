import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static SelenideElement loginPageTitle(){
        return $(By.xpath("//h2[contains(text(), \"Login\")]"));
    }

    public static SelenideElement field_userName(){
        return $("#username");
    }

    public static SelenideElement field_password(){
        return $("#password");
    }

    public static SelenideElement checkbox_rememberMe(){
        return $("input[ng-model=rememberMe]");
    }

    public static SelenideElement btn_logIn(){
        return $(".btn[ng-click=\"login()\"]");
    }

    public static SelenideElement textInfoAboutLogin(){
        return $(".alert-info");
    }

    public static void logInAsUser(String userName, String password){
        field_userName().waitUntil(Condition.enabled, PropertiesForTests.timeout).setValue(userName);
        field_password().waitUntil(Condition.enabled, PropertiesForTests.timeout).setValue(password);
        btn_logIn().click();
    }


}
