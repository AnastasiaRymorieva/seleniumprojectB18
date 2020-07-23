package test.day10_jsexecurtor_upload_action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.Methods;

public class HighlightingElement {


    @Test
    public void test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");
        WebElement element = Driver.getDriver().findElement(By.xpath("//h3[.='Dropdown List']"));
       Methods.highLightElement(element);
    }
}
