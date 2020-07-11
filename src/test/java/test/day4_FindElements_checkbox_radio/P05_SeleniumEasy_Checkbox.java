package test.day4_FindElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class P05_SeleniumEasy_Checkbox {
    public static void main(String[] args) {
        //TC #2: SeleniumEasy Checkbox Verification – Section 1
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //1. Open Chrome browser
        //2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html ");
        //3. Verify "Success – Check box is checked" message is NOT displayed.
        WebElement successMessage=driver.findElement(By.xpath("//div[@id='txtAge']"));
        WebElement checkbox=driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        if(!successMessage.isDisplayed()&&!checkbox.isSelected()){
            System.out.println("Success message Test: PASSED");
        }else{
            System.out.println("Success message Test: FAILED");
        }

        //4. Click to checkbox under "Single Checkbox Demo" section
        checkbox.click();
        //5. Verify "Success – Check box is checked" message is displayed.
        if(successMessage.isDisplayed()&&checkbox.isSelected()){
            System.out.println("Success message Test: PASSED");
        }else{
            System.out.println("Success message Test: FAILED");
        }
    }
}
