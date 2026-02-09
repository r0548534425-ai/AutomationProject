package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalculateInsurance extends BtlBasePage {
    public CalculateInsurance(WebDriver driver)
    {
        super(driver);
    }
    public String getTitle()
    {
        return driver.findElement(By.xpath("//h1")).getText();
    }
    public CalculateInsurance2 fillDetails()
    {
        driver.findElement(By.xpath("//input[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_employeType_2\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_Gender_0\"]")).click();

        LocalDate date = LocalDate.now().minusYears(25);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter);

        driver.findElement(By.xpath("//input[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_DynDatePicker_BirthDate_Date\"]")).sendKeys(formattedDate);

        driver.findElement(By.xpath("//input[@id=\"ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_StartNavigationTemplateContainerID_StartNextButton\"]")).click();
        return new CalculateInsurance2(driver);



    }

}
