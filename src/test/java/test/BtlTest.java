package test;

import extensions.ExtentReport;
import org.junit.jupiter.api.extension.ExtendWith;
import report.ExtentTestManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import pageObject.*;
import org.junit.jupiter.api.Assertions;

@ExtendWith(ExtentReport.class)
public class BtlTest extends BaseTest {

    @Test
    public void checkSearch() {
        ExtentTestManager.getTest().info("מתחיל בדיקת חיפוש באתר");

        BtlBasePage page = new BtlBasePage(driver);
        AfterSearch a = page.search("חישוב סכום קצבה");

        String res = a.searchTitle();
        String expected = "תוצאות חיפוש עבור חישוב סכום קצבה";

        ExtentTestManager.getTest().info("בודק התאמת כותרת תוצאות החיפוש");
        Assertions.assertTrue(res.contains(expected), "הכותרת לא תואמת לחיפוש!");
    }

    @Test
    public void checkBranches() {
        ExtentTestManager.getTest().info("בדיקת ניווט לדף סניפים ושירות");

        BtlBasePage page = new BtlBasePage(driver);
        BranchesPage page1 = page.branchesPage();
        String res = page1.BranchTitle();
        String expected = "סניפים וערוצי שירות";

        Assertions.assertEquals(expected, res, "הכותרת לא תואמת!");
    }

    @Test
    public void checkBrancheDetails() {
        ExtentTestManager.getTest().info("בדיקת הצגת פרטים בסניף ספציפי");

        BtlBasePage btlBasePage = new BtlBasePage(driver);
        BranchesPage branchesPage = btlBasePage.branchesPage();

        SpecificBranch s = branchesPage.SpecialBranch();
        boolean f = s.existDetails();

        Assertions.assertTrue(f, "פרטי הסניף לא מוצגים כראוי");
    }

    @Test
    public void insuranceRateF() {
        ExtentTestManager.getTest().info("בדיקת מחשבון דמי ביטוח");

        BtlBasePage btlBasePage = new BtlBasePage(driver);
        InsuranceRate s = btlBasePage.clickInsuranceRate();

        Assertions.assertEquals(s.getTitle(), "דמי ביטוח לאומי", "כותרת דף דמי ביטוח לא תקינה");

        CalculateInsurance c = s.clickCalculator();
        ExtentTestManager.getTest().info("מילוי שלב ראשון במחשבון");

        CalculateInsurance2 c2 = c.fillDetails();
        assertTrue(c2.getTitle().contains("צעד שני"), "מעבר לשלב שני נכשל");

        FinishCalculate f = c2.fillDetails2();
        ExtentTestManager.getTest().info("בדיקת סכום סופי שהתקבל במחשבון");

        Assertions.assertEquals(f.checkSum(), "171", "סכום החישוב הסופי אינו תואם למצופה");
        //עשיתי גם את הבדיקה הבאה שבהערה כדי לצלם מצב של כשלון
        //Assertions.assertEquals(f.checkSum(), "161", "סכום החישוב הסופי אינו תואם למצופה");
    }

    @Test
    public void unemploymentTest() {
        ExtentTestManager.getTest().info("בדיקת מחשבון זכאות כללית");

        BtlBasePage page = new BtlBasePage(driver);
        Unemployment u = page.benefits();
        UnemploymentPayment p = u.calculator();
        CalculateUnemployment c = p.calculate();
        Income i = c.fillDetails();

        ResultCalculate r = i.fillIncomes();

        ExtentTestManager.getTest().info("אימות קבלת תוצאות חישוב");
        Assertions.assertTrue(r.getTitle().contains("חישוב סכום"), "דף התוצאות לא נטען כראוי");
        Assertions.assertTrue(r.checkDetails(), "חסרים פרטים בתוצאה הסופית");
    }

    @ParameterizedTest(name = "בדיקת ניווט (Breadcrumbs) עבור: {1}")
    @CsvSource({
            "https://www.btl.gov.il/benefits/nifgaaiPolio/Pages/default.aspx, פיצוי לנפגעי פוליו",
            "https://www.btl.gov.il/benefits/Reserve_Service/Pages/default.aspx, מילואים",
            "https://www.btl.gov.il/benefits/Disability/Pages/default.aspx, נכות כללית",
            "https://www.btl.gov.il/benefits/Work_Injury/Pages/default.aspx,נפגעי עבודה",
            "https://www.btl.gov.il/benefits/Long_Term_Care/Pages/default.aspx,סיעוד"

    })
    public void testBreadcrumbsNavigation(String url, String expectedName) {
        ExtentTestManager.getTest().info("טעינת דף ובדיקת נתיב ניווט עליון");
        driver.get(url);
        String actualPageName = driver.findElement(By.cssSelector(".breadcrumbs-item.active")).getText();

        Assertions.assertTrue(actualPageName.contains(expectedName),
                "הטקסט '" + expectedName + "' לא נמצא בנתיב הניווט של: " + url);
    }
}