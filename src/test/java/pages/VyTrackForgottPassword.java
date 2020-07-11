package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VyTrackForgottPassword {

    public VyTrackForgottPassword(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//input[@id='prependedInput']")
      public WebElement userName;

    @FindBy(xpath = "//button[.='Request']")
    public WebElement request;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;


}
