package Company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testNGFirstTestCase {
    public static void wait1(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String baseUrl = "https://www.flipkart.com";
    String driverPath = "C:\\selenium webdriver\\chromedriver.exe";
    public WebDriver driver;

    @Test
    public void verifyHomePageTitle(){
        System.out.println("Launching chrome browse:");
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        driver.close();
    }
}