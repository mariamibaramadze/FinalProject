package pages;
// TEST CASE 3
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage{
    private By LoginVisible= By.xpath("//h2[text()='Login to your account']");
    private By EmailAddressBox = By.xpath("//input[@data-qa='login-email']");
    private By PasswordBox = By.xpath("//input[@data-qa='login-password']");
    private By LoginButton = By.xpath("//button[@data-qa='login-button']");
    private By TextError = By.xpath("//p[text()='Your email or password is incorrect!']");
 // registraciis nawili
    private By NewuserVisible = By.xpath("//h2[text()='New User Signup!']");
    private By nameInput = By.xpath("//input[@data-qa='signup-name']");
    private By emailInput = By.xpath("//input[@data-qa='signup-email']");
    private By signUpButton = By.xpath("//button[@data-qa='signup-button']");
    // Register User with existing email
    // Test case 5
    private By alreadyexistVisible = By.xpath("//p[text()='Email Address already exist!']");


    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginVisible() {
        return visible(LoginVisible);
    }

    public SignupPage EnterEmailAddress(String email){
        type(EmailAddressBox, email);
        return this;
    }
    public SignupPage EnterPassword(String password){
        type(PasswordBox, password);
        return this;
    }
    public SignupPage clickLoginButton(){
        click(LoginButton);
        return this;
    }
    public boolean VisibleTextError(){

        return visible(TextError);
    }

 // registraciis nawili
    public boolean isNewUserVisible(){
        return visible(NewuserVisible);
    }

    public SignupPage enterName(String name) {
        type(nameInput, name);
        return this;
    }

    public SignupPage enterEmail(String email) {
        type(emailInput, email);
        return this;
    }

    public SignupPage clickSignUpButton() {
        click(signUpButton);
        return this;
    }
// Register User with existing email
// Test case 5
    public boolean isAlreadyExistVisible(){
        return visible(alreadyexistVisible);
    }


}

