package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By footer = By.id("footer");

    private By subscriptionTitle =
            By.xpath("//footer[@id='footer']//h2[normalize-space()='Subscription']");



    private By subscriptionEmailInput =
            By.id("susbscribe_email");   // IMPORTANT typo

    private By subscribeButton =
            By.id("subscribe");

    private By subscriptionSuccessMessage =
            By.id("success-subscribe");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Scroll using BasePage method
    public void scrollToFooter() {
        scrollToElement(footer);
    }

    public boolean isSubscriptionTitleVisible() {
        return visible(subscriptionTitle);
    }

    public CartPage enterSubscriptionEmail(String email) {
        type(subscriptionEmailInput, email);
        return this;
    }

    public CartPage clickSubscribeButton() {
        click(subscribeButton);
        return this;
    }

    public boolean isSubscriptionSuccessMessageVisible() {
        return visible(subscriptionSuccessMessage);
    }
}
