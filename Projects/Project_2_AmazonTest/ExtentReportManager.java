package Company.Project1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance(){
        if (extent == null){
            String reportPath = System.getProperty("user.dir")+"\\reports\\AmazonReports.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            spark.config().setDocumentTitle("Amazon Home Page Test Report");
            spark.config().setReportName("Amazon Automation Results");
            spark.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester","Adarsh Mishra");
            extent.setSystemInfo("Browser","Chrome");
            extent.setSystemInfo("Project","Amazon HomePageTest");
        }
        return extent;
    }
}