package test.day10_jsexecurtor_upload_action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class ActionsTests {
    @Test

    public void hover_over_test1() {
       Driver.getDriver().get("https://amazon.com");
       Driver.getDriver().manage().window().maximize();
        Actions actions=new Actions(Driver.getDriver());

        WebElement languageOptions=Driver.getDriver().findElement(By.id("icp-nav-flyout"));
        actions.moveToElement(languageOptions).perform();
    }
    @Test

    public void tc15_hover_test() {
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
        Driver.getDriver().manage().window().maximize();
        Actions actions=new Actions(Driver.getDriver());

        WebElement img1=Driver.getDriver().findElement(By.xpath("//div[@class='figure'][1]"));
        WebElement img2=Driver.getDriver().findElement(By.xpath("//div[@class='figure'][2]"));
        WebElement img3=Driver.getDriver().findElement(By.xpath("//div[@class='figure'][3]"));

        WebElement user1=Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2=Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3=Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        actions.moveToElement(img1).perform();
        Assert.assertTrue(user1.isDisplayed());

        actions.moveToElement(img2).perform();
        Assert.assertTrue(user2.isDisplayed());

        actions.moveToElement(img3).perform();
        Assert.assertTrue(user3.isDisplayed());

    }
}
