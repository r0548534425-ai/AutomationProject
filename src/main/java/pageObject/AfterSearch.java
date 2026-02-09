package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AfterSearch extends BtlBasePage {
    public AfterSearch(WebDriver driver)
    {
        super(driver);
    }

    public String searchTitle()
    {
        return driver.findElement(By.xpath("//h2[contains(., 'חישוב סכום')]")).getText();
    }
}
