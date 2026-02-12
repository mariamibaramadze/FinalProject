package uitests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import utils.DriverFactory;

public class CartSubscriptionTest extends TestBase {

    @Test
    public void verifyUserCanSubscribeFromCartPage() {


        DriverFactory.getDriver().get("https://automationexercise.com/");

        HomePage homePage = new HomePage(DriverFactory.getDriver());


        Assert.assertTrue(
                homePage.isSliderPresent(),
                "Home page is not visible"
        );

        CartPage cartPage = homePage.clickCartButton();

        cartPage.scrollToFooter();

        Assert.assertTrue(
                cartPage.isSubscriptionTitleVisible(),
                "'Subscription' title is not visible"
        );

        String email = "test" + System.currentTimeMillis() + "@mail.com";

        cartPage
                .enterSubscriptionEmail(email)
                .clickSubscribeButton();

        Assert.assertTrue(
                cartPage.isSubscriptionSuccessMessageVisible(),
                "Subscription success message is not visible"
        );
    }
}
