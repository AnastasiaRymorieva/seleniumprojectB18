package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_Back_and_Forth_Navigation {
    public static void main(String[] args) {
        //TC #3: Back and forth navigation

        // 1-Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        // 2-Go to: https://google.com3-Click to Gmail from top right.
        driver.findElement(By.linkText("Gmail")).click();
        // 4-Verify title contains:Expected: Gmail
        String actualTitle=driver.getTitle();
        String expectedTitle="Gmail";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        // 5-Go back to Google by using the .back();
        driver.navigate().back();
        // 6-Verify title equals:Expected: Google
        String actualTitle2=driver.getTitle();
        String expectedTitle2="Google";
        if (actualTitle2.equals(expectedTitle2)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        driver.quit();
        //pkill -9 Chrome (in Terminal) => Closes all Chrome Browsers
    }
}
