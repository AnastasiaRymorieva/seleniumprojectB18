package test.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import test.day9_testbase_properties_driverUtilities.ConfigurationReader;
import utilities.BrowserUtils;
import utilities.WebDriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;



public abstract class TestBase {
    protected WebDriver driver;
    protected ExtentReports report;
    private ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeSuite
public void setUpSuite(){
        report=new ExtentReports();
        String path=System.getProperty("user.dir")+"/test-output/report.html";
        htmlReporter=new ExtentHtmlReporter(path);

        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("Vytrack Automated Tests");
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
    }

    @AfterSuite
    public void tearDownSuite(){
        report.flush();
    }

    @BeforeMethod
    public void setUpMethod() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDownMethod(ITestResult iTestResult) throws InterruptedException, IOException {
        //ITestResult class from TestNG gives information about current test:name status
        //check if the test failed
        if(iTestResult.getStatus()==ITestResult.FAILURE){
            //tell extent report that the test failed
            test.fail(iTestResult.getName());
            //take screen shot of the screen and location
        String screenshot=BrowserUtils.getScreenshot(iTestResult.getName());

        //show path to screenshot
        test.addScreenCaptureFromPath(screenshot);
        }
        driver.quit();
    }
}
