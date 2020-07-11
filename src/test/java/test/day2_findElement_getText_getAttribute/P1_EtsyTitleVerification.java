package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_EtsyTitleVerification {

    public static void main(String[] args) {
        //TC #1: EtsyTitle Verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        // 2.Go to https://www.etsy.com
        driver.get("https://www.etsy.com");
        // 3.Search for “wooden spoon”
        driver.findElement(By.name("search_query")).sendKeys("wooden spoon"+ Keys.ENTER);
        // 4.Verify title: Expected: “Wooden spoon | Etsy”
        String actualTitle=driver.getTitle();
        String expectedTitle="Wooden spoon | Etsy";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Passed");
        }else {
            System.out.println("FAILED");
        }
       driver.close();
    }
}
