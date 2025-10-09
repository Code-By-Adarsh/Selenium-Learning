package Company.Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(BaseListener.class)
public class FlipkartHomePageTest extends BaseTest{
    SoftAssert softAssert = new SoftAssert();
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
    public void verifyLoginButtonIcon(){
        driver.get("https://www.flipkart.com");
        boolean loginIconDisplayed = driver.findElement(By.cssSelector("img[alt='Login']")).isDisplayed();
        Assert.assertTrue(loginIconDisplayed,"Login icon not displayed.");
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

    @Test
    public void verifyCartIcon(){
        driver.get("https://www.flipkart.com");
        boolean cartIconDisplayed = driver.findElement(By.cssSelector("img[alt='Cart']")).isDisplayed();
        Assert.assertTrue(cartIconDisplayed,"Cart icon not visible.");
    }

    @Test
    public void verifySellerIcon(){
        driver.get("https://www.flipkart.com");
        boolean sellerIconDisplayed = driver.findElement(By.cssSelector("img[alt='Become a Seller']")).isDisplayed();
        Assert.assertTrue(sellerIconDisplayed,"Become a seller icon not visible.");
    }

    @Test
    public void verifyFooter(){
        driver.get("https://www.flipkart.com");
        boolean footerVisible = driver.findElement(By.className("_1ZMrY_")).isDisplayed();
        Assert.assertTrue(footerVisible,"Footer not visible.");
    }

    @Test
    public void verifyRefresh(){
        driver.get("https://www.flipkart.com");
        String beforeRefresh = driver.getCurrentUrl();
        driver.navigate().refresh();
        String afterRefresh = driver.getCurrentUrl();
        softAssert.assertEquals(afterRefresh,beforeRefresh,"Url changed after refresh.");
        boolean isLogoVisible = driver.findElement(By.cssSelector("img[title='Flipkart']")).isDisplayed();
        softAssert.assertTrue(isLogoVisible,"Logo not visible after refresh.");
        System.out.println("✅ Page refresh verified successfully!");
        softAssert.assertAll();
    }
}