import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    public static void main(String[] args) {

        /*
        🔄 Selenium Synchronization (Waits) — Basic to Advanced
        What is Synchronization?
        Selenium is faster than web applications.
        Selenium tries to interact with an element
        The web app is still loading
        Result → exceptions
        Common failures:
        NoSuchElementException
        ElementNotInteractableException
        TimeoutException
        👉 Synchronization = teaching Selenium when to wait and when to act
         */

        /*
        Types of Waits (Order matters)
        Implicit Wait
        Explicit Wait
        ExpectedConditions
        Fluent Wait
        ⚠️ Real-world rule:
        Mixing Implicit and Explicit Waits is a bad practice
        (unpredictable delays, slow tests)
         */

        /*
        1️⃣ Implicit Wait (Beginner Level)
        Theory
        Global wait
        Applies to all findElement() calls
        Selenium waits up to max time, not fixed time
        Syntax
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Example
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin123");

        What actually happens?
        Selenium waits up to 10 seconds
        If element appears in 2 sec → continue immediately
        If not → exception after 10 sec
        ❌ Why Implicit Wait is BAD in real projects
        Applied globally (no control)
        Makes debugging hard
        Slows down test execution
        Conflicts with Explicit Wait
        Industry reality
        👉 Avoid Implicit Wait in frameworks
         */

        /*
        2️⃣ Explicit Wait (Industry Standard)
        Theory
        Condition-based wait
        Applied to specific elements
        Most reliable and readable

        Class Used
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Example
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginBtn = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.id("login"))
        );

        loginBtn.click();
        How it works
        Selenium checks the condition
        Polls every 500 ms (default)
        Condition satisfied → continues
        Timeout → TimeoutException
        ✅ Why Explicit Wait is good
        Element-specific
        Clear intent
        Easy to debug
        Framework-friendly
         */

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        wait.until(ExpectedConditions.urlContains("dashboard"));
        System.out.println("Page url: "+driver.getCurrentUrl());

        driver.quit();
    }
}
