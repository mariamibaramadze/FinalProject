package pages;
//TEST CASE 6

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactusPage extends BasePage {
    private By IntouchVisible = By.xpath("//h2[text()='Get In Touch']");
    private By InputName = By.xpath("//input[@name='name']");
    private By InputEmail = By.xpath("//input[@name='email']");
    private By InputSubject = By.xpath("//input[@name='subject']");
    private By InputMessage = By.id("message");
    private By Fileupload =  By.xpath("//input[@name='upload_file']");
    private By SubmitButton = By.name("submit");
    private By successMessage = By.xpath("//div[contains(text(),'Success!')]");
    private By homeButton = By.xpath("//a[contains(.,'Home')]");


    public ContactusPage(WebDriver driver) {
        super(driver);
    }

    public boolean isIntouchVisible(){
        return visible(IntouchVisible);
    }
    public ContactusPage inputname(String inputName){
        type(InputName, inputName);
        return this;
    }
    public ContactusPage enteremail(String email){
        type(InputEmail, email);
        return this;
    }
    public ContactusPage subjectinput(String subject){
        type(InputSubject, subject);
        return this;
    }
    public ContactusPage messageinput(String message){
        type(InputMessage, message);
        return this;
    }

    public void uploadFile(String filePath){
        wait.until(ExpectedConditions.presenceOfElementLocated(Fileupload))
                .sendKeys(filePath);
    }
    public ContactusPage clickSubmitButton(){
        click(SubmitButton);
        return this;
    }
    public boolean isSuccessMessage(){
        return visible(successMessage);
    }
    public ContactusPage clickHomeButton(){
        click(homeButton);
        return this;
    }












}
