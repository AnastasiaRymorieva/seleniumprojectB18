package test.day7_javafaker_webtables;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTest {
    //TC #1: Smartbear software link verification
    //1. Open browser
    //2. Go to website:
    //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //3. Enter username: "Tester"
    //4. Enter password: "test"
    //5. Click to Login button
    //6. Print out count of all the links on landing page
    //7. Print out each link text on this page
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        driver=new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        SmartBearUtilities.login(driver);

    }
@Ignore
public void close(){
        driver.close();
}




    @Test
    public void test(){

        List<WebElement> links=driver.findElements(By.xpath("//a"));
        System.out.println("Total links: "+links.size());
        for (WebElement each:links){
            System.out.println(each.getText());
        }

    }

@Test
    public void p2_smartbear_order_placing(){
        //TC#2: Smartbear software order placing

    //6. Click on Order
    //7. Select familyAlbum from product, set quantity to 2
    //8. Click to "Calculate" button
    //9. Fill address Info with JavaFaker
    //• Generate: name, street, city, state, zip code
    //10. Click on "visa" radio button
    //11. Generate card number using JavaFaker
    //12. Click on "Process"

    driver.findElement(By.xpath("//a[.='Order']")).click();
    Select productdropdown=new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
productdropdown.selectByVisibleText("FamilyAlbum");
driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.BACK_SPACE);
   driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("2");
driver.findElement(By.xpath("//input[@value='Calculate']")).click();

WebElement name=driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
WebElement street=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
WebElement city=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
WebElement state=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
WebElement zip=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
Faker faker=new Faker();
name.sendKeys(faker.name().fullName());
street.sendKeys(faker.address().streetAddress());
city.sendKeys(faker.address().city());
state.sendKeys(faker.address().state());
zip.sendKeys(faker.address().zipCode().replaceAll("-",""));

driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();

driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(faker.business().creditCardNumber().replaceAll("-",""));

driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("12/25");
driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

//String  successMessage="New order has been successfully added.";
WebElement actualMessage=driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
    Assert.assertTrue(actualMessage.isDisplayed());
}

@Test
    public void orderVerification(){
        ////TC#3: Smartbear software order verification
        // 1.Open browser and login to Smartbear software
        // 2.Click on View all orders3.Verify Susan McLaren has order on date “01/05/2010”
    driver.findElement(By.xpath("//a[.='View all orders']")).click();
    WebElement susanDate=driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));
    String actualDate=susanDate.getText();
    String expectedDate="01/05/2010";
    Assert.assertEquals(actualDate,expectedDate);
}
}
