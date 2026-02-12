package uitests;
//TEST CASE 7
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestcasesPage;
import utils.DriverFactory;
@Test
public class TestcaseTest extends TestBase {

    public void testcaseTest(){
        DriverFactory.getDriver().get("https://automationexercise.com/");

        HomePage home1 = new HomePage(DriverFactory.getDriver());
        TestcasesPage TestcaseTest = home1.clickTestcaseButton();

        Assert.assertTrue(TestcaseTest.isTestcaseVisible(),
                " This Page is not Visible ");

    }
}
