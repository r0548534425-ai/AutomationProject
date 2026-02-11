package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getExtent() {
        if (extent == null) {

            ExtentSparkReporter spark = new ExtentSparkReporter("target/report.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}