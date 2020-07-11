package test.day11_page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.Driver;
@Listeners(ListenerTest.class)
public class TestCases {
    WebDriver driver= Driver.getDriver();
    @Test
    public void Login(){
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/V4/");
        driver.findElement(By.name("uid")).sendKeys("mngr34926");
        driver.findElement(By.name("password")).sendKeys("amUpenu");
        driver.findElement(By.name("btnLogin")).click();
    }

    @Test
    public void TestToFail(){
        System.out.println("This method to test fail");
        Assert.assertTrue(false);

        WebDriver driver=new ChromeDriver();
    }
}
