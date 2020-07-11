package test.day6_testing_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class TestNGSeleniumPractice {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
       driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");

    }
    @AfterMethod
    public void close(){
        driver.close();
    }
    @Test
    public void google_title_test(){
        //1- Go to: https://www.google.com

        //2- Verify title : Google
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        //The line where we do assertion
        //If you use assertTrue,
        //  argument you are passing is supposed to be returning boolean
        Assert.assertTrue(actualTitle.equals(expectedTitle));

        //If you are using assertEquals,
        // you need to pass two arguments of the same type
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void google_search_title_verification(){
        //1)open browser
        //2)go to https://google.com
        //3)search "apple"
        WebElement appleSearchBox=driver.findElement(By.name("q"));
        appleSearchBox.sendKeys("apple"+ Keys.ENTER);
        //4)verify title contains "apple"
        Assert.assertTrue(driver.getTitle().contains("apple"));
        //5)close browser

    }
}
