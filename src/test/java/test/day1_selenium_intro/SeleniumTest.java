package test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;
import java.util.WeakHashMap;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException{
        //1 set up the web driver
        WebDriverManager.chromedriver().setup();
        //2 create the instance of the chromedriver
        WebDriver driver=new ChromeDriver();
      //  driver.manage().window().maximize(); //maximizes the open page after opening it
        driver.manage().window().fullscreen();
        //3 test if driver is working
        driver.get("https://www.google.com");
        //BROWSER NAVIGATIONS
        Thread.sleep(2000); //adds two minutes of wait time
        driver.navigate().back(); //goes back to previous page
        Thread.sleep(2000);
        driver.navigate().forward();//goes forward to next page
        Thread.sleep(2000);
        driver.navigate().refresh();//refresh the page
        System.out.println("Title: "+driver.getTitle());
        System.out.println("URL: "+driver.getCurrentUrl());
       // System.out.println("Page Source "+driver.getPageSource());
driver.close();

    }
}
