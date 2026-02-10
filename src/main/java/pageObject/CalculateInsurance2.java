package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Instant;
import java.util.Objects;

public class CalculateInsurance2 extends BtlBasePage {
    public CalculateInsurance2(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'צעד שני')]"))).getText();
    }

    public FinishCalculate fillDetails2() {
        WebElement radioBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_GetNechut_1")
        ));
        radioBtn.sendKeys(Keys.SPACE);


        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='המשך']")));
        nextBtn.click();

        return new FinishCalculate(driver);
    }

}