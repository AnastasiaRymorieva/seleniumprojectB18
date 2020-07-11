package test.day11_page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import test.day9_testbase_properties_driverUtilities.ConfigurationReader;
import utilities.Driver;

public class NegativeLoginTests {
    @Test
    public void negative_login_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        WebElement usernameInput=Driver.getDriver().findElement(By.id("prependedInput"));
        WebElement usernamePassword=Driver.getDriver().findElement(By.id("prependedInput2"));
        WebElement loginButton=Driver.getDriver().findElement(By.id("_submit"));

        usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager_username"));
        usernamePassword.sendKeys("gfghfhgfgh");

        loginButton.click();
        WebElement errorMessage=Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));

        Assert.assertTrue(errorMessage.isDisplayed(),"Assert message is Not displayed");


    }

    @Test
    public void negative_login_test2_with_page_object(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        LoginPage loginPage=new LoginPage();
        String username=ConfigurationReader.getProperty("storemanager_username");

        loginPage.usernamePassword.sendKeys(username);
        loginPage.usernamePassword.sendKeys("gjgjhg");
        loginPage.loginButton.click();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        String actualText="Invalid user name or password.";
        Assert.assertEquals(actualText,loginPage.errorMessage.getText());

    }

    @Test

    public void tc31_wrong_username_test() {
        //TC#31: Vytrack negative login test
        // Wrong Username Test
        // 1. Go to https://qa3.vytrack.com
        // 2. Enter incorrectusername
        // 3. Enter correctpassword
        // 4. Verify error message text is as expected
        // Expected: “Invalid user name or password.”Note: Follow Page Object Model design pattern

        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        Driver.getDriver().manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        loginPage.login("jfhgfhj",ConfigurationReader.getProperty("storemanager_password"));

        //asserting error message IS DISPLAYED
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
//asserting the TEXT VALUE of the error message
        String actualText = loginPage.errorMessage.getText();
        String expectedText = "Invalid user name or password.";
        Assert.assertEquals(actualText, expectedText);


    }
}
