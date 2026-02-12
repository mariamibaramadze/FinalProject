package uitests;
// TEST CASE 3
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupPage;
import utils.DriverFactory;
@Test
public class SignupTest extends TestBase {

    public void signupTest(){
        DriverFactory.getDriver().get("https://automationexercise.com/");

        HomePage home = new HomePage(DriverFactory.getDriver());
        SignupPage signupPage = home.clickLoginButton();// am sign up obieqtit vukavshirdebi signupPages da yvela funqciaze maq wvdoma

        Assert.assertTrue(signupPage.isLoginVisible(), " This Page is not Visible ");

        signupPage.EnterEmailAddress("Gauqmebulia@mail.ru")
                .EnterPassword("TAmagaria")
                .clickLoginButton();

        Assert.assertTrue(signupPage.VisibleTextError(), " 'Your email or password is incorrect!' is not visible ");











    }
}
