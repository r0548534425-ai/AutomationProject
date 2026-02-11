package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FinishCalculate extends BtlBasePage{
    public FinishCalculate(WebDriver driver)
    {
        super(driver);
    }
    public String getTitle()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), \"סיום\")]"))).getText();
    }
    public String checkSum()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()=\" 171 \"]"))).getText();
    }
}
