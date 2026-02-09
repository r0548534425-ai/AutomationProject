package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Unemployment extends BtlBasePage{
    public Unemployment(WebDriver driver)
    {
        super(driver);
    }
    public UnemploymentPayment calculator()
    {
        driver.findElement(By.xpath("//strong[text()=\"למחשבוני דמי אבטלה\"]")).click();
        return new UnemploymentPayment(driver);
    }

}
