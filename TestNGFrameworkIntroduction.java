package Company;

public class TestNGFrameworkIntroduction {
    public static void main(String[] args) {
        /*
        🔹 What is TestNG?
        TestNG is a testing framework in Java, inspired by JUnit and NUnit, but with more powerful features.
        The "NG" in TestNG means Next Generation.
        So basically, TestNG = Testing Framework (Next Generation).

        🔹 Why do we use TestNG?
        -To organize and manage test cases in a structured way.
        -To run multiple test cases together (test suite).
        -To use annotations like @Test, @BeforeMethod, @AfterMethod etc. for better control.
        -To support parallel execution (run tests in multiple browsers at the same time).
        -To generate detailed HTML reports automatically.
        -To handle data-driven testing with @DataProvider and @Parameters.
        -To use Assertions for pass/fail verification.
        -To integrate with tools like Maven, Jenkins, Selenium, Cucumber etc.

        🔹 Example without TestNG
        -If you just use Selenium + Java, you need to create a main() method and run tests manually.
        -No reports, no structured execution.
        public class DemoTest {
        public static void main(String[] args) {
        System.out.println("Running test case...");
         }
        }

        🔹 Example with TestNG
        Using TestNG annotations:
        import org.testng.annotations.Test;
        public class DemoTest {
        @Test
        public void testLogin() {
        System.out.println("Login Test Executed");
            }

        @Test
        public void testLogout() {
        System.out.println("Logout Test Executed");
        }
         }

         👉 Here, you don’t need main() method.
         TestNG itself controls test execution, order, grouping, reporting, etc.
         ✅ In short:
         TestNG is a Java testing framework that helps you write, organize, execute, and report test cases in a
         professional and scalable way.
         */
    }
}