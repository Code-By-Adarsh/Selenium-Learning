package Company;

public class TestNG_XmlFile {
    public static void main(String[] args) {
        /*
        --🧩 What is a TestNG XML File?
        TestNG XML file (usually named testng.xml) is a configuration file that tells TestNG which tests to run, how to run them, and in what order.
        Instead of running each test class manually, you can control all test executions from one XML file.
        Think of it like a master control panel for your testing project.

        --⚙️ Why Do We Use testng.xml?
        Because it gives us flexibility and organization.
        With testng.xml, you can:
        Run multiple test classes together.
        Run specific test methods only.
        Include or exclude tests dynamically.
        Create test groups (like Smoke, Regression, etc.).
        Run tests in parallel (multi-browser testing).
        Pass parameters from XML to Java code.

        --🧱 Basic Structure of testng.xml:
        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
        <suite name="My Test Suite">
        <test name="My Test">
        <classes>
        <class name="tests.FlipkartTest"/>
        <class name="tests.AmazonTest"/>
        </classes>
        </test>
        </suite>

        --🔍 Let’s Break It Down:
         Tag	    Meaning
         <suite>	The top-level tag that represents the entire TestNG suite. You can have multiple <test> tags inside one suite.
         <test>	    Defines a group of classes or test cases you want to execute together. Each <test> runs independently.
         <classes>	Contains a list of Java classes that have TestNG test methods.
         <class>	Refers to the fully qualified name of your Java test class (package + class name).

         --💡 Example Project Structure:
         src/test/java/
         ├── tests/
         │   ├── FlipkartTest.java
         │   └── AmazonTest.java
         testng.xml

         --Then, in each class:
         package tests;
         import org.testng.annotations.Test;
         public class FlipkartTest {
         @Test
         public void verifyTitle() {
         System.out.println("Flipkart title verified");
         }
         }

         public class AmazonTest {
         @Test
         public void verifySearch() {
         System.out.println("Amazon search verified");
         }
         }
         When you run testng.xml, both test classes will execute automatically.

         --🧩 Adding Multiple <test> Tags:
         You can group tests logically — for example, one test for Flipkart, one for Amazon:
         <suite name="E-Commerce Suite">
         <test name="Flipkart Tests">
         <classes>
         <class name="tests.FlipkartTest"/>
         </classes>
         </test>

         <test name="Amazon Tests">
         <classes>
         <class name="tests.AmazonTest"/>
         </classes>
         </test>
         </suite>
         💡 Each <test> runs independently — useful when you want separate reports.

         --🧠 Advanced Features
         1. Include/Exclude Methods
         You can run specific methods from a class.
         <classes>
         <class name="tests.FlipkartTest">
         <methods>
         <include name="verifyTitle"/>
         <exclude name="verifyLogin"/>
         </methods>
         </class>
         </classes>

         2. Grouping Tests
         You can group test methods using @Test(groups = "smoke") in Java.
         @Test(groups = "smoke")
         public void verifyTitle() { ... }
         @Test(groups = "regression")
         public void verifySearch() { ... }

         Then in XML:
         <groups>
         <run>
         <include name="smoke"/>
         </run>
         </groups>
         💡 This helps run only specific categories of tests.

         3. Parameterization (Pass values from XML to Java)
         You can define parameters in XML and fetch them in your test using @Parameters.
         <suite name="Suite">
         <parameter name="browser" value="chrome"/>
         <test name="Browser Test">
         <classes>
         <class name="tests.BrowserTest"/>
         </classes>
         </test>
         </suite>

         In your test class:
         @Parameters("browser")
         @Test
         public void launchBrowser(String browser) {
         System.out.println("Launching browser: " + browser);
         }

         4. Parallel Execution
         Run tests on multiple browsers at the same time 🔥
         <suite name="Parallel Suite" parallel="tests" thread-count="2">
         <test name="Chrome Test">
         <parameter name="browser" value="chrome"/>
         <classes>
         <class name="tests.BrowserTest"/>
         </classes>
         </test>

         <test name="Edge Test">
         <parameter name="browser" value="edge"/>
         <classes>
         <class name="tests.BrowserTest"/>
         </classes>
         </test>
         </suite>
         💡 parallel="tests" means both tests will run simultaneously using 2 threads.

         --📊 Running the XML File:
         In Eclipse or IntelliJ:
         Right-click on testng.xml
         Click Run As → TestNG Suite
         You’ll see all classes and tests executing in the TestNG console with a summary report.
         */
    }
}