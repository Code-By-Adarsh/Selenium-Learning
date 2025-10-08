package Company.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(BaseListener.class)
public class FlipkartTest extends BaseTest{
    @Test
    public void verifyTitle(){
        driver.get("https://www.flipkart.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void verifyUrl(){
        driver.get("https://www.flipkart.com");
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: "+currentUrl);
        Assert.assertTrue(currentUrl.contains("flipkart.com"),"URL does not contain flipkart.com");
    }

    @Test
    public void verifySearchBox(){
        driver.get("https://www.flipkart.com");
        boolean searchBox = driver.findElement(By.cssSelector(".Pke_EE")).isEnabled();
        Assert.assertTrue(searchBox,"Search-box not accessible.");
    }

    @Test
    public void verifyLogo(){
        driver.get("https://www.flipkart.com");
        boolean logoDisplayed = driver.findElement(By.cssSelector("img[title='Flipkart']")).isDisplayed();
        Assert.assertTrue(logoDisplayed,"Logo not displayed.");
    }

    @Test
    public void verifyLoginButtonImage(){
        driver.get("https://www.flipkart.com");
        boolean imageDisplayed = driver.findElement(By.cssSelector("img[alt='Login']")).isDisplayed();
        Assert.assertTrue(imageDisplayed,"Login image not displayed.");
    }

    @Test
    public void verifySearchBoxWorking(){
        driver.get("https://www.flipkart.com");
        driver.findElement(By.className("Pke_EE")).sendKeys("Chess Board");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Chess Board- Buy Products Online at Best Price in India - All Categories | Flipkart.com"));
        String actualTitle = driver.getTitle();
        String expectedTitle = "Chess Board- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}