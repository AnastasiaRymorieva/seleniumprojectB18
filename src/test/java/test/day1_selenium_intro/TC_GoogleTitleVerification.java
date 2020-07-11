package test.day1_selenium_intro;

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;

public class TC_GoogleTitleVerification {
    public static void main(String[] args) {
        /*
        TC	#1:	Google	Title	Verification1.Open	Chrome	browser

        2.Go	to	https://www.google.com
        3.Verify	title:	Expected:	Google
         */
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");
        String actualTitle=driver.getTitle();
        String expectedTitle="Google";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Google title verification PASSED");
        }else {
            System.out.println("Google title verification FAILED");
        }
        driver.close();
    }
}
