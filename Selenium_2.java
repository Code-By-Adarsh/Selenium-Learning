package Company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\selenium webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gmail.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("identifierId")).sendKeys("abc@gmail.com");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        String at = driver.getTitle();
        String et = "gmail";
        //driver.quit();  Output me kam text aaya
        driver.close(); //output me bahut text aaya
        if (at.equalsIgnoreCase(et)){
            System.out.println("Test Successful.");
        }else {
            System.out.println("Test failure.");
        }
    }
}
