package test.day8_alerts_iframes_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AlertsPractices {
    /*
TC #1: Information alert practice
1.Open browser
2.Go to website:
http://practice.cybertekschool.com/javascript_alerts
3.Click to "Click for JS Alert"button
4.Click to OK button from the alert
5.Verify "You successfulyclicked an alert"text is displayed.
 */

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test(){

        WebElement infoAlertButton=driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        infoAlertButton.click();

        Alert alert=driver.switchTo().alert();

        alert.accept();

       WebElement resultText=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultText.isDisplayed());

    }

    @Test
    public void p2_confirmation_alert_test() {
        WebElement confirmationAlertButton=driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmationAlertButton.click();

        Alert alert=driver.switchTo().alert();


        alert.dismiss();
        WebElement result2=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(result2.isDisplayed());

        List<String> list= Arrays.asList("A","B","C");
        ArrayList<String> list2=new ArrayList<>();
        list=list2;

    }


}
