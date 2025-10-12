package Company;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WindowHandling {
    public static void main(String[] args){
        /*
        Window Handling: A window handle is a unique identifier that windows assigns to each window created.
        -driver.getWindowHandle(): gets the details of the current window.
        -driver.getWindowHandles(): gets the details of all windows.
        -Set<String> command = driver.get.WindowHandles()
        -driver.switchTo.window(): helps in switching between the windows
        -Action: command used to perform action on the current window
         */

        System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.icicibank.com/");
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window: "+parentWindow);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("APPLY NOW")));
        applyButton.click();

        /*
        Very very important:
        Set<String> allWindows = driver.getWindowHandles();
        for(String window : allWindows){
        if(!window.equals(parentWindow)){
        driver.switchTo().window(window); // Ab driver new window me chala gaya
        break;
        }}
         */

        /*
        Problem for me because window doesn't go back to parent window.
        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement knowMoreButton = wait1.until(ExpectedConditions.elementToBeClickable(By.linkText("KNOW MORE")));
        knowMoreButton.click();
         */

        Set<String> allWindows = driver.getWindowHandles();

        for (String window:allWindows){
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                System.out.println("Current Window: "+window);
                break;
            }
        }

        driver.switchTo().window(parentWindow);
        System.out.println("Back to Parent Window: "+parentWindow);
        driver.quit();
    }
}