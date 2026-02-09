package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultCalculate extends BtlBasePage{
    public ResultCalculate(WebDriver driver)
    {
        super(driver);
    }

    public String getTitle()
    {
        return driver.findElement(By.xpath("//h1")).getText();
    }

    public boolean checkDetails()
    {
        return driver.findElement(By.xpath("//label[text()=\"שכר יומי ממוצע לצורך חישוב דמי אבטלה:  \"]")).isDisplayed()
                && driver.findElement(By.xpath("//label[text()=\"דמי אבטלה ליום:  \"]")).isDisplayed()
                && driver.findElement(By.xpath("//label[text()=\"דמי אבטלה לחודש (לפי 25 ימים):  \"]")).isDisplayed();
    }

}
