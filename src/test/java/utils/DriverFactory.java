package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void initDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Prefer explicit waits in BasePage. Keep implicit small or remove.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driverThreadLocal.set(driver);
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}
