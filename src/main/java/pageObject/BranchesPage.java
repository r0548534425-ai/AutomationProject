// קובץ חדש: BranchesPage.java
package pageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BranchesPage extends BtlBasePage {
    public BranchesPage(WebDriver driver) {
        super(driver);
    }
    public String BranchTitle()
    {
        return driver.findElement(By.xpath("//h1")).getText();

    }


    public SpecificBranch SpecialBranch()
    {
        driver.findElement(By.xpath("//a[contains(., 'בני ברק')]")).click();
        return new SpecificBranch(driver);

    }
}