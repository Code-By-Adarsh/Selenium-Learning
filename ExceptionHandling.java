import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExceptionHandling {
    public static void wait1(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        /*
        Exception: An exception is a event that disrupts the normal flow of the program.
        -->[Problem occurs->Create Exception->Throw exception->Handle exception]

        Exception Hierarchy:
                                            |->Checked Exception
                              |->Exceptions->|
        Object -> Throwable ->|             |->Unchecked Exception
                              |          |->Virtual Machine Error
                              |->Errors->|
                                         |->Assertion Error


        Checked Exception: An exception that is checked by the compiler at compilation time.This is also called
                           compile-time exception and cannot be simply ignored the programmer should handle these
                           exception.

        Unchecked Exception: An exception that is occurred during runtime.This is also called run-time exception.And
                             can be ignored during compilation.
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        wait1();
        try {
            driver.findElement(By.id("fake")).click();
        }catch (Exception e){
            System.out.println("No such element is present.");
            System.out.println("Hii");
        }
        System.out.println("Title of this page: "+driver.getTitle());
        driver.quit();
    }
}