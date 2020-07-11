package test.day6_testing_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class DropDowns_Intro {
    /*
    TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
    1.Open Chrome browser
    2.Go to http://practice.cybertekschool.com/dropdown

     */

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test1_default_value_verification(){

        // 3.Verify “Simple dropdown” default selected value is correctExpected: “Please select an option”
        Select simpleDropdown=new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        String actualDefaultofSimpleDropdown=simpleDropdown.getFirstSelectedOption().getText();
        String expectedDefaultOfSimpleDropdown="Please select an option";
        Assert.assertEquals(actualDefaultofSimpleDropdown,expectedDefaultOfSimpleDropdown);
   // 4.Verify“State selection” default selected value is correctExpected: “Select a State”
        Select stateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String actualDefaultOfState=stateDropdown.getFirstSelectedOption().getText();
        String expectedDefaultOfState="Select a State";
        Assert.assertEquals(actualDefaultOfState,expectedDefaultOfState);

    }
    @Test
    public void test2_state_dropdown_verification() throws InterruptedException{
       /* TC #2: Selecting state from State dropdown and verifying result 1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/dropdown
        3. Select Illinois
        4. Select Virginia
        5. Select California
        6. Verify final selected option is California.
        Use all Select options. (visible text, value, index)

        */
        Select stateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        Thread.sleep(1000);
        stateDropdown.selectByValue("IL");
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Virginia");
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);

        String expectedSelectedValue="California";
        String actualSelectedState=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelectedState,expectedSelectedValue);
    }

}
