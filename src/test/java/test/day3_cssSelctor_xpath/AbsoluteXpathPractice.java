package test.day3_cssSelctor_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class AbsoluteXpathPractice {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(("http://practice.cybertekschool.com/multiple_buttons"));
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/button[2]")).click();
               
}
}
