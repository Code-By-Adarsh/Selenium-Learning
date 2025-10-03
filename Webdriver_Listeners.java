package Company;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class Webdriver_Listeners {
    public static void main(String[] args) {
        /*
        What are WebDriver Listeners?
        Definition: A WebDriver Listener is an interface in Selenium that listens to events happening during the
                    execution of your test.Basically, it “listens” to WebDriver actions like click, navigate,
                    find element, etc., and allows you to perform extra actions when these events happen.
        */
        System.setProperty("webdriver.chrome.driver","C:\\selenium webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverListener listener = new MyListener();
        EventFiringDecorator decorator = new EventFiringDecorator(listener);
        driver = decorator.decorate(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("wwe");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.name("q")).submit();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.linkText("Why did this happen?")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
