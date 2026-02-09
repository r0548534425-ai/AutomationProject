package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculateInsurance2 extends BtlBasePage {
    public CalculateInsurance2(WebDriver driver)
    {
        super(driver);
    }
    public String getTitle()
    {
        return driver.findElement(By.xpath("//h2[@id=\"header\"]")).getText();
    }
    public FinishCalculate fillDetails2()
    {
        driver.findElement(By.xpath("//input[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_GetNechut_1\"]")).click();

        driver.findElement(By.xpath("//input[@value='המשך']")).click();
        return new FinishCalculate(driver);
    }



}
