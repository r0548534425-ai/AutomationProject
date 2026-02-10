package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AfterSearch extends BtlBasePage {
    public AfterSearch(WebDriver driver)
    {
        super(driver);
    }

    public String searchTitle()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(., 'חישוב סכום')]"))).getText();
    }
}
