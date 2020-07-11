package test.day4_FindElements_checkbox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P01_MeriamWebster_FindElements {
    public static void main(String[] args) {
        //TC #0: FINDELEMENTS
        // 1.Open Chrome browser
        WebDriver driver=WebDriverFactory.getDriver("chrome");
driver.manage().window().maximize();

        // 2.Go to https://www.merriam-webster.com/
        driver.get("https://www.merriam-webster.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //wait 15 seconds or when every element will load
        // 3.Print out the texts of all links
       List<WebElement> listOfLinks= driver.findElements(By.xpath("//body//a"));
       int linksWithoutText=0;
       int linksWithText=0;
       for (WebElement link:listOfLinks){
           String textOfEachLink=link.getText();
          // System.out.println(link.getText());
           if(textOfEachLink.isEmpty()){
               linksWithoutText+=1;
           }else{
               System.out.println(link.getText());
               linksWithText+=1;
           }
       }

        // 4.Print out how many link is missing text
        System.out.println("Number of missing text links: "+linksWithoutText);
        // 5.Print out how many link has text
        System.out.println("Number of text links: "+linksWithText);
        // 6.Print out how many total link
        System.out.println("Total links:"+(listOfLinks.size()));


    }

}
//   //body//a    relative path to find all links