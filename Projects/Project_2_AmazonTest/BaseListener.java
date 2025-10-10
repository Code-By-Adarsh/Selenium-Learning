package Company.Project1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class BaseListener implements ITestListener {
    ExtentReports extent = ExtentReportManager.getInstance();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result){
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        test.get().log(Status.INFO,"Test Started: "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        test.get().log(Status.PASS,"Test Success: "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        test.get().log(Status.FAIL,"Test Failed: "+result.getName());
        test.get().log(Status.FAIL,result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result){
        test.get().log(Status.SKIP,"Test Skipped: "+result.getName());
    }

    @Override
    public void onStart(ITestContext context){
        System.out.println("=== Test Suite Started: " + context.getName() + " ===");
    }

    @Override
    public void onFinish(ITestContext context){
        System.out.println("=== Test Suite Finished: " + context.getName() + " ===");
        extent.flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){
        System.out.println("Test failed but within success percentage: "+result.getName());
    }
}