package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinishCalculate extends BtlBasePage{
    public FinishCalculate(WebDriver driver)
    {
        super(driver);
    }
    public String getTitle()
    {
        return driver.findElement(By.xpath("//h2[@id=\"header\"]")).getText();
    }
    public String checkSum()
    {
        return driver.findElement(By.xpath("//strong[text()=\" 171 \"]")).getText();
    }
}
