package test.day11_page_object_model;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import test.day9_testbase_properties_driverUtilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class PositiveLoginTest {
    @Test

    public void store_manager_login_test() {
        //TC#32 : Vytrack positive login testà
        // Sales Manager
        // 1. Go to https://qa3.vytrack.com
        // 2. Enter correct username
        // 3. Enter correct password
        // 4. Verify title changedExpected: “Dashboard”

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        LoginPage loginPage=new LoginPage();
        loginPage.login(ConfigurationReader.getProperty("storemanager_username"),ConfigurationReader.getProperty("storemanager_password"));
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10L);

        String actualTitle="Dashboard";
        String expectedTitle=Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }
}
