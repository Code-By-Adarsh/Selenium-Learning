package Company;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Basics {
    public static void main(String[] args) {

        /*
        🔹 PART 0 — What Selenium actually is
        Selenium WebDriver is a browser automation tool.
        -Human → opens browser manually
        -Selenium → controls browser using code

        ⚠️ Important truth:
        Selenium does not test anything by itself.
        We design the test by framework,suites,etc. Selenium only executes actions.
         */

        /*
        🔹 PART 1 — Selenium Architecture (VERY IMPORTANT)
        Understand this flow properly:

        Java Test Code
              ↓
        Selenium WebDriver API
              ↓
        Browser Driver (ChromeDriver)
              ↓
        Real Browser (Chrome)

        Key points:
        Selenium never talks directly to the browser
        Browser Driver acts as a translator
        Each browser needs its own driver
         */

        /*
        🔹 PART 2 — What is a Browser Driver?
        A browser driver is a small executable that understands browser-specific commands.
        Browser	Driver
        Chrome	ChromeDriver
        Firefox	GeckoDriver
        Edge	EdgeDriver
        Safari  SafariDriver

        ️ Common beginner mistake:
        ❌ Wrong “ChromeDriver is part of Selenium”
        ✔️ ChromeDriver is maintained by Google (Chrome team)
         */

        // System.setProperty("webdriver.chrome.driver","C:\\selenium webdriver\\chromedriver.exe"); // chromedriver allocation

        /*
        🔹 PART 3 — WebDriver Interface (CORE CONCEPT)
        WebDriver driver = new ChromeDriver();

        What’s happening here?
        WebDriver → interface (defines rules)
        ChromeDriver → concrete implementation
        Why this matters:
        Tomorrow, switching browser is easy:
        WebDriver driver = new FirefoxDriver();
        This is polymorphism in real life — not theory.
         */

        WebDriver driver = new ChromeDriver(); // launching browser
        driver.manage().window().maximize(); // for window maximize
        driver.manage().deleteAllCookies(); // for deleting browser cookies
        driver.get("https://www.google.com"); // opening browser
        // driver.navigate().to("https//www.youtube.com"); ->  next browser page
        // driver.navigate().back(); -> come back to prev page
        // driver.navigate().refresh(); -> for page refresh

        driver.getTitle(); // for getting browser title
        driver.getCurrentUrl(); // for getting current url
        driver.getPageSource(); // full hml source

        System.out.println(driver.getTitle());

        /*
        🔹 PART 4 — What is a WebElement?
        A WebElement represents a single element on a webpage.
        Examples:
        Text box
        Button
        Link
        Label
        Finding an element:
         */

        WebElement element = driver.findElement(By.name("q")); // here WebElement is an interface & name locator -> we will see more about in locator

        element.sendKeys("Mail Karo"); // basic web action (sendkeys())

        WebElement element1 = driver.findElement(By.className("gNO89b")); // class locator

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // WebDriverWait is an interface and wait is a java object

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element1);

        wait.until(ExpectedConditions.elementToBeClickable(element1));

        element1.click(); // basic web action (click())

        System.out.println(driver.getCurrentUrl());

        System.out.println(driver.getPageSource());

        driver.quit();

        /*
        🔹 PART 5 — close() vs quit()
        Method	Meaning
        close()	Closes current window
        quit()	Closes all windows + ends session
        👉 Always use quit() unless you have a reason not to.
         */
    }
}
