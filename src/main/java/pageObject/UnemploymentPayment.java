package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UnemploymentPayment extends BtlBasePage{

   public UnemploymentPayment (WebDriver driver)
   {
       super(driver);
   }
    public CalculateUnemployment calculate()
    {
        driver.findElement(By.xpath("//a[@href=\"/Simulators/Pages/AvtalaCalcNew.aspx\"]")).click();
        return new CalculateUnemployment(driver);
    }


}
