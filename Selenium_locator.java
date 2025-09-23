package Company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
1.id → Element ko uske unique id se locate karta hai.
ex-driver.findElement(By.id("username"));
2.name → Element ko uske name attribute se locate karta hai.
ex-driver.findElement(By.name("email"));
3.className → Element ko uske class attribute se locate karta hai.
ex-driver.findElement(By.className("form-control"));
4.tagName → HTML tag name (jaise <input>, <div>) ke base pe locate karta hai.
ex-driver.findElement(By.tagName("input"));
5.linkText → <a> (anchor) tag ke visible text se locate karta hai.
ex-driver.findElement(By.linkText("Click Here"));
6.partialLinkText → <a> tag ke visible text ke partial (hissa) se locate karta hai.
ex-driver.findElement(By.partialLinkText("Click"));
7.cssSelector → Powerful selector, CSS ke syntax se element locate karta hai.
ex-driver.findElement(By.cssSelector("input[type='text']"));
8.xpath → XML path expression ke zariye DOM tree traverse karke element locate karta hai.
ex-driver.findElement(By.xpath("//input[@id='username']"));

----->Target Format:
1. id → element ka unique "id" attribute
driver.findElement(By.id("username"));
<input id="username">

2. name → element ka "name" attribute
driver.findElement(By.name("email"));
<input name="email">

3. className → element ka "class" attribute
driver.findElement(By.className("form-control"));
<input class="form-control">

4. tagName → element ka HTML tag
driver.findElement(By.tagName("input"));
<input ...>

5. linkText → <a> tag ka pura visible text
driver.findElement(By.linkText("Click Here"));
<a href="...">Click Here</a>

6. partialLinkText → <a> tag ka hissa (part) text
driver.findElement(By.partialLinkText("Click"));
<a href="...">Click Here</a>

7. cssSelector → CSS style selector format
driver.findElement(By.cssSelector("input[type='text']"));
<input type="text">

8. xpath → XML/HTML path format
driver.findElement(By.xpath("//input[@id='username']"));
<input id="username">
 */

public class Selenium_locator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\selenium webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netlify.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
}
