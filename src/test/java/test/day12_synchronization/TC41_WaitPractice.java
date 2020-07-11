package test.day12_synchronization;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoading;
import utilities.Driver;

public class TC41_WaitPractice {
    //TC#41: Dynamically Loaded Page Elements
    // 11.Go to http://practice.cybertekschool.com/dynamic_loading/1
    // 2.Click to start
    // 3.Wait until loading bar disappears
    // 4.Assert username inputboxis displayed
    // 5.Enter username: tomsmith
    // 6.Enter password: incorrectpassword
    // 7.Click to Submit button
    // 8.Assert “Your username is invalid!” text is displayed.

    @Test

    public void tc41_dynamically_page_elements() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");
        DynamicLoading elements=new DynamicLoading();
        elements.startButton.click();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(elements.loadingText));
        Assert.assertTrue(elements.username.isDisplayed());
        elements.username.sendKeys("tomsmith");
        elements.password.sendKeys("incorrectpassword");
        elements.submitButton.click();

        Assert.assertTrue(elements.errorMessage.isDisplayed());

    }
}
