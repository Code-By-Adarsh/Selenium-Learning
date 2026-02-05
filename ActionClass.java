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

        /*
        WebElement element = driver.findElement(By.id("textbox"));
        actions.moveToElement(element).perform();
         */

        /*
        📌 Topic 3: Click & Right Click (Context Click)
        🔹 Left Click using Actions
        actions.click(element).perform();
        Why use this instead of element.click()?
        When normal click fails due to JS/UI overlays
         */

        /*
        WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div[1]/button"));
        actions.click(element).perform();
         */

        /*
        🔹 Right Click
        actions.contextClick(element).perform();
        Used for:
        Custom context menus
        Admin panels
        File managers
         */

        /*
        WebElement element = driver.findElement(By.id("rightclick"));
        actions.contextClick(element).perform();
         */

        /*
        📌 Topic 4: Drag and Drop
        🔹 Code
        WebElement source = driver.findElement(By.id("drag"));
        WebElement target = driver.findElement(By.id("drop"));
        actions.dragAndDrop(source, target).perform();
        🔹 Reality check (raw truth)
        ⚠️ dragAndDrop() fails on many modern JS frameworks
        In real projects:
        You may need clickAndHold + moveToElement + release
        🔹 Advanced version (more reliable)
        actions.clickAndHold(source)
       .moveToElement(target)
       .release()
       .perform();
         */

        /*
        WebElement source = driver.findElement(By.id("draggableElement"));
        WebElement target = driver.findElement(By.id("droppableElement"));
        // actions.dragAndDrop(source,target).perform(); -> Not working
        // actions.clickAndHold(source).moveToElement(target).release().perform();  -> Not working also
         */

        /*
        📌 Topic 5: Dropdowns (IMPORTANT CLARITY)
        ❌ Big misunderstanding many beginners have
        Actions is NOT for normal dropdowns.
        🔹 HTML <select> dropdown
        Use Select class, NOT Actions:
        Select select = new Select(dropdown);
        select.selectByVisibleText("India");
        🔹 When Actions is needed
        Only when dropdown is:
        Custom UI (div/li based)
        Opens on hover or click
        Then:
        actions.moveToElement(dropdown).click(option).perform();
         */

        wait1();
        driver.quit();

    }
}