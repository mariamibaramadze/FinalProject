package uitests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountDeletedPage;
import pages.HomePage;
import pages.SignupPage;
import utils.DriverFactory;

public class DeleteAccountTest extends TestBase {

    @Test
    public void loginWithValidCredentialsAndDeleteAccount() {

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

        AccountDeletedPage accountDeletedPage = homePage.clickDeleteAccount();

        Assert.assertTrue(
                accountDeletedPage.isAccountDeletedVisible(),
                "'ACCOUNT DELETED!' is not visible"
        );
    }
}
