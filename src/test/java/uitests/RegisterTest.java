package uitests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.SignupPage;
import utils.DriverFactory;
@Test
public class RegisterTest extends TestBase {

    public void RegisterTest(){
        DriverFactory.getDriver().get("https://automationexercise.com/");
        HomePage home = new HomePage(DriverFactory.getDriver());

        SignupPage signup = home.clickLoginButton();
        Assert.assertTrue(signup.isNewUserVisible(), "new user is not Visible ");

        signup.enterName("magariproeqti")
                .enterEmail("dzlivsmovrchit@gmail.com")
                .clickSignUpButton();

        RegisterPage register = new RegisterPage(DriverFactory.getDriver());
        Assert.assertTrue(register.isVisibleAccountInfo(), " This Page is not Visible ");

        register.selectTitleMrs()
                .enterPassword("pslplspls")
                .setDOB("5","January","2018")
                .selectNewsletter()
                .selectOffers()
                .enterFirstName("TA")
                .enterLastName("BlackSea")
                .enterCompany("BDO")
                .enterAddress1("aghmashenebeli 13")
                .enterAddress2("vake vake")
                .selectCountry("Canada")
                .enterState("Toronto")
                .enterCity("Toronto")
                .enterZipCode("4600")
                .enterMobileNumber("5555555")
                .clickCreateAccount();

        Assert.assertTrue(register.isAccountCreatedVisible(), " Account is not visible ");

        register.clickContinue();

        Assert.assertTrue(register.isLoggedInVisible(), "  not visible ");

        register.clickDeleteAccount();
        Assert.assertTrue(register.isAccountDeletedVisible(), "  not visible ");

        register.clickContinue();










    }



}
