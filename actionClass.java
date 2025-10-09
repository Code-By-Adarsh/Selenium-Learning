package Company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class actionClass {
    public static void wait1(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        /*
        Action class: Action class is a built-in ability to handles various types of keyboards and mouse events.

        --What is the Action class?
        In Selenium, the Actions class is used to perform advanced user interactions like:
        -Mouse actions: hover, right-click, double-click, drag-and-drop, etc.
        -Keyboard actions: pressing keys like Ctrl, Shift, Enter, etc.
        -Composite actions (combining mouse + keyboard actions).
        -It is part of the org.openqa.selenium.interactions package.

        --Why use Actions class?
        Some interactions cannot be done directly with simple WebDriver commands (click(), sendKeys()), like:
        -Hovering over a menu to reveal a submenu
        -Dragging an element from one place to another
        -Performing right-click (context click)
        -Pressing multiple keys together (Ctrl + C)
        For these, Actions class is required.
         */

        System.setProperty("webdriver.chrome.driver","C:\\selenium webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        wait1();
        Actions act = new Actions(driver);
        WebElement menu = driver.findElement(By.id("nav-link-accountList"));
        act.moveToElement(menu).perform();
        wait1();
        WebElement menu1 = driver.findElement(By.className("nav-text"));
        act.moveToElement(menu1).perform();
        wait1();
        driver.quit();

        //Future improvement practice needed.
    }
}