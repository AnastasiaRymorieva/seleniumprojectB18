package test.day11_page_object_model;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.VyTrackForgottPassword;
import test.base.TestBase;
import test.day9_testbase_properties_driverUtilities.ConfigurationReader;
import utilities.Driver;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class Vytrack_Test extends TestBase {
    @Test

    public void forgot_password_verification() {
        //TC#35: Vytrack forgot password page verifications TITLE andURL
        // 1. Go to https://qa3.vytrack.com
        // 2. Click to “Forgot your password?”link
        // 3. Verify title changed to expectedExpected: “Forgot Password”
        // 4. Verify url is as expected:Expected: “https://qa3.vytrack.com/user/reset-request”Note: Follow Page Object Model design pattern

        test=report.createTest("TC35 Vytrack forgot password page verification Title");
        test.info("Go to https://qa3.vytrack.com");
        test.info("Click to “Forgot your password?”link");
        test.info("Verify title changed to expectedExpected: “Forgot Password”");
        test.info("Verify url is as expected:Expected: “https://qa3.vytrack.com/user/reset-request”");

      //  test.fail("TC35 test Failed");

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        Driver.getDriver().manage().window().maximize();
        LoginPage loginPage=new LoginPage();
        loginPage.forgotPassword.click();
        String expectedTitle="Forgot Password";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String expectedURL="https://qa2.vytrack.com/user/reset-request.";
        String acrualURL=Driver.getDriver().getCurrentUrl();


        Assert.assertEquals(expectedURL,acrualURL);
        test.pass("TC35 test Passed");
    }


    @Test

    public void tc36_request_button() {
        //TC#36: Vytrack forgot password page verification ERROR MESSAGE
        // 1.Go to https://qa3.vytrack.com/user/reset-request
        // 2.Enter random username
        // 3. Click to request button
        // 4. Verify error message is displayed
        // 5. Verify error message text is as expected.Expected: There is no active user with username or email address “given text”.Note: Follow Page Object Model design pattern

        test=report.createTest("TC#36: Vytrack forgot password page verification ERROR MESSAGE");
        test.info("Go to https://qa3.vytrack.com/user/reset-request");
        test.info("Enter random username");
        test.info("Click to request button”");
        test.info("Verify error message is displayed");
        test.info("Verify error message text is as expected.Expected: There is no active user with username or email address “given text”.Note: Follow Page Object Model design pattern");

       // test.fail("TC36 test Failed");

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        LoginPage loginPage=new LoginPage();
        loginPage.forgotPassword.click();
        VyTrackForgottPassword forgotUsername=new VyTrackForgottPassword();
        String username="hghjghj";
        forgotUsername.userName.sendKeys(username);
        forgotUsername.request.click();
        String actualErrorMessage=forgotUsername.errorMessage.getText();
        String errorTextExpected="There is no active user with username or email address \""+username+"\".";
        Assert.assertTrue(forgotUsername.errorMessage.isDisplayed());
        Assert.assertEquals(actualErrorMessage,errorTextExpected);
        test.pass("TC36 test Passed");

        Driver.getDriver().close();



    }
}
