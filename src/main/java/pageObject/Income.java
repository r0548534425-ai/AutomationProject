package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Income extends BtlBasePage{
    public Income(WebDriver driver)
    {
        super(driver);
    }

    public ResultCalculate fillIncomes() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id, 'Txt_Sallary')]")));

        // מילוי השדות (השתמשתי ב-ID המלא שלך כפי שכתבת)
        driver.findElement(By.xpath("//input[@id=\"ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_IncomeGrid_ctl02_Txt_Sallary\"]")).sendKeys("5000");
        driver.findElement(By.xpath("//input[@id=\"ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_IncomeGrid_ctl03_Txt_Sallary\"]")).sendKeys("5000");
        driver.findElement(By.xpath("//input[@id=\"ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_IncomeGrid_ctl04_Txt_Sallary\"]")).sendKeys("5000");
        driver.findElement(By.xpath("//input[@id=\"ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_IncomeGrid_ctl05_Txt_Sallary\"]")).sendKeys("5000");
        driver.findElement(By.xpath("//input[@id=\"ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_IncomeGrid_ctl06_Txt_Sallary\"]")).sendKeys("5000");
        driver.findElement(By.xpath("//input[@id=\"ctl00_ctl43_g_2ccdbe03_122a_4c30_928f_60300c0df306_ctl00_AvtalaWizard_IncomeGrid_ctl07_Txt_Sallary\"]")).sendKeys("5000");


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value=\"המשך\"]"))).click();

        return new ResultCalculate(driver);
    }

}
