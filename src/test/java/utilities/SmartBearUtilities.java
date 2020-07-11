package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SmartBearUtilities {
    public static void login(WebDriver driver) {

        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

    }


    public static void verifyOrder(WebDriver driver, String name) {
    /*
    @param Webdriver, String name
    •Create a method named verifyOrder in SmartBearUtils class.
    •Methodtakes WebDriver object and String(name).
    •Methodshould verify if given name exists in orders.
    •This method should simply accepts a name(String), and assert whether given name is in the list or not.
    •Create a new TestNG test to test if the method is working as expected.
     */
        List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        for (WebElement each : nameList) {
if(each.getText().equals(name)){
    Assert.assertTrue(true);
    return;
}
Assert.fail("The name does not exist! Verification failed!");
        }
    }

    public static void printNamesAndCities(WebDriver driver){
        List<WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        List<WebElement> citiesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[7]"));

        for (int i=0;i<nameList.size();i++){
            System.out.println("Name "+(i+1)+": "+nameList.get(i).getText()+" ,City "+(i+1)+": "+citiesList.get(i).getText());
        }
    }

    public static void removeName(WebDriver driver,String name){
        // 2.Method will remove the given name from the list of Smartbear
       WebElement checkbox= driver.findElement(By.xpath("//td[.='"+name+"']/preceding-sibling::td"));
       checkbox.click();
       driver.findElement(By.xpath("//input[@id='ctl00_MainContent_btnDelete']")).click();





    }
}