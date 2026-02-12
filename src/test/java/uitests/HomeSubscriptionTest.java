package uitests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.DriverFactory;

public class HomeSubscriptionTest extends TestBase {

    @Test
    public void verifyUserCanSubscribeFromFooter() {

        DriverFactory.getDriver().get("https://automationexercise.com/");

        HomePage homePage = new HomePage(DriverFactory.getDriver());

        Assert.assertTrue(
                homePage.isSliderPresent(),
                "Home page is not visible"
        );

        homePage.scrollToFooter();

        Assert.assertTrue(
                homePage.isSubscriptionTitleVisible(),
                "'SUBSCRIPTION' title is not visible"
        );

        String email = "ruadzenini3@gmail.com";

        homePage
                .enterSubscriptionEmail(email)
                .clickSubscribeButton();

        Assert.assertTrue(
                homePage.isSubscriptionSuccessMessageVisible(),
                "Subscription success message is not visible"
        );
    }
}
