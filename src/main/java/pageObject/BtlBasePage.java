package pageObject;

import enums.MainMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//a[text()='"+mainMenuItem.getMainMenuItem()+"' and not(contains(@class,'mobile'))]"));
        driver.findElement(By.xpath("//a[text()='"+ submenu +"']"));
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

    public insuranceRate clickInsuranceRate()
    {
        driver.findElement(By.xpath("//a[@id=\"ctl00_Topmneu_InsuranceHyperLink\"]")).click();
        driver.findElement(By.xpath("//a[text()=\"דמי ביטוח לאומי\"]")).click();
        return new insuranceRate(driver);
    }

    public Unemployment benefits()
    {
        driver.findElement(By.xpath("//a[@id=\"ctl00_Topmneu_HyperLink3\"]")).click();
        driver.findElement(By.xpath("//ul/li/a[text()=\"אבטלה\"]")).click();
        return new Unemployment(driver);
    }
}


