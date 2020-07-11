package test.day3_cssSelctor_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_ZeroBankURLVerification {
    public static void main(String[] args) {
        //TC #4: Zero Bank URLverification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        // 3.Get attribute value of href from the “forgot your password”link
        WebElement forgotPasswordLink=driver.findElement(By.partialLinkText("Forgot"));
        System.out.println("Is forgot password is displyed? "+forgotPasswordLink.isDisplayed());

        // 4.Verify attribute value containsExpected: “/forgot-password.html”
        String actualHrefValue=forgotPasswordLink.getAttribute("href");
        String expectedHrefValue="/forgot-password.html";
        System.out.println("actualHrefValue = "+actualHrefValue);
        if (actualHrefValue.contains(expectedHrefValue)) {
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }
        driver.close();
    }
}
