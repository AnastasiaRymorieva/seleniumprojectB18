package test.day9_testbase_properties_driverUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class DriverUtilsPractice {
    @Test
    public void driverPractice(){
        Driver.getDriver().get("https://www.google.com");
        WebElement googleSearch=Driver.getDriver().findElement(By.name("q"));
        googleSearch.sendKeys(ConfigurationReader.getProperty("testdata")+ Keys.ENTER);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(ConfigurationReader.getProperty("testdata")));
    }
}
