import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.*;

public class CrawlerStartTest {
    Logger logger = Logger.getLogger(CrawlerStartTest.class.getName());

    @Before
    public void setUp(){

        logger.info("Test start.");
        open("http://localhost:8080/#!/login");
        LoginPage.logInAsUser("publisher","publisher");

        Assert.assertTrue("Cannot login as publisher/publisher.", NavigationBar.isUserLoggedIn("publisher"));
    }

    @Test
    public void startCrawler() throws Exception{
        logger.info("Test of start Crawler is started.");

        //TODO: change sleep to real condition of run Crawler
        sleep(100000); // for ensure that Crawler isn't run

        NavigationBar.btn_Crawler().click();

        Assert.assertTrue("There is no message that Crawler is started.",
                confirm("Crawler start successfully").contains("Crawler start successfully"));
    }

    @Test
    public void startCrawlerTwice() throws Exception{
        logger.info("Test of start Crawler twice is started.");

        NavigationBar.btn_Crawler().click();

        confirm();

        NavigationBar.btn_Crawler().click();

        Assert.assertTrue("There is no message about already started Crawler.",
                confirm("Please wait, crawler already is being run").contains("Please wait, crawler already is being run"));
    }
}
