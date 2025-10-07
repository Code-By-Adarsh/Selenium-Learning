package Company;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listenerTest implements ITestListener{

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("The name of test case started is: "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("The name of test case passed is: "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("The name of test case failed is: "+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("The name of test case skipped is: "+result.getName());
    }

    @Override
    public void onStart(ITestContext context){
        System.out.println("Suite started: "+context.getName());
    }

    @Override
    public void onFinish(ITestContext context){
        System.out.println("Suite finished: "+context.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){
        System.out.println("Test Failed but within success percentage: " + result.getName());
    }
}