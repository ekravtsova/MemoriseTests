import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class IncorrectLoginTest {

    @Before
    public void setUp(){
        open("http://localhost:8080/#!/login");
    }

    @Test
    public void setNotExistedUserName() {
        String login = "vdheuy";
        String password = "user";

        LoginPage.logInAsUser(login, password);

        Assert.assertTrue("The user " + login + " was logged in.", !NavigationBar.isUserLoggedIn(login));
        // Also should be something like Alert window with error for the user,
        // but in this version the alert isn't realized
    }

    @Test
    public void setIncorrectPassword() {
        String login = "user";
        String password = "g3k2g2";

        LoginPage.logInAsUser(login, password);

        Assert.assertTrue("The user " + login + " was logged in with password " + password,
                            !NavigationBar.isUserLoggedIn(login));
    }
}
