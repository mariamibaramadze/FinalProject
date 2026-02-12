package pages;
//TEST CASE 1
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {


    private By accountInfoVisible = By.xpath("//b[text()='Enter Account Information']");
    private By titleMrs = By.id("uniform-id_gender2");
    private By passwordInput = By.id("password");
    private By daysDropDown = By.id("days");
    private By monthsDropDown = By.id("months");
    private By yearsDropDown = By.id("years");
    private By newsletterCheckBox = By.id("newsletter");
    private By offersCheckBox = By.id("optin");
    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By companyInput = By.id("company");
    private By address1Input = By.id("address1");
    private By address2Input = By.id("address2");
    private By countryDropDown = By.id("country");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipCodeInput = By.id("zipcode");
    private By mobileNumber = By.id("mobile_number");
    private By createAccountBtn = By.xpath("//button[@data-qa='create-account']");
    private By accountCreatedText = By.xpath("//h2/b[text()='Account Created!']");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");
    private By loggedInText = By.xpath("//li/a[text()=' Logged in as ']");
    private By deleteAccountButton = By.xpath("//a[@href='/delete_account']"); // ' Delete Account'
    private By accountDeletedText = By.xpath("//h2/b[text()='Account Deleted!']");



    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public boolean isVisibleAccountInfo() {
        return visible(accountInfoVisible);
    }


    public RegisterPage selectTitleMrs() {
        click(titleMrs);
        return this;
    }

    public RegisterPage enterPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public RegisterPage setDOB(String day, String month, String year) {
        selectByVisibleText(daysDropDown, day);
        selectByVisibleText(monthsDropDown, month);
        selectByVisibleText(yearsDropDown, year);
        return this;
    }

    public RegisterPage selectNewsletter() {
        click(newsletterCheckBox);
        return this;
    }

    public RegisterPage selectOffers() {
        click(offersCheckBox);
        return this;
    }

    public RegisterPage enterFirstName(String firstName) {
        type(firstNameInput, firstName);
        return this;
    }

    public RegisterPage enterLastName(String lastName) {
        type(lastNameInput, lastName);
        return this;
    }

    public RegisterPage enterCompany(String company) {
        type(companyInput, company);
        return this;
    }

    public RegisterPage enterAddress1(String address1) {
        type(address1Input, address1);
        return this;
    }

    public RegisterPage enterAddress2(String address2) {
        type(address2Input, address2);
        return this;
    }

    public RegisterPage selectCountry(String country) {
        selectByVisibleText(countryDropDown, country);
        return this;
    }

    public RegisterPage enterState(String state) {
        type(stateInput, state);
        return this;
    }

    public RegisterPage enterCity(String city) {
        type(cityInput, city);
        return this;
    }

    public RegisterPage enterZipCode(String zip) {
        type(zipCodeInput, zip);
        return this;
    }

    public RegisterPage enterMobileNumber(String mobile) {
        type(mobileNumber, mobile);
        return this;
    }

    public RegisterPage clickCreateAccount() {
        click(createAccountBtn);
        return this;
    }

    public boolean isAccountCreatedVisible() {
        return visible(accountCreatedText);
    }

    public RegisterPage clickContinue() {
        click(continueButton);
        return this;
    }

    public boolean isLoggedInVisible() {
        return visible(loggedInText);
    }

    public RegisterPage clickDeleteAccount() {
        click(deleteAccountButton);
        return this;
    }

    public boolean isAccountDeletedVisible() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeletedText));
            return true;

    }

}







