import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Handling_Alert {
    public static void wait1(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        /*
        Alerts in Selenium: Alerts are basically popup boxes that take your focus away from the current
        browser and forces you to read the alert message.

        Types:
        1.Simple Alert:This type of alert display some kind of information or warning on the screen.

        2.Prompt Alert:This type of alert for taking some input from user.And display two ways 1st is
        accept and the other is reject.Here .sendKeys() used for input.

        3.Confirmation Alert:This type of alert comes with an option to accept or dismiss the alert.To accept
        alert ,Alert.accept() is used and for dismiss the alert Alert.dismiss() is used.

        Methods under Action class:
        1.Driver.switchTo()->For going to alert from browser [driver.switchTo().alert();].
        2.Dismiss.alert()->For dismiss the alert by cancel button. [driver.switchTo().alert().dismiss();].
        3.Accept.alert()->For accept the alert by agree button. [driver.switchTo().alert().accept();].
        4.Alert.getText()->For taking the text from alert message. [driver.switchTo().alert().getText();].
        5.Alert.sendKeys()->For giving the input to alert message. [driver.switchTo().alert().sendKeys();].
         */

        //---------------------------------------------------------------------------------------------------------------

        System.setProperty("webdriver.chrome.driver","C:\\selenium webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        wait1();
        driver.findElement(By.id("alert")).click();
        wait1();
        Alert alertMsg = driver.switchTo().alert();
        String alertMessage1 = driver.switchTo().alert().getText();
        //String alertMessage2 = alertMsg.getText(); it is okay
        System.out.println("Alert Message: "+alertMessage1);
        //driver.switchTo().alert().accept();  it is okay
        alertMsg.accept();
        wait1();
        driver.findElement(By.id("empty-alert")).click();
        Alert alertEmp = driver.switchTo().alert();
        String alertMessage2 = driver.switchTo().alert().getText();
        System.out.println("Alert Message: "+alertMessage2);
        wait1();
        alertEmp.accept();
        wait1();
        driver.findElement(By.id("prompt")).click();
        Alert alertPrompt = driver.switchTo().alert();
        String alertMessage3 = driver.switchTo().alert().getText();
        System.out.println("Alert Message: "+alertMessage3);
        wait1();
        alertPrompt.sendKeys("Adarsh Mishra");
        wait1();
        alertPrompt.accept();
        String result = driver.findElement(By.id("text")).getText();
        System.out.println("Prompt Result: "+result);
        wait1();
        driver.findElement(By.id("slow-alert")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert slowMsg = wait.until(ExpectedConditions.alertIsPresent());
        String msg1 = slowMsg.getText();
        System.out.println("Slow section msg: "+msg1);
        wait1();
        slowMsg.accept();
        wait1();
        driver.findElement(By.id("open-page-with-onload-alert")).click();
        Alert newPage = driver.switchTo().alert();
        wait1();
        newPage.accept();
        String msg2 = driver.findElement(By.tagName("p")).getText();
        wait1();
        driver.navigate().back();
        System.out.println("New page text: "+msg2);
        wait1();
        driver.quit();
    }
}
