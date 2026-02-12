package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//agi aris lokatori
public class HomePage extends BasePage {
    private By Slider = By.id("slider");
    private By LoginButton = By.xpath("//a[text()=' Signup / Login']");
    private By TestcaseButton = By.xpath("//a[text()=' Test Cases']");
    private By ContactusButtom = By.xpath("//a[@href='/contact_us']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSliderPresent() {
        return visible(Slider);
    }

    public SignupPage clickLoginButton() {
        click(LoginButton);
        return new SignupPage(driver);
    }
    public TestcasesPage clickTestcaseButton() {
        click(TestcaseButton);
        return new TestcasesPage(driver);
    }
    public ContactusPage clickContactusButton() {
        click(ContactusButtom);
        return new ContactusPage(driver);
    }


//აქედან მეორე ტესტია
    private By loggedInAsUser = By.xpath("//a[contains(normalize-space(.), 'Logged in as')]");

    private By deleteAccountButton = By.xpath("//a[@href='/delete_account']");

    public boolean isLoggedInAsUserVisible() {
        return visible(loggedInAsUser);
    }

    public AccountDeletedPage clickDeleteAccount() {
        click(deleteAccountButton);
        return new AccountDeletedPage(driver);
    }
//აქამდე მეორე


//აქედან მეოთხეა
private By logoutButton = By.xpath("//a[@href='/logout']");

    public SignupPage clickLogout() {
        click(logoutButton);
        return new SignupPage(driver);
    }
//აქამდე მეოთხე



//    test case 10
private By footer = By.id("footer");

    private By subscriptionTitle =
            By.xpath("//footer[@id='footer']//h2[normalize-space()='Subscription']");


    private By subscriptionEmailInput = By.id("susbscribe_email");

    private By subscribeButton = By.id("subscribe");


    private By subscriptionSuccessMessage = By.id("success-subscribe");




    public void scrollToFooter() {
        scrollToElement(footer);
    }

    public boolean isSubscriptionTitleVisible() {
        return visible(subscriptionTitle);
    }

    public HomePage enterSubscriptionEmail(String email) {
        type(subscriptionEmailInput, email);
        return this;
    }

    public HomePage clickSubscribeButton() {
        click(subscribeButton);
        return this;
    }

    public boolean isSubscriptionSuccessMessageVisible() {
        return visible(subscriptionSuccessMessage);
    }


//    aqadea 10


//    aqedan 11

    private By cartButton = By.xpath("//a[@href='/view_cart']");

    public CartPage clickCartButton() {
        click(cartButton);
        return new CartPage(driver);
    }


//aqamde 11

//    aqedan 8

    private By productsButton = By.cssSelector("a[href='/products']");


    public ProductsPage clickProductsButton() {
        click(productsButton);
        return new ProductsPage(driver);
    }


}







