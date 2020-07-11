package test.day6_testing_dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC3_Practice {
    //TC #3: Selecting date on dropdown and verifying
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown
    // 3.Select “December 1st, 1921” and verify it is selected.
    // Select year using: visible textSelect
    // month using : value attribute
    // Select day using: index number
WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void select_date(){
        Select yearDropdown=new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown=new Select(driver.findElement(By.xpath("//select[@id='day']")));
        yearDropdown.selectByVisibleText("1921");
        monthDropdown.selectByValue("11");
        dayDropdown.selectByIndex(0);

        String yearExpected="1921";
        String monthExpected="December";
        String dayExpected="1";

        String yearActual=yearDropdown.getFirstSelectedOption().getText();
        String monthActual=monthDropdown.getFirstSelectedOption().getText();
        String dayActual=dayDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(yearActual,yearExpected);
        Assert.assertEquals(monthActual,monthExpected);
        Assert.assertEquals(dayActual,dayExpected);

    }
    @AfterMethod
    public void close(){
        driver.close();
    }
}
