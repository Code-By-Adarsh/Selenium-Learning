import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_Alert {
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
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("alert")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Alert alertMsg = driver.switchTo().alert();
        String alertMessage1 = driver.switchTo().alert().getText();
        //String alertMessage25 = alertMsg.getText(); it is okay
        System.out.println("Alert Message: "+alertMessage1);
        //driver.switchTo().alert().accept();  it is okay
        alertMsg.accept();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("empty-alert")).click();
        Alert alertEmp = driver.switchTo().alert();
        String alertMessage2 = driver.switchTo().alert().getText();
        System.out.println("Alert Message: "+alertMessage2);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        alertEmp.accept();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("prompt")).click();
        Alert alertPrompt = driver.switchTo().alert();
        String alertMessage3 = driver.switchTo().alert().getText();
        System.out.println("Alert Message: "+alertMessage3);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        alertPrompt.sendKeys("Adarsh Mishra");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        alertPrompt.accept();
        String result = driver.findElement(By.id("text")).getText();
        System.out.println("Prompt Result: "+result);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}