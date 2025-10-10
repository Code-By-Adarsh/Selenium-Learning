package Company.Project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        System.out.println("Launching browser.....");
        System.setProperty("webdriver.chrome.driver","C:\\selenium webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing browser.....");
        if (driver != null){
            driver.quit();
        }
    }
}