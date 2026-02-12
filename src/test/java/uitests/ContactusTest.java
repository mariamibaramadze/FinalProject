package uitests;
//TEST CASE 6
import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactusPage;
import pages.HomePage;
import utils.DriverFactory;

import java.time.Duration;

@Test
public class ContactusTest extends TestBase {

    public void contactusTest() {

        DriverFactory.getDriver().get("https://automationexercise.com/");

        HomePage home = new HomePage(DriverFactory.getDriver());
        ContactusPage contactusPage = home.clickContactusButton();

        Assert.assertTrue(contactusPage.isIntouchVisible(),
                "GET IN TOUCH is not visible");

        contactusPage.inputname("pookie")
                .enteremail("pookie@mail.ru")
                .subjectinput("contact")
                .messageinput("this is so cool!");


        String filePath = System.getProperty("user.home") + "\\Downloads\\testfile.txt";
        contactusPage.uploadFile(filePath);


        contactusPage.clickSubmitButton();


        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        DriverFactory.getDriver().switchTo().alert().accept();


        Assert.assertTrue(contactusPage.isSuccessMessage(),
                "Success message not visible");

        contactusPage.clickHomeButton();
    }
}
