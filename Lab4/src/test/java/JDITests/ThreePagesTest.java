package JDITests;

import categories.SmokeTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.BasePage;
import pages.DifferentElementsPage;
import pages.MetalsAndColorsPage;
import pages.TableWithPagesPage;

import java.util.concurrent.TimeUnit;

public class ThreePagesTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setupTest() {
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

//    @Test
//    @Category({SmokeTests.class})
//    public void   titlesShouldMatchTheSearch(){
//        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
//        Assert.assertEquals(driver.getTitle(), "Home Page");
//        DifferentElementsPage b = new DifferentElementsPage(driver);
//        b.signInToGetAccess()
//                .differentElementsLeftMenuDropButtonClick();
//        Assert.assertEquals(driver.getTitle(), "Different Elements");
//        b.metalsAndColorsLeftMenuButtonClick();
//        Assert.assertEquals(driver.getTitle(), "Metal and Colors");
//        b.tableWithPagesUpDropButtonClick();
//        Assert.assertEquals(driver.getTitle(), "Table with pages");
//    }

    @Test
    public void   testComboBoxOnDifferentElementsPage(){

        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        DifferentElementsPage b = new DifferentElementsPage(driver);

        b.signInToGetAccess()
                .differentElementsLeftMenuDropButtonClick();

        b.chooseCertainComboBoxElement(2,true)
                .chooseCertainComboBoxElement(3,true)
                .chooseCertainComboBoxElement(2,true)
                .chooseCertainComboBoxElement(1,true)
                .chooseCertainComboBoxElement(0,true)
                .buttonButtonClick(true);
    }

    @Test
    public void   testRadioButtonsAndCheckBoxesOnDifferentElementsPage(){

        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        DifferentElementsPage b = new DifferentElementsPage(driver);

        b.signInToGetAccess()
                .differentElementsLeftMenuDropButtonClick();

        b.clickOnCertainRadioButton(1,true)
                .clickOnCertainCheckBox(2,true)
                .clickOnCertainRadioButton(3,true)
                .clickOnCertainRadioButton(3,true)
                .clickOnCertainCheckBox(2,true)
                .clickOnCertainCheckBox(3,true)
                .clickOnCertainCheckBox(2,true)
                .clickOnCertainRadioButton(0,true)
                .defaultButtonClick(true);
    }


    @Test
    public void   testCalculationOnMetalsAndColorsPage(){
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        MetalsAndColorsPage b = new MetalsAndColorsPage(driver);

        b.signInToGetAccess()
                .metalsAndColorsLeftMenuButtonClick();
        b.clickOnCertainRadioButtonInOddRow(1)
                .clickOnCertainRadioButtonInOddRow(2)
                .clickOnCertainRadioButtonInOddRow(3)
                .clickOnCertainRadioButtonInOddRow(0);

        b.clickOnCertainRadioButtonInEvenRow(0)
                .clickOnCertainRadioButtonInEvenRow(3)
                .clickOnCertainRadioButtonInEvenRow(1)
                .clickOnCertainRadioButtonInEvenRow(2);

        b.calculate(true);
    }

    @Test
    public void   testSubmitOnMetalsAndColorsPage(){
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        MetalsAndColorsPage b = new MetalsAndColorsPage(driver);

        b.signInToGetAccess()
                .metalsAndColorsLeftMenuButtonClick();

        b.clickOnCertainCheckBoxInCheckList(1)
                .clickOnCertainCheckBoxInCheckList(2)
                .chooseCertainComboBoxColorByIndex(2)
                .chooseCertainComboBoxVegetableByIndex(1)
                .chooseCertainComboBoxVegetableByIndex(2)
                .chooseCertainComboBoxVegetableByIndex(0)
                .chooseCertainComboBoxMetalByIndex(3)
                .submitInput(true);
    }


    @Test
    @Category({SmokeTests.class})
    public void   testDisplayOfTableOnTableWithPagesPage() {

        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        TableWithPagesPage b = new TableWithPagesPage(driver);

        b.signInToGetAccess()
                .tableWithPagesUpDropButtonClick();

        b.selectNumberOfEntries(20)
                .selectNumberOfEntries(20)
                .selectNumberOfEntries(5)
                .selectNumberOfEntries(10)
                .selectNumberOfEntries(15)
                .selectNumberOfEntries(5);
        b.switchSort("Plans");
        b.switchSort("Now");
        b.switchSort("Now");
        b.switchSort("Now");
        b.verifyMatchInTable(1, 0,"AJAX");
    }

    @Test
    public void   searchingTestOnTableWithPagesPage() {

        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        TableWithPagesPage b = new TableWithPagesPage(driver);

        b.signInToGetAccess()
                .tableWithPagesUpDropButtonClick();

        b.searchEntries("AJAX",true);
        b.searchEntries("ADO", true);
        b.searchEntries("NU", true);

    }


    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
