package uitests;
//Test case 5
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupPage;
import utils.DriverFactory;

public class RegwexistingTest extends TestBase {
    @Test
    public void RegwexistingTest(){
        DriverFactory.getDriver().get("https://automationexercise.com/");

        HomePage home = new HomePage(DriverFactory.getDriver());
        SignupPage newuser = home.clickLoginButton();
        Assert.assertTrue(newuser.isNewUserVisible(), "new user is not Visible ");

        newuser.enterName("Project")
                .enterEmail("Project@gmail.com")
                .clickSignUpButton();

        Assert.assertTrue(newuser.isAlreadyExistVisible(), "Text isn't visible");

    }
}
