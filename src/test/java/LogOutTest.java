import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class LogOutTest{

    private String userName = "user";
    private String password = "user";

    @Before
    public void setUp(){
        open("http://localhost:8080/#!/login");

        LoginPage.logInAsUser(userName,password);
        Assert.assertTrue("Cannot login by " + userName +".", NavigationBar.isUserLoggedIn("user"));
    }

    @Test
    public void logoutUser() throws Exception{
        NavigationBar.btn_UserName(userName).click();
        NavigationBar.btn_Logout().waitUntil(Condition.visible, PropertiesForTests.timeout).click();

        Assert.assertTrue("User isn't logged out.", !NavigationBar.isUserLoggedIn(userName));
    }
}
