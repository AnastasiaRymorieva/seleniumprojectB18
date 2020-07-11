package test.day10_jsexecurtor_upload_action;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class StalePractice {
    @Test

    public void test_popup() {

       WebDriver driver= Driver.getDriver();
       driver.get(("https://the-internet.herokuapp.com/entry_ad"));
        driver.manage().window().maximize();
       // String close = "//div[@id='modal']//div[@class='modal']//div[@class='modal-footer']//p[contains(text(),'Close')]";
        String close="//div[@class='modal-footer']/p";
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(close))));


      WebElement button= driver.findElement(By.xpath(close));
button.click();

        driver.get(driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

       // retryClickElement(close, driver);

        for(int i=0;i<=2;i++) {
            try{

driver.findElement(By.xpath(close)).click();

break;

        }

        catch(Exception e)
        {
            System.out.println("Error");
        }

        }
     //   button.click();




    }
    public static void retryClickElement(String locator, WebDriver driver) {

        //variable to count the attempts
        int attempts = 0;

        //number of times this code should get executed
        while(attempts < 2) {

            try {

                //wait explicitly till desired element is visible and clickable
                WebDriverWait wait = new WebDriverWait(driver, 30L);
               // wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(locator))));

                //click on the locator once it is found and terminate the loop
                driver.findElement(By.xpath(locator)).click();
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }

    }
}
