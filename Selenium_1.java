package Company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_1 {
    public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver","C:\\selenium webdriver\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://www.github.com");
        System.out.println(driver.getTitle());
        //driver.quit();
    }
}
