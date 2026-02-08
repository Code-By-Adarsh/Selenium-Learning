import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WindowHandling {
    public static void wait3(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args){
        /*
        What is a Window in Selenium?
        A window or tab is a browser instance with a unique ID called a Window Handle.
        Selenium does NOT understand titles or URLs automatically
        👉 It understands window handles (String IDs)
         */

        /*
        Key Methods (MEMORIZE THESE)
        Method	Purpose
        getWindowHandle()	Returns current window ID
        getWindowHandles()	Returns all window IDs
        switchTo().window(id)	Switch focus to another window
        close()	Closes current window
        quit()	Closes all windows

        Important Rule (Don’t Miss This)
        👉 Selenium can control only ONE window at a time
        If you don’t switch → Selenium keeps working on old window and fails.
         */

        /*
        Window Handling: A window handle is a unique identifier that windows assigns to each window created.
        -driver.getWindowHandle(): gets the details of the current window.
        -driver.getWindowHandles(): gets the details of all windows.
        -Set<String> command = driver.get.WindowHandles()
        -driver.switchTo.window(): helps in switching between the windows
        -Action: command used to perform action on the current window
         */

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window: "+parentWindow);

        wait3();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("OrangeHRM, Inc"))).click();
        wait3();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window:allWindows){
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                System.out.println("Current Window: "+window);
                break;
            }
        }

        /*
        What’s happening here (IMPORTANT)
        parentWindow → your main browser
        getWindowHandles() → parent + child
        Loop → find child window
        Switch control → now Selenium works on child
        ⚠️ Without switching, Selenium is blind
         */

        wait3();
        driver.close();
        wait3();
        String parentWindow1 = driver.switchTo().window(parentWindow).getWindowHandle();
        System.out.println("Back to Parent Window: "+parentWindow1);
        driver.quit();
    }
}