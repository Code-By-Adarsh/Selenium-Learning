import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Locator {
    public static void main(String[] args) {

        /*
        What is a Locator? (Core idea)
        A locator tells Selenium exactly which element to interact with on a web page.

        Selenium does not guess.
        If your locator is wrong or unstable → test fails.
        Basic syntax:
        driver.findElement(By.locatorType("value"));

        Selenium has 8 Locators
        We’ll learn them in the right order (best → worst).
         */

        /*
        1️⃣ id Locator (🔥 BEST)
        When to use
        Element has a unique id
        Fastest and most reliable

        HTML
        <input id="username" type="text">

        Selenium Code
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("Adarsh");

        Important rules
        id must be unique
        If id exists → use it without thinking
         */

        /*
        2️⃣ name Locator
        HTML
        <input name="email">

        Code
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");

        Problem
        Multiple elements can share the same name
        Use only if you’re sure it’s unique
         */

        /*
        3️⃣ className Locator (⚠️ Careful)
        HTML
        <button class="btn primary-btn">Login</button>

        ❌ Wrong
        By.className("btn primary-btn"); // ❌ space not allowed

        ✅ Correct
        By.className("btn");

        Rule
        Only one class
        No spaces allowed
         */

        /*
        4️⃣ linkText (Only for links)

        HTML
        <a href="/login">Login</a>

        Code
        driver.findElement(By.linkText("Login")).click();

        Weakness
        If text changes → test breaks
         */

        /*
        5️⃣ partialLinkText (⚠️ Risky)
        driver.findElement(By.partialLinkText("Log")).click();

        Why risky?
        If multiple links contain "Log" → Selenium gets confused
        👉 Avoid in real projects
         */

        /*
        6️⃣ tagName (Rare use)
        driver.findElements(By.tagName("a"));

        Use case
        When you want multiple elements (all links, all inputs)
         */

        /*
        7️⃣ CSS Selector (🔥 Fast & Clean)

        By ID
        By.cssSelector("#username");

        By Class
        By.cssSelector(".login-input");

        By Attribute
        By.cssSelector("input[type='email']");

        Parent → Child
        By.cssSelector("div.form > input");

        When to use CSS?
        Faster than XPath
        Cleaner syntax
        Best choice after id
         */

        /*
        8️⃣ XPath (🔥 Powerful but Dangerous)
        ❌ Absolute XPath (NEVER)
        /html/body/div[2]/form/input[1]

        Why bad?
        Small UI change → test dead

        ✅ Relative XPath (Correct way)
        By.xpath("//input[@id='username']");

        By visible text
        By.xpath("//button[text()='Login']");

        contains()
        By.xpath("//input[contains(@id,'user')]");

        starts-with()
        By.xpath("//input[starts-with(@id,'user')]");

        When should you use XPath?
        No stable id or class
        Dynamic elements
        Complex DOM structure
         */

        /*
        🔐 Locator Priority Rule (MEMORIZE THIS)
        1. id
        2. name
        3. cssSelector
        4. xpath
        5. className
        6. linkText
        7. partialLinkText
        8. tagName
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
