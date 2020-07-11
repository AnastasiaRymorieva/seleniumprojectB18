package test.day3_cssSelctor_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_CybertekURLVerification {
    public static void main(String[] args) {
        // TC #3: PracticeCybertek/ForgotPassword URL verification
        //  1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        //2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
        // 3.Enter any email into input box
       WebElement emailInput= driver.findElement(By.name("email"));
       emailInput.sendKeys("anyemail@gmail.com");
        // 4.Click on Retrieve password
       WebElement retrievePassword= driver.findElement(By.id("form_submit"));
       retrievePassword.click();
        // 5.Verify URL contains: Expected: “email_sent”
        String actualURL=driver.getCurrentUrl();
        String expect="email_sent";
        if (actualURL.endsWith(expect)){
            System.out.println("URL Verification test : PASSED");
        }else {
            System.out.println("URL Verification test : FAILED");
        }
        // 6.Verify textbox displayed the content as expected.Expected: “Your e-mail’s been sent!”
        WebElement emailSentBox=driver.findElement(By.name("confirmation_message"));
       String actualTextBox= emailSentBox.getText();
       String expectedTextBox="Your e-mail's been sent!";
       if(actualTextBox.equals(expectedTextBox)){
           System.out.println("Text Box Verification Test: PASSED ");
       }else {
           System.out.println("Text Box Verification Test: FAILED ");
       }
       if(emailSentBox.isDisplayed()){
           System.out.println("Displayed");
       }
        driver.close();
    }
}
