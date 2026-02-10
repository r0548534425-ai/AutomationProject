package pageObject;

import enums.MainMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BtlBasePage extends  BasePage{
    public BtlBasePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath =  "//input[@id='TopQuestions']")
    WebElement search;
    @FindBy(xpath =  "//input[@id='ctl00_SiteHeader_reserve_btnSearch']")
    WebElement searchbtn;
    @FindBy(id = "ctl00_Topmneu_BranchesHyperLink")
    WebElement branches;

//

    public void navigate(MainMenu mainMenuItem, String submenu) {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='"+mainMenuItem.getMainMenuItem()+"' and not(contains(@class,'mobile'))]")
        )).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='"+ submenu +"']")
        )).click();
    }


    public AfterSearch search(String s){
        search.sendKeys(s);
        searchbtn.click();
        return new AfterSearch(driver);

    }

    public BranchesPage branchesPage()
    {
        branches.click();
        return new BranchesPage(driver);
    }

    public InsuranceRate clickInsuranceRate()
    {

        navigate(MainMenu.PAY, "דמי ביטוח לאומי");

        return new InsuranceRate(driver);
    }

    public Unemployment benefits()
    {

        navigate(MainMenu.GOODS, "אבטלה");
        return new Unemployment(driver);
    }

}


