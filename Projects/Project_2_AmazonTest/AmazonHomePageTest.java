package Company.Project1;

import com.beust.ah.A;
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
public class AmazonHomePageTest extends BaseTest{
    SoftAssert softAssert = new SoftAssert();
    public static void wait1(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //1
    @Test
    public void verifyTitle(){
        driver.get("https://www.amazon.in");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        Assert.assertEquals(actualTitle,expectedTitle,"Title not matched.");
    }

    //2
    @Test
    public void verifyUrl(){
        driver.get("https://www.amazon.in");
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.in";
        Assert.assertTrue(currentUrl.contains(expectedUrl),"Url doesn't matched.");
    }

    //3
    @Test
    public void verifyNavigationBar(){
        driver.get("https://www.amazon.in");
        WebElement navigationBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navbar")));
        Assert.assertTrue(navigationBar.isDisplayed(),"Navigation bar is not visible on homepage.");
    }

    //4
    @Test(dependsOnMethods = "verifyNavigationBar")
    public void verifyAmazonLogo(){
        driver.get("https://www.amazon.in");
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-logo")));
        Assert.assertTrue(logo.isDisplayed(),"Logo is not visible on homepage.");
    }

    //5
    @Test(dependsOnMethods = "verifyNavigationBar")
    public void verifyGlobalLocation(){
        driver.get("https://www.amazon.in");
        WebElement globalLocation = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-global-location-slot")));
        Assert.assertTrue(globalLocation.isDisplayed(),"Update Location not accessible.");
    }

    //6
    @Test(dependsOnMethods = "verifyNavigationBar")
    public void verifyVisibilityOfSearchBox(){
        driver.get("https://www.amazon.in");
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        softAssert.assertTrue(searchBox.isDisplayed(),"Search box is not visible.");
        softAssert.assertTrue(searchBox.isEnabled(),"Search box is not accessible.");
        softAssert.assertAll();
    }

    //7
    @Test(dependsOnMethods = {"verifyNavigationBar","verifyVisibilityOfSearchBox"})
    public void verifySearchBoxWorking(){
        driver.get("https://www.amazon.in");
        WebElement searchBoxWorking = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
        searchBoxWorking.sendKeys("Motorola g45 5g phone");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        wait.until(ExpectedConditions.titleContains("Motorola g45 5g phone"));
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Motorola g45 5g phone"),"Title doesn't matched.");
    }

    //8
    @Test(dependsOnMethods = "verifyNavigationBar")
    public void verifyCartIcon(){
        driver.get("https://www.amazon.in");
        WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart-count-container")));
        Assert.assertTrue(cartIcon.isDisplayed(),"Cart icon is not visible.");
    }

    //9
    @Test
    public void verifyFooter(){
        driver.get("https://www.amazon.in");
        WebElement footer = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("navFooter")));
        Assert.assertTrue(footer.isDisplayed(),"Footer section is not visible.");
    }

    //10
    @Test(dependsOnMethods = "verifyFooter")
    public void verifyBackToTop(){
        driver.get("https://www.amazon.in");
        WebElement backToTop = wait.until(ExpectedConditions.elementToBeClickable(By.id("navBackToTop")));
        Assert.assertTrue(backToTop.isDisplayed(),"Back to top button is not accessible.");
    }

    //11
    @Test
    public void verifyRefresh(){
        driver.get("https://www.amazon.in");
        wait1();
        driver.navigate().refresh();
        String urlAfterRefresh = driver.getCurrentUrl();
        Assert.assertTrue(urlAfterRefresh.contains("https://www.amazon.in"),"Url changed after refresh.");
    }
}