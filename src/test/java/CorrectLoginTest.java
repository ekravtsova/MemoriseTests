import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class CorrectLoginTest {


    @Before
    public void setUp(){
        open("http://localhost:8080/#!/login");
    }


    @Test
    public void userLoginTest(){
        String login = "user";
        String password = "user";

        LoginPage.logInAsUser(login,password);
        Assert.assertTrue("User " + login + "/" + password + " wasn't logged in.", NavigationBar.isUserLoggedIn(login));
    }

    @Test
    public void publisherLoginTest(){
        String login = "publisher";
        String password = "publisher";

        LoginPage.logInAsUser(login,password);
        Assert.assertTrue("User " + login + "/" + password + " wasn't logged in.", NavigationBar.isUserLoggedIn(login));
    }
}
