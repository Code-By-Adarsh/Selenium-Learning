import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebdriverListeners {
    public static void wait1(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        /*
        What are WebDriver Listeners?
        Definition: A WebDriver Listener is an interface in Selenium that listens to events happening during the
                    execution of your test.Basically, it “listens” to WebDriver actions like click, navigate,
                    find element, etc., and allows you to perform extra actions when these events happen.
        */
        WebDriver driver = new ChromeDriver();
        WebDriverListener listener = new MyListener();
        EventFiringDecorator decorator = new EventFiringDecorator(listener);
        driver = decorator.decorate(driver);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");
        wait1();
        driver.findElement(By.name("q")).sendKeys("earbuds");
        wait1();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
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
