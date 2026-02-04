import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionClass {
    public static void wait1(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        /*
        📌 Topic 1: Selenium Actions Class (Core Concept)
        🔹 Why Actions class exists
        Normal Selenium methods like:
        click()
        sendKeys()
        are not enough for:
        Hover
        Right click
        Drag & Drop
        Keyboard combinations (CTRL + A, etc.)
        👉 Actions class simulates real user behavior (mouse + keyboard).

        🔹 When to use Actions
        Use Actions when:
        -Element is visible only after hover
        -Right click context menu
        -Slider / drag-drop UI
        -Complex keyboard shortcuts

        🔹 Basic Syntax (Memorize this)
        Actions actions = new Actions(driver);
        Nothing works without this line.
         */

        /*
        📌 Topic 2: Mouse Hover (moveToElement)
        🔹 Use case
        Menus appear only when you hover
        Common in e-commerce sites
        🔹 Code (Basic)
        WebElement menu = driver.findElement(By.id("menu"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
        🔹 What’s happening internally
        Selenium moves virtual mouse to element
        Browser fires mouseover event
        Hidden elements become visible
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://vinothqaacademy.com/mouse-event/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("textbox"));
        actions.moveToElement(element).perform();

        wait1();
        driver.quit();

    }
}