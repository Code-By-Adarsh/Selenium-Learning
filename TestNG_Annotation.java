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
         */
    }
}