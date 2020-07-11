package test.day8_alerts_iframes_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class P9_SmartBearDeleteOrder {
    //TC #9: SmartBear delete order
    // 1.Open browser and login to SmartBear
    // 2.Delete “Mark Smith” from the list
    // 3.Assert it is deleted from the list
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);

    }

    @Test

    public void test_delete_order() {
        List<WebElement> list = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        list.removeIf(p -> p.equals("Mark Smith"));
        Assert.assertTrue(!list.contains("Mark Smith"));

    }

    @Test
    public void test_edit() {
        //Click to edit button from the right for “Steve Johns”
        // 3.Change name to “Michael Jordan”
        // 4.Click Update
        // 5.Assert “Michael Jordan” is in the list

        driver.findElement(By.xpath("//td[.='Steve Johns']/following-sibling::td[11]")).click();

        WebElement nameEdit = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        nameEdit.clear();
        nameEdit.sendKeys("Michael Jordan");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // SmartBearUtilities.verifyOrder(driver,"Michael Jordan");

        List<WebElement> names = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        for (WebElement each : names) {


            if (each.getText().equals("Michael Jordan")) {

                Assert.assertTrue(true);
                return;
            }

        }
        Assert.fail("Name doesn't exist in the list");

    }

    @Test
    public void test_remove() {
        //TC #11: Create a method called removeName()
        // 1.Accepts two parameters: WebDriver, String name
        // 2.Method will remove the given name from the list of Smartbear
        // 3.Create a new TestNG test, and call your method.
        // 4.Assert that your method removed the given name
        String name="Paul Brown";
        SmartBearUtilities.removeName(driver, name);
        List<WebElement> names = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        for (WebElement each:names){
            Assert.assertTrue(!each.getText().equals(name));
            System.out.println(each.getText());
        }

    }
}