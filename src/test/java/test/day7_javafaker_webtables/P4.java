package test.day7_javafaker_webtables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P4 {
    //TC #4: Selecting value from multiple select dropdown
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown
    // 3.Select all the options from multiple select dropdown.
    // 4.Print out all selected values.
    // 5.Deselect all values.
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void close(){
        driver.close();
    }
    @Test
    public void test_multiple_dropdowns(){
        Select multipleDropdowns=new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        for (int i=0;i<=5;i++){
            multipleDropdowns.selectByIndex(i);
        }
        System.out.println(multipleDropdowns.getOptions());
        multipleDropdowns.deselectAll();

    }
}
