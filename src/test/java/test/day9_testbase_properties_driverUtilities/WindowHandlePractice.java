package test.day9_testbase_properties_driverUtilities;


import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.base.TestBase;
import java.util.Set;
public class WindowHandlePractice extends TestBase {



    @Test

    public void multiple_window_test() {
        driver.get("https://www.amazon.com");
        //we are downcasting our driver to JavaScriptExecutor to be able to use its methods
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        Set<String> windowHandles=driver.getWindowHandles();

        for (String eachHandle:windowHandles){
            driver.switchTo().window(eachHandle);
            if(driver.getCurrentUrl().contains("etsy")){
                Assert.assertTrue(driver.getTitle().contains("Etsy"));
                break;
            }

        }

    }

    @BeforeMethod
    @Override
    public void setUpMethod() {
        super.setUpMethod();
    }


}
