package Company;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class ScreenshotInSelenium {
    public static void main(String[] args) throws Exception{
        /*

        👉 Summary:
        ✅ Robot = Full desktop screenshot
        ✅ TakesScreenshot = Sirf browser/page screenshot

        Robot robot = new Robot();
        robot.delay(3000);
        Rectangle sreenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage image = robot.createScreenCapture(sreenRect);
        ImageIO.write(image,"png",new File("C:\\Users\\ADARSH J. MISHRA\\OneDrive\\Desktop\\Screenshot1.png"));
        System.out.println("Screenshot saved.");
         */

        /*
        TakeScreenShot(): indicates the driver can capture and store the screenshot.
        getScreenShotAS(): captures the screenshot and store it in specified location.
         */

        System.setProperty("webdriver.chrome.driver","C:\\selenium webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("C:\\Users\\ADARSH J. MISHRA\\OneDrive\\Desktop\\AmazonScreenshot.png");
        FileUtils.copyFile(source, destination);
        System.out.println("Screenshot saved.");
        driver.quit();
    }
}