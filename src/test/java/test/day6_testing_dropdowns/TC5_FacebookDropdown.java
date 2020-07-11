package test.day6_testing_dropdowns;

import com.sun.source.tree.TryTree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC5_FacebookDropdown {
    //TC #4: Selecting value from multiple select dropdown
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown
    // 3.3.Click to non-select dropdown
    // 4.Select Facebook from dropdown
    // 5.Verify title is “Facebook -Log In or Sign Up”


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void close(){
        driver.close();
    }
    @Test
    public void test_dropdowns() throws Exception{
        WebElement dropdown=driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        dropdown.click();
        driver.findElement(By.xpath("//a[.='Facebook']")).click();

        Thread.sleep(2000);

        String actualTitle=driver.getTitle();
        String expectedTitle="Facebook - Log In or Sign Up";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}
