package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalculateUnemployment extends BtlBasePage{

   public CalculateUnemployment(WebDriver driver)
   {
       super(driver);
   }
    public Income fillDetails()
    {

        LocalDate dateMinusMonth = LocalDate.now().minusMonths(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = dateMinusMonth.format(formatter);
        driver.findElement(By.xpath("//input[@class=\"date\"]")).sendKeys(formattedDate);
        driver.findElement(By.xpath("//input[@value=\"9\"]")).click();
        driver.findElement(By.xpath("//input[@value=\"המשך\"]")).click();
        return new Income(driver);
    }
}
