package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InsuranceRate extends BtlBasePage{
    public InsuranceRate(WebDriver driver)
    {
        super(driver);
    }

    public String getTitle()
    {
        return driver.findElement(By.xpath("//h1")).getText();
    }
    public CalculateInsurance clickCalculator()
    {
        driver.findElement(By.xpath("//strong[text()=\"מחשבון לחישוב דמי הביטוח\"]")).click();

        return new CalculateInsurance(driver);
    }

}
