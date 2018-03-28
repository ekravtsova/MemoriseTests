import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class RememberMeTest {

    @Before
    public void setUp(){
        open("http://localhost:8080/#!/login");
    }

    @Test
    public void setRememberMeCheckbox(){
        String login = "user";
        String password = "user";

        LoginPage.checkbox_rememberMe().setSelected(true);
        LoginPage.logInAsUser(login, password);

        Selenide.navigator.open("http://localhost:8080/"); // Hack. Should be .refresh method, but doesn't work for FF, see https://github.com/codeborne/selenide/issues/513

        Assert.assertTrue("The user was logged out after refreshing.", NavigationBar.isUserLoggedIn(login));
    }

    @Test
    public void notSetRememberMeCheckbox() {
        String login = "user";
        String password = "user";

        LoginPage.checkbox_rememberMe().setSelected(false);
        LoginPage.logInAsUser(login, password);
        Assert.assertTrue("The user isn't logged in.", NavigationBar.isUserLoggedIn(login));

        Selenide.navigator.open("http://localhost:8080/"); // Hack. Should be .refresh method, but doesn't work for FF, see https://github.com/codeborne/selenide/issues/513

        Assert.assertTrue("The user was logged out after refreshing.", !NavigationBar.isUserLoggedIn(login));
    }
}
