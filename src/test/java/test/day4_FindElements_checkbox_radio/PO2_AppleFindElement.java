package test.day4_FindElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PO2_AppleFindElement {
    public static void main(String[] args) {
        //TC #02: FINDELEMENTS_APPLE
        // 1.Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // 2.Go to https://www.apple.com
        driver.get("https://www.apple.com");
        // 3.Click to iPhone
driver.findElement(By.xpath("//span[.='iPhone']/..")).click();

        // 4.Print out the texts of all links
        List<WebElement> links=driver.findElements(By.xpath("//body//a"));
        // 5.Print out how many link is missing text
        // 6.Print out how many link has text
        int countMissing=0;
        int countText=0;
        for (WebElement listOfAllLinks:links){
            String link=listOfAllLinks.getText();
            if (link.isEmpty()){
                countMissing++;
            }else{
                System.out.println(listOfAllLinks.getText());
                countText++;
            }

        }
        System.out.println("Empty Links: "+countMissing);
        System.out.println("Links with text: "+countText);

        // 7.Print out how many total link
        System.out.println("Total links: "+links.size());
    }
    // xpath for iphone= //span[.='iPhone']/..
    //                   //tag[.='text']
    //                   //a[@class='ac-gn-link ac-gn-link-iphone']
    //                   //a[@href='/iphone/']
}
