package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpecificBranch extends BtlBasePage{
    public SpecificBranch(WebDriver driver)
    {
        super(driver);
    }

    public boolean existDetails()
    {
        return driver.findElement(By.xpath("//label[text()=\"כתובת\"]")).isDisplayed()
                && driver.findElement(By.xpath("//label[text()=\"קבלת קהל\"]")).isDisplayed()
                && driver.findElement(By.xpath("//label[text()=\"מענה טלפוני\"]")).isDisplayed();

    }
}
