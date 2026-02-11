package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testNGFirstTestCase {
    public String baseUrl = "https://www.flipkart.com";
    public WebDriver driver;

    @Test
    public void verifyHomePageTitle(){
        System.out.println("Launching chrome browser:");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        driver.close();
    }
}