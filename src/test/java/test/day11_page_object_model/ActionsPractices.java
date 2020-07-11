package test.day11_page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

import java.awt.*;

public class ActionsPractices {
    @Test

    public void scrolling_with_actions() {
        Driver.getDriver().get("http://practice.cybertekschool.com/");
        Driver.getDriver().manage().window().maximize();

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//a[.='Cybertek School']"))).perform();
        //actions.moveToElement(Driver.getDriver().findElement(By.xpath()))


    }
}
