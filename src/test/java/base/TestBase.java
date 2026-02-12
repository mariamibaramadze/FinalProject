package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;


public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver(); // ← THIS LINE IS IMPORTANT
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
