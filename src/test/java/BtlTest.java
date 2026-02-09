import org.junit.jupiter.api.Test; // JUnit 5
import static org.junit.jupiter.api.Assertions.*; // Assertions של JUnit 5
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import pageObject.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
public class BtlTest extends BaseTest {

    //3
    @Test
    public void checkSearch() throws InterruptedException {
        BtlBasePage page=new BtlBasePage(driver);
        AfterSearch a = page.search("חישוב סכום דמי לידה ליום");
        Thread.sleep(10000);
        String res = a.searchTitle();
        String expected="תוצאות חיפוש עבור חישוב סכום דמי לידה ליום" ;
        Assertions.assertTrue(res.contains(expected), "הכותרת לא תואמת לחיפוש!");

    }

    //4
    @Test
    public void checkBranches()  {
        BtlBasePage page = new BtlBasePage(driver);
        BranchesPage page1= page.branchesPage();
        String res = page1.BranchTitle();
        String expected="סניפים וערוצי שירות" ;
        Assertions.assertEquals(expected, res, "הכותרת לא תואמת!");

    }

    //5
    @Test
    public void checkBrancheDetails() throws InterruptedException {
        BtlBasePage btlBasePage = new BtlBasePage(driver);
        BranchesPage branchesPage = btlBasePage.branchesPage();

        SpecificBranch s = branchesPage.SpecialBranch();
        boolean f= s.existDetails();

        Assertions.assertTrue(f, "לא קיימים כל השדות");

    }

    //6
    @Test
    public void insuranceRateF() throws InterruptedException {
        BtlBasePage btlBasePage = new BtlBasePage(driver);
        insuranceRate s = btlBasePage.clickInsuranceRate();
        String res =  s.getTitle();
        String expected = "דמי ביטוח לאומי";
        Assertions.assertEquals(res, expected,"כותרת שונה");

        CalculateInsurance c= s.clickCalculator();
        res=c.getTitle();
        expected="חישוב דמי ביטוח עבור עצמאי, תלמיד, שוהה בחוץ לארץ ומי שלא עובד";
        Assertions.assertEquals(res, expected,"כותרת שונה");
        CalculateInsurance2 c2=c.fillDetails();
        Thread.sleep(3000);
        res= c2.getTitle();
        expected="צעד שני";

        assertTrue(res.contains(expected), "כותרת שונה");

        FinishCalculate f = c2.fillDetails2();
        Thread.sleep(3000);

        res = f.getTitle();
        expected = "סיום";

        assertTrue(res.contains(expected), "כותרת שונה");
        res = f.checkSum();
        expected = "171";
        Assertions.assertEquals(res,expected,"כותרת שונה");

    }


    //7
    @Test
    public void unemploymebt() throws InterruptedException {
        BtlBasePage page = new BtlBasePage(driver);
        Unemployment u = page.benefits();
        UnemploymentPayment p = u.calculator();
        CalculateUnemployment c=p.calculate();
        Income i = c.fillDetails();
        Thread.sleep(3000);
        ResultCalculate r =  i.fillIncomes();
        String res = r.getTitle();
        String expected = "חישוב סכום דמי אבטלה";
        Assertions.assertEquals(res,expected,"כותרת שונה");
        Thread.sleep(3000);
        Assertions.assertTrue(r.checkDetails(),"לא קיימים כל הפרטים");
    }
    //8
    @ParameterizedTest(name = "בדיקת ניווט לקצבת: {1}")
    @CsvSource({
            "https://www.btl.gov.il/benefits/maternity/Childbirth_Allowance/Pages/default.aspx, דמי לידה",
            "https://www.btl.gov.il/benefits/nifgaaiPolio/Pages/default.aspx, פיצוי לנפגעי פוליו",
            "https://www.btl.gov.il/benefits/Reserve_Service/Pages/default.aspx,מילואים",
            "https://www.btl.gov.il/benefits/children/%d7%9e%d7%a2%d7%a0%d7%a7%20%d7%9c%d7%99%d7%9e%d7%95%d7%93%d7%99%d7%9d/Pages/default.aspx, מענק לימודים",
            "https://www.btl.gov.il/benefits/Disability/Pages/default.aspx, נכות כללית"
    })
    public void testBreadcrumbsNavigation(String url, String expectedName) {

        driver.get(url);
        String actualPageName = driver.findElement(By.cssSelector(".breadcrumbs-item.active")).getText();
        Assertions.assertTrue(actualPageName.contains(expectedName),
                "הטקסט '" + expectedName + "' לא נמצא ב-Breadcrumb של הדף: " + url);
    }



}