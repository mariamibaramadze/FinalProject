package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//TEST CASE 7
public class TestcasesPage extends BasePage{
    private By TestCaseVisible = By.xpath("//b[text()='Test Cases']");

    public TestcasesPage(WebDriver driver) {
        super(driver);
    }
    public boolean isTestcaseVisible(){
        return visible(TestCaseVisible);
    }

}
