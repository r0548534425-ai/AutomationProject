package extensions; // התאמה לתיקייה שלך

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import report.ExtentReportManager; // ייבוא מהפקג' report
import report.ExtentTestManager;
import test.BaseTest;
// שימי לב: שם ה-Class חייב להיות בדיוק כמו שם הקובץ שבתמונה
public class ExtentReport implements BeforeTestExecutionCallback, AfterTestExecutionCallback, AfterAllCallback {

    private String testName;

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        this.testName = context.getDisplayName().replaceAll("[^a-zA-Z0-9]", "_");
        ExtentTest test = ExtentReportManager.getExtent().createTest(this.testName);
        ExtentTestManager.setTest(test);
    }


    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        if (context.getExecutionException().isPresent()) {
            Throwable throwable = context.getExecutionException().get();


            String shortMessage = throwable.getMessage().split("\n")[0];

            Object testInstance = context.getRequiredTestInstance();
            BaseTest baseTest = (BaseTest) testInstance;
            String screenshotPath = baseTest.takeScreenshot(context.getDisplayName());

            ExtentTestManager.getTest().fail(
                    "❌ נכשל: " + shortMessage,
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()
            );
        }
    }

    @Override
    public void afterAll(ExtensionContext context) {
        ExtentReportManager.getExtent().flush();
    }
}