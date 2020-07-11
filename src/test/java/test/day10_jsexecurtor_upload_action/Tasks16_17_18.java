package test.day10_jsexecurtor_upload_action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Tasks16_17_18 {
    @Test

    public void TC16_iframe_test() {
        //TC	#16:	Double	ClickTest
        // 1.Go	to	https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        // 2.Switch	to	iframe.
        // 3.Double	click	on	the	text	“Double-click	me	to	change	my	text	color.”
        // 4.Assert:	Text’s	“style”	attribute	value	contains

        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@id='iframeResult']")));
       WebElement text= Driver.getDriver().findElement(By.xpath("//p[@id='demo']"));
        Actions actions=new Actions(Driver.getDriver());
        actions.doubleClick(text).perform();
        String color=text.getAttribute("style");

        Assert.assertTrue(color.equals("color: red;"));

        Driver.closeDriver();
    }

    @Test

    public void TC17_hover_test() {
        //TC	#17:	Hover	Test
        // 1.Go	to	https://demos.telerik.com/kendo-ui/dragdrop/index
        // 2.Drag	and	drop	the	small	circle	to	bigger	circle.
        // 3.Assert:	-Text	in	big	circle	changedto:	“You	did	great

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Driver.getDriver().manage().window().maximize();

        Actions actions=new Actions(Driver.getDriver());

        WebElement smallCircle=Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement largeCircle=Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));



        actions.dragAndDrop(smallCircle,largeCircle).perform();
        WebElement text=Driver.getDriver().findElement(By.xpath("//div[.='You did great!']"));

        Assert.assertTrue(text.isDisplayed());
       Driver.closeDriver();

    }

    @Test

    public void dummy() {
        //TC	#17:	Context	Click	–HOMEWORK
        // 1.Go	to	https://the-internet.herokuapp.com/context_menu
        // 2.Right	click	to	the	box.
        // 3.Alert	will	open.
        // 4.Accept	alert
        // No	assertion	needed	for	this	practice

        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");
        Actions actions=new Actions(Driver.getDriver());
        WebElement box=Driver.getDriver().findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(box).perform();
        Alert alert=Driver.getDriver().switchTo().alert();
        alert.accept();
        actions.click().perform();

        Driver.closeDriver();
    }
}
