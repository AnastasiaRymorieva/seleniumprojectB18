package test.day8_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class WindowsTabsPractice {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/windows");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void p5_window_handle_practice(){

        String currentWindowHandle = driver.getWindowHandle();
      //  String currentWindowHandle2=driver.getWindowHandle();

        System.out.println("currentWindowHandle = " + currentWindowHandle);

        WebElement clickHereLink = driver.findElement(By.xpath("//a[.='Click Here']"));

        clickHereLink.click();

        for (String each:driver.getWindowHandles()){
            driver.switchTo().window(each);
            System.out.println(driver.getTitle());
        }




    }

}
