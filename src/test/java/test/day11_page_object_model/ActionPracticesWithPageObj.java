package test.day11_page_object_model;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;
import utilities.Driver;

public class ActionPracticesWithPageObj {

    @Test

    public void hover_test_with_pom() throws Exception{
        //TC	#15:	Hover	Test
        // 1.Go	to	http://practice.cybertekschool.com/hovers
        // 2.Hover	over	to	first	image
        // 3.Assert:	a.“name:	user1”	is	displayed
        // 4.Hover	over	to	second	image
        // 5.Assert:	a.“name:	user2”	is	displayed
        // 6.Hover	over	to	third	image
        // 7.Confirm:	a.“name:	user3”	is	displayed

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");

        Actions actions=new Actions(Driver.getDriver());
        HoversPage elements=new HoversPage();

        Thread.sleep(3000);
        actions.moveToElement(elements.user1).perform();
        Assert.assertTrue(elements.message1.isDisplayed());

        Thread.sleep(3000);
        actions.moveToElement(elements.user2).perform();
        Assert.assertTrue(elements.message2.isDisplayed());

        Thread.sleep(3000);
        actions.moveToElement(elements.user3).perform();
        Assert.assertTrue(elements.message3.isDisplayed());







    }
}
