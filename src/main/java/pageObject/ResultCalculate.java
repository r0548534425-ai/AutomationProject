package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultCalculate extends BtlBasePage{
    public ResultCalculate(WebDriver driver)
    {
        super(driver);
    }

    public String getTitle()
    {
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        return header.getText();
    }

    public boolean checkDetails()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(., 'שכר יומי ממוצע')]")));
        return driver.findElement(By.xpath("//label[text()=\"שכר יומי ממוצע לצורך חישוב דמי אבטלה:  \"]")).isDisplayed()
                && driver.findElement(By.xpath("//label[text()=\"דמי אבטלה ליום:  \"]")).isDisplayed()
                && driver.findElement(By.xpath("//label[text()=\"דמי אבטלה לחודש (לפי 25 ימים):  \"]")).isDisplayed();
    }

}
