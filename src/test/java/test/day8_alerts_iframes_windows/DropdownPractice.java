package test.day8_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownPractice {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
       driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void p7_month_dropdown_default_value_test(){
        //Locating dropdown


        Select monthDropdown=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        //We need to create our actual and expected values
        String actualDropdown=monthDropdown.getFirstSelectedOption().getText();
        String expectedDropdown= LocalDateTime.now().getMonth().name();

        //1st Way
        Assert.assertEquals(actualDropdown.toLowerCase(),expectedDropdown.toLowerCase());
        //2st Way
        Assert.assertTrue(actualDropdown.equalsIgnoreCase(expectedDropdown));


        // 2.Verify list of months are correct as expected.
        // Expected: Options should contain all 12 months of the year

        List<String> expectedMonths= Arrays.asList("January","February","March","April","May","June","July","August","September","October","November","December");
        List<WebElement> actualDropdownOptions=monthDropdown.getOptions();

        List<String> actualMonthText=new ArrayList<>();

        for (WebElement each : actualDropdownOptions) {
            actualMonthText.add(each.getText());
        }

        Assert.assertEquals(actualMonthText,expectedMonths);


    }
}
