package test.day2_findElement_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleTitleVerification {
    public static void main(String[] args) {

      //  TC#4:	Google	search
       // 1-Open	a	chrome	browser
        //for manual import Windows: alt+enter MAC: option+enter
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
      //  2-Go	to:	https://google.com

        driver.get("https://www.google.com");

       // 3-Write	“apple”	in	search	box
        driver.findElement(By.name("q")).sendKeys("apple"+ Keys.ENTER);
       // driver.findElement(By.name("q")).sendKeys("apple");
      //  4-Click	google	search	button
      //  driver.findElement(By.name("btnK")).click();
      //  5-Verify	title:Expected:	Title	should	start	with	“apple" word
        String actualResult=driver.getTitle();
        String expectedResult="apple";
        if(actualResult.startsWith(expectedResult)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }




    }
}
