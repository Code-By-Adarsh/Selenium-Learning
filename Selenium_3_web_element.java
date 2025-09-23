package Company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_3_web_element {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\selenium webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();


        //By id:
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("nav-search-submit-button")).click();
        String et = driver.getTitle();
        //driver.findElement(By.className("nav-input")).click();  Not work by class name
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //By class:
        driver.findElement(By.className("a-button-inner")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //By LinkText:
        driver.findElement(By.linkText("Get It in 2 Days")).click();

        //Navigate to other website
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().to("https://www.flipkart.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().back();
        String at = driver.getTitle();
        driver.close();
        if (at.equalsIgnoreCase(et)){
            System.out.println("Test Successful.");
        }else {
            System.out.println("Test unsuccessful.");
        }


    }
}
