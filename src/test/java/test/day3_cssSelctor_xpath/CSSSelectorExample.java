package test.day3_cssSelctor_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class CSSSelectorExample {
    public static void main(String[] args) throws Exception{
       WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        WebElement searchElement=driver.findElement(By.cssSelector("input[tabindex='19']"));

        searchElement.sendKeys("wooden spoon"+ Keys.ENTER);
        Thread.sleep(2000);
        String actualTitle=driver.getTitle();
        String expectedTitle="wooden spoon";

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title Verification PASSED" );
        }else {
            System.out.println("Title Verification FAILED" );
        }
        driver.close();
    }
}

