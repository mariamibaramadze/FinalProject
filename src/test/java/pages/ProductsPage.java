package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {


    private By allProductsTitle =
            By.xpath("//h2[normalize-space()='All Products']");

    private By productList = By.xpath("//div[@class='features_items']");

    private By firstViewProductButton =
            By.xpath("(//a[contains(@href,'/product_details/')])[1]");


    private By productName = By.cssSelector(".product-information h2");
    private By category = By.xpath("//div[@class='product-information']/p[contains(text(),'Category')]");
    private By price = By.cssSelector(".product-information span span");
    private By availability =
            By.xpath("//div[@class='product-information']//p[b[contains(text(),'Availability')]]");

    private By condition =
            By.xpath("//div[@class='product-information']//p[b[contains(text(),'Condition')]]");

    private By brand =
            By.xpath("//div[@class='product-information']//p[b[contains(text(),'Brand')]]");



    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAllProductsVisible() {
        return visible(allProductsTitle);
    }

    public boolean isProductListVisible() {
        return visible(productList);
    }

    public void clickFirstViewProduct() {
        click(firstViewProductButton);
    }

    public boolean isProductNameVisible() {
        return visible(productName);
    }

    public boolean isCategoryVisible() {
        return visible(category);
    }

    public boolean isPriceVisible() {
        return visible(price);
    }

    public boolean isAvailabilityVisible() {
        return visible(availability);
    }

    public boolean isConditionVisible() {
        return visible(condition);
    }

    public boolean isBrandVisible() {
        return visible(brand);
    }
}
