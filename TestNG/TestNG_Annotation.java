package Company;

public class TestNG_Annotation {
    public static void main(String[] args) {
        /*
        Annotation: Annotation is repeatedly used by developers to describe a piece of code that is used to control flow
        of methods.It plays a major role in test next generation (TestNG).

        @Test:Marks a method as a test case to be executed by TestNG.TestNG runs this method and reports it as pass/fail.
        @BeforeMethod:Runs before each @Test method in the current class.Used for setup actions like opening a browser or logging in.
        @AfterMethod:Runs after each @Test method in the current class.Used for cleanup actions like closing the browser or logging out.
        @BeforeClass:Runs once before all the @Test methods in the current class.Used for class-level setup, e.g., initializing browser or environment.
        @AfterClass:Runs once after all @Test methods in the current class.Used for class-level teardown, like generating reports or releasing resources.
        @BeforeTest:Runs before all the test methods in the <test> tag of the XML file.Used for test-level setup like configuring environment or test data.
        @AfterTest:Runs after all the test methods in the <test> tag of the XML file.Used for test-level cleanup like summary reporting or resource release.
        @BeforeSuite:Runs once before the entire suite of tests.Used for global setup like DB connections, report folder creation.
        @AfterSuite:Runs once after the entire suite of tests.Used for global teardown like closing connections, saving logs, or sending summary emails.
        @BeforeGroups / @AfterGroups : Run before/after a test group.

        <BeforeSuite>
            <BeforeTest>
                <BeforeClass>
                    <BeforeMethod>
                       <Test>
                    <AfterMethod>
                 <AfterClass>
            <AfterTest>
        <AfterSuite>

        🧩 Full BaseTest.java (All Annotations Explained)
        package base;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.annotations.*;
        public class BaseTest {
        public WebDriver driver;

        // 1️⃣ @BeforeSuite – Runs only once before the entire test suite starts
        @BeforeSuite
        public void beforeSuite() {
        System.out.println("===== BeforeSuite: Setup global environment (e.g., DB connection, reports init) =====");
        }

        // 2️⃣ @BeforeTest – Runs once before <test> tag in XML (or before all tests in this class if no XML)
        @BeforeTest
        public void beforeTest() {
        System.out.println("===== BeforeTest: Prepare test-level setup (e.g., browser config, report setup) =====");
        }

        // 3️⃣ @BeforeClass – Runs once before all methods in the current class
        @BeforeClass
        public void beforeClass() {
        System.out.println("===== BeforeClass: Start test class setup (e.g., class-level data init) =====");
        }

        // 4️⃣ @BeforeMethod – Runs before each @Test method
        @BeforeMethod
        public void setup() {
        System.out.println("===== BeforeMethod: Launching browser =====");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        }

        // 5️⃣ @Test – Actual test cases (ye BaseTest me nahi likhte, ye child test class me likhe jayenge)
        // Example in FlipkartTest.java or AmazonTest.java

        // 6️⃣ @AfterMethod – Runs after each @Test method
        @AfterMethod
        public void teardown() {
        System.out.println("===== AfterMethod: Closing browser =====");
        if (driver != null) {
            driver.quit();
        }
        }

        // 7️⃣ @AfterClass – Runs once after all @Test methods in this class finish
        @AfterClass
        public void afterClass() {
        System.out.println("===== AfterClass: Cleanup for this class =====");
        }

        // 8️⃣ @AfterTest – Runs once after all tests under <test> tag in XML are complete
        @AfterTest
        public void afterTest() {
        System.out.println("===== AfterTest: Finalizing test-level tasks =====");
        }

        // 9️⃣ @AfterSuite – Runs only once after the entire suite completes
        @AfterSuite
        public void afterSuite() {
        System.out.println("===== AfterSuite: Close reports, disconnect DB, end suite =====");
        }
        }

        ⚙️ Execution Order (Jab tu run karega)
        When tu test class run karega (e.g., FlipkartTest.java):
        @BeforeSuite
        @BeforeTest
        @BeforeClass
        @BeforeMethod
        @Test → test1()
        @AfterMethod
        @BeforeMethod
        @Test → test2()
        @AfterMethod
        @AfterClass
        @AfterTest
        @AfterSuite

        📘 Example: FlipkartTest.java (Jo BaseTest ko extend karega)
        package tests;
        import org.testng.annotations.Test;
        import base.BaseTest;
        public class FlipkartTest extends BaseTest {
        @Test
        public void verifyTitle() {
        driver.get("https://www.flipkart.com");
        System.out.println("Page title: " + driver.getTitle());
        }
        @Test
        public void verifyURL() {
        driver.get("https://www.flipkart.com");
        System.out.println("URL: " + driver.getCurrentUrl());
        }
        }

        ✅ Output Example (Console)
        ===== BeforeSuite: Setup global environment =====
        ===== BeforeTest: Prepare test-level setup =====
        ===== BeforeClass: Start test class setup =====
        ===== BeforeMethod: Launching browser =====
        Page title: Flipkart.com: Online Shopping Site
        ===== AfterMethod: Closing browser =====
        ===== BeforeMethod: Launching browser =====
        URL: https://www.flipkart.com
        ===== AfterMethod: Closing browser =====
        ===== AfterClass: Cleanup for this class =====
        ===== AfterTest: Finalizing test-level tasks =====
        ===== AfterSuite: Close reports, disconnect DB =====
         */
    }
}