import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static com.codeborne.selenide.Selenide.open;

public class RegisterTest {

    @Before
    public void setUp(){
        open("http://localhost:8080");

        // Should be opened Register page by the Url, but now user redirected to the Login page
        NavigationBar.btn_Register().click();

        Assert.assertTrue("The Register page isn't opened.",
                RegisterPage.registerPageTitle().waitUntil(Condition.visible, PropertiesForTests.timeout).isDisplayed());
    }

    @Test
    public void registerStandard() {
        String login = "user_new" + Math.round(Math.random()*100000);
        String password = "user_new_password" + Math.round(Math.random()*100000);

        RegisterPage.registerAsUser(login, password);

        Assert.assertTrue("Login page isn't opened after registration.",
                LoginPage.loginPageTitle().waitUntil(Condition.visible, PropertiesForTests.timeout).exists());
        // should be message or alert window with confirming of registration,
        // but it isn't in current version

        LoginPage.logInAsUser(login, password);

        Assert.assertTrue("New user cannot login after registration.", NavigationBar.isUserLoggedIn(login));

    }

    @Test
    public void registerAlreadyExistedUser(){
        String login = "user";
        String password = "newpassword";

        RegisterPage.registerAsUser(login, password);

        Assert.assertTrue("There is no message about already existed user with the same login.",
                RegisterPage.alertAboutRegistration().waitUntil(Condition.visible, PropertiesForTests.timeout)
                            .text().contains("User with the same name is already exist"));

        Selenide.navigator.open("http://localhost:8080/#!/login");
        LoginPage.logInAsUser(login,password);

        Assert.assertTrue("The password for user is changed after failed registration.", !NavigationBar.isUserLoggedIn(login));
    }
}
