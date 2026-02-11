package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {


    protected  WebDriver driver;
    protected WebDriverWait wait;

    @BeforeAll
    public static void startTests(){
        System.out.println("התחלת טסטים");
    }

    @AfterAll
    public static void endTests(){
        System.out.println("סיום טסטים");
    }

    @BeforeEach
    public void loadDriver(){
        String webType = System.getProperty("webType","chrome");
        if(webType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        driver.manage().window().maximize();
        driver.get("https://www.btl.gov.il/Pages/default.aspx");
    }

    @AfterEach
    public void closeDriver(){
        if (driver != null) {
            driver.quit();
        }
    }


    public  String takeScreenshot(String testName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = testName + ".png";
        String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
        File destination = new File(path);
        FileUtils.copyFile(srcFile, destination);
        return "../screenshots/" + fileName;
    }

}