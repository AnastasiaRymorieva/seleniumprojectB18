package test.day10_jsexecurtor_upload_action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Uploading {
    @Test

    public void uploading_test() throws InterruptedException{
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        Driver.getDriver().manage().window().maximize();
        WebElement chooseFile=Driver.getDriver().findElement(By.id("file-upload"));
        Thread.sleep(2000);
        chooseFile.sendKeys("/Users/anastasiiarymorieva/Desktop/toyota-logo.jpg");
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.id("file-submit")).click();
        WebElement uploadedMessage=Driver.getDriver().findElement(By.xpath("//div[@class='example']/h3"));
        Assert.assertTrue(uploadedMessage.isDisplayed());
    }
}
