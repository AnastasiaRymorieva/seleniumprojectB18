package test.day8_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Iframe_Practice {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/iframe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test

    public void iframe_practice_test() {
        //TC #4: Iframe practice
        // 1.Create a new class called: IframePractice
        // 2.Create new test and make set ups
        // 3.Go to: http://practice.cybertekschool.com/iframe
        // 4.Assert: “Your content goes here.” Text is displayed.
        // 5.Assert: “An iFrame containing the TinyMCEWYSIWYG Editor
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
    WebElement yourContent=driver.findElement(By.xpath("//p"));
        Assert.assertTrue(yourContent.isDisplayed());

      driver.switchTo().defaultContent();
      WebElement h3Text=driver.findElement(By.xpath("//h3"));
      Assert.assertTrue(h3Text.isDisplayed());

    }


}
