package Company;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listenerTest.class)
public class testCaseForTestNGListenerTest {
    public static void wait1(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //test to pass as to verify listener:
    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.flipkart.com/");
        wait1();
        driver.findElement(By.className("Pke_EE")).sendKeys("earbuds");
        wait1();
        driver.findElement(By.className("_2iLD__")).click();
        wait1();
        driver.navigate().to("https://www.amazon.in");
        wait1();
        String amazontitle = driver.getTitle();
        System.out.println("Amazon homepage title: " + amazontitle);
        wait1();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("shoes");
        wait1();
        driver.findElement(By.id("nav-search-submit-button")).click();
        wait1();
        driver.navigate().back();
        wait1();
        driver.quit();
    }

    //forcefully failed this test as to verify listener:
    @Test
    public void test2(){
        System.out.println("This method to fail the test.");
        Assert.assertTrue(false);
    }
}