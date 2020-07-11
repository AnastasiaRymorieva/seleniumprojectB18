package test.day12_synchronization;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dynamic_Title;
import utilities.Driver;

public class ExplicitWaitPractices {
    //TC#40: Dynamically Loaded Page Elements 71.
    // Go to http://practice.cybertekschool.com/dynamic_loading/7
    // 2.Wait until title is “Dynamic Title”
    // 3.Assert : Message “Done” is displayed.
    // 4.Assert : Image is displayed.

    @Test

    public void dynamic_title_test() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        Dynamic_Title elements=new Dynamic_Title();
        wait.until(ExpectedConditions.visibilityOf(elements.doneMessage));

        Assert.assertTrue(elements.image.isDisplayed());

    }


}
