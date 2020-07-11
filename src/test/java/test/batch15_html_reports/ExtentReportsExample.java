package test.batch15_html_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.StandardSocketOptions;

public class ExtentReportsExample {
    //used to set up a new report and  build the reports
    ExtentReports report;
    //used to create html report
    ExtentHtmlReporter htmlReporter;
    //used to define a test in report, do logging mark test results
    ExtentTest test;

    @BeforeMethod
    public void setUp(){
        //initialize the report
        report=new ExtentReports();

        //I need to point the location where report will be created
        String path=System.getProperty("user.dir")+"/test-output/report.html";
        htmlReporter=new ExtentHtmlReporter(path);

        //attach the html reporter to  the report object
        report.attachReporter(htmlReporter);
        //set name for the report
        htmlReporter.config().setReportName("Vytrack Automated Tests");
        //set environment info
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser","Chrome");
    }

    @AfterMethod
    public void tearDown(){
        //the report will be created when we call this line
        report.flush();
    }

    @Test(description = "Title test verification")

    public void test() {
        //we have to create test for every testcase
        test=report.createTest("VYT-123 Title verification test");
        test.info("Opening browser");
        //driver=new ChtomeDriver
        test.info("going to website");
        //driver.get(google.com);
        test.info("Verifying title");
        //assertEquals(google,google)
        test.pass("VYT-123 Title verification test");

    }
    @Test
    public void test2() {
        //we have to create test for every testcase
        test=report.createTest("VYT-124 URL verification test");
        test.info("Opening browser");
        //driver=new ChtomeDriver
        test.info("going to website");
        //driver.get(google.com);
        test.info("Verifying title");
        //assertEquals(google,google)
        test.pass("VYT-124 Title verification test");

    }
}
