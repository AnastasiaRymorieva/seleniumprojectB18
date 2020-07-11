package test.day8_alerts_iframes_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;

import java.util.concurrent.TimeUnit;

public class WebTablePractices {

    //PRACTICE #4: Method: verifyOrder
    // •Create a method named verifyOrder in SmartBearUtils class.
    // •Methodtakes WebDriver object and String(name).
    // •Methodshould verify if given name exists in orders.
    // •This method should simply accepts a name(String), and assert whether given name is in the list or not.
    // •Create a new TestNG test to test if the method is working as expected.
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void p4_verifyOrder_test(){
        SmartBearUtilities.login(driver);
        SmartBearUtilities.verifyOrder(driver,"Paul Brown");

    }
    @Test
    public void p5_printNames_and_Cities(){
        //Practice #5: Method: printNamesAndCities
        // •Create a method named printNamesAndCities in SmartBearUtils class.
        // •Method takes WebDriver object.
        // •This method should simply print all the names in the List of All Orders.
        // •Create a new TestNG test to test if the method is working as expected.
        // •Output should be like:
        // •Name1: name , City1: city
        // •Name2: name , City2: city
SmartBearUtilities.login(driver);
        SmartBearUtilities.printNamesAndCities(driver);

    }
}