package uitests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import utils.DriverFactory;

public class ProductsVerificationTest extends TestBase {

    @Test
    public void verifyProductDetailsAreVisible() {

        DriverFactory.getDriver().get("https://automationexercise.com/");

        HomePage homePage = new HomePage(DriverFactory.getDriver());

        Assert.assertTrue(
                homePage.isSliderPresent(),
                "Home page is not visible"
        );

        ProductsPage productsPage = homePage.clickProductsButton();

        Assert.assertTrue(
                productsPage.isAllProductsVisible(),
                "ALL PRODUCTS page not visible"
        );

        Assert.assertTrue(
                productsPage.isProductListVisible(),
                "Products list is not visible"
        );

        productsPage.clickFirstViewProduct();

        Assert.assertTrue(productsPage.isProductNameVisible(), "Product name not visible");
        Assert.assertTrue(productsPage.isCategoryVisible(), "Category not visible");
        Assert.assertTrue(productsPage.isPriceVisible(), "Price not visible");
        Assert.assertTrue(productsPage.isAvailabilityVisible(), "Availability not visible");
        Assert.assertTrue(productsPage.isConditionVisible(), "Condition not visible");
        Assert.assertTrue(productsPage.isBrandVisible(), "Brand not visible");
    }
}
