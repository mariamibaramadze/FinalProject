package uitests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupPage;
import utils.DriverFactory;
//Test case 4
public class LogoutTest extends TestBase {

    @Test
    public void loginThenLogout_ShouldRedirectToLoginPage() {

        DriverFactory.getDriver().get("https://automationexercise.com/");

        HomePage homePage = new HomePage(DriverFactory.getDriver());
        Assert.assertTrue(
                homePage.isSliderPresent(),
                "Home page is not visible"
        );

        SignupPage signupPage = homePage.clickLoginButton();

        Assert.assertTrue(
                signupPage.isLoginVisible(),
                "'Login to your account' is not visible"
        );


        signupPage
                .EnterEmailAddress("ruadzenini3@gmail.com")
                .EnterPassword("nini")
                .clickLoginButton();

        Assert.assertTrue(
                homePage.isLoggedInAsUserVisible(),
                "'Logged in as username' is not visible"
        );

        signupPage = homePage.clickLogout();


        Assert.assertTrue(
                signupPage.isLoginVisible(),
                "User is NOT navigated back to Login page after logout"
        );
    }
}
