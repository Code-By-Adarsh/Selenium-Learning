package Company;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ebay_purchasing_automation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\selenium webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.cssSelector("#gh-ac")).sendKeys("Motorola");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.cssSelector("#gh-search-btn")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //js.executeScript("window.scrollBy(0,300)");
        driver.navigate().to("https://github.com/Code-By-Adarsh");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().back();

        driver.close();
    }
}