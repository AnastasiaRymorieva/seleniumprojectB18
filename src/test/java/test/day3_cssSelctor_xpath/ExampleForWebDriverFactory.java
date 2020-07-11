package test.day3_cssSelctor_xpath;

import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class ExampleForWebDriverFactory {
    public static void main(String[] args) {
      WebDriver driver= WebDriverFactory.getDriver("chrome");
      driver.get("https://google.com");
    }
}
