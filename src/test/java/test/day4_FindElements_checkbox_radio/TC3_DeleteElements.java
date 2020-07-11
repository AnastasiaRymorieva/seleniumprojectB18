package test.day4_FindElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class TC3_DeleteElements {
    //TC #3: PracticeCybertek.com_AddRemoveElements WebElement verification
    // 1. Open Chrome browser
    // 2. Go to http://practice.cybertekschool.com/add_remove_elements
    // 3. Click to “Add Element” button 50 times
    // 4. Verify 50 “Delete” button is displayed after clicking.
    // 5. Click to ALL “Delete” buttons to delete them.
    // 6. Verify “Delete” button is NOT displayed after clicking. USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS Hint: Need to use findElements method.
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        driver.manage().window().maximize();
        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i = 1; i <= 50; i++) {
            addButton.click();
        }
        List<WebElement> list = driver.findElements(By.xpath("//button[@class='added-manually']"));

        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        System.out.println("Located Delete elements " + list.size());
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }

        for (WebElement each : list) {
            each.click();
        }

        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }

        try {
            if (!deleteButton.isDisplayed()) {
                System.out.println("Delete button is NOT displayed after clicking. PASS!");
            } else {
                System.out.println("Delete button is displayed after clicking. FAILED!");
            }
        } catch (StaleElementReferenceException exception) {
            System.out.println("StaleElementException has been thrown.");
            System.out.println("Button is not displayed. Verification passed");
            driver.close();

        }

    }

}




