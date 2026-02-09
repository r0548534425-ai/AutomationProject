

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTest {

    WebDriver driver;

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
        }else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.btl.gov.il/Pages/default.aspx");
    }

    @AfterEach
    public void closeDriver(){
        driver.quit();
    }
}
