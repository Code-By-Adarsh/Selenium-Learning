package Company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Waits {
    public static void main(String[] args) {
        /*
        Implicit wait-->In this,we can tell selenium that we would like to wait for a certain amount of time before throwing
        an exception that it cannot find the element on the page.

        Explicit wait-->In this,we tell web driver to wait for certain conditions(Expected Conditions) or the maximum time exceeded
        before throwing an "ElementNotVisibleException" exception.
        Ex:WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("adarshmishra70931 | Netlify"));
         */

        //----------------------------------------------------------------------------------------------------------------------

        System.setProperty("webdriver.chrome.driver","C:\\selenium webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://login.yahoo.com/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("adarshmishra70931@gmail.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//input[@id='login-signin']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //driver.findElement(By.cssSelector("#recaptcha-anchor")).click(); --------------->Throws the error.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.titleContains("Log in - Sign in to Yahoo"));
        String a = driver.getTitle();
        driver.close();
        if (a.equalsIgnoreCase("Log in - Sign in to Yahoo")){
            System.out.println("Test Successful.");
        }else {
            System.out.println("Test Unsuccessful.");
        }

    }
}