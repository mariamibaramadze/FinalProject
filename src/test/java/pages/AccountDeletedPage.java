package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletedPage extends BasePage {

    private By accountDeletedText = By.xpath("//*[@data-qa='account-deleted']");


    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountDeletedVisible() {
        return visible(accountDeletedText);
    }
}
