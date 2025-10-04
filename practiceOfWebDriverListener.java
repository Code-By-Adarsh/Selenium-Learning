package Company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class practiceOfWebDriverListener {
    public static void wait1(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\selenium webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverListener listener = new MyListener1();
        EventFiringDecorator decorator = new EventFiringDecorator(listener);
        driver = decorator.decorate(driver);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        wait1();
        driver.findElement(By.className("Pke_EE")).sendKeys("earbuds");
        wait1();
        driver.findElement(By.className("_2iLD__")).click();
        wait1();
        driver.navigate().to("https://www.amazon.in");
        wait1();
        String amazontitle = driver.getTitle();
        System.out.println("Amazon homepage title: "+amazontitle);
        wait1();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("shoes");
        wait1();
        driver.findElement(By.id("nav-search-submit-button")).click();
        wait1();
        driver.navigate().back();
        wait1();
        driver.quit();
    }
}