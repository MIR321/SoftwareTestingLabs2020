package JDITestsCucumber.steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.BasePage;
import pages.DifferentElementsPage;
import pages.MetalsAndColorsPage;
import pages.TableWithPagesPage;

public class Stepdefs {

    private WebDriver driver;
    private DifferentElementsPage diffpage;
    private MetalsAndColorsPage metpage;
    private BasePage basePage;
    private TableWithPagesPage tabpage;

    @Given("^User opened browser$")
    public void user_opened_browser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Given("^User is signed in$")
    public void user_is_signed_in() {
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        basePage = new BasePage(driver);
        basePage.signInToGetAccess();
    }

    @Given("^User is on Different Elements Page$")
    public void user_is_on_Different_Elements_Page() {
        diffpage = new DifferentElementsPage(driver);
        diffpage.differentElementsLeftMenuDropButtonClick();
    }

    @When("^User selects elements in ComboBox on Different Elements Page$")
    public void user_selects_elements_in_ComboBoxOnDifferentElementsPage() {
        diffpage.chooseCertainComboBoxElement(2, false)
                .chooseCertainComboBoxElement(3, false)
                .chooseCertainComboBoxElement(2, false)
                .chooseCertainComboBoxElement(1, false)
                .chooseCertainComboBoxElement(0, false);
    }

    @Then("^Closing browser$")
    public void closing_browser() throws Throwable {
        if (driver != null) {
            driver.quit();
        }
    }

    @When("^User clicks on RadioButtons and CheckBoxes on Different Elements Page$")
    public void userClicksOnRadioButtonsAndCheckBoxesOnDifferentElementsPage()  {
        diffpage.clickOnCertainRadioButton(1,false)
                .clickOnCertainCheckBox(2,false)
                .clickOnCertainRadioButton(3,false)
                .clickOnCertainRadioButton(3,false)
                .clickOnCertainCheckBox(2,false)
                .clickOnCertainCheckBox(3,false)
                .clickOnCertainCheckBox(2,false)
                .clickOnCertainRadioButton(0,false);
    }

    @Then("^Different Elements Page Logs should contain the correct information about last action$")
    public void logsShouldContainTheCorrectInformationAboutLastClick()  {
        diffpage.verifyLog();
    }

    @Given("^User is on Metals and Colors Page$")
    public void user_is_on_Metals_and_Colors_Page() {
        metpage = new MetalsAndColorsPage(driver);
        metpage.metalsAndColorsLeftMenuButtonClick();
    }


    @When("^User clicks on RadioButtons on Metals and Colors Page$")
    public void user_clicks_on_RadioButtons_on_Metals_and_Colors_Page() {
        metpage.clickOnCertainRadioButtonInOddRow(1)
                .clickOnCertainRadioButtonInOddRow(2)
                .clickOnCertainRadioButtonInOddRow(3)
                .clickOnCertainRadioButtonInOddRow(0);

        metpage.clickOnCertainRadioButtonInEvenRow(0)
                .clickOnCertainRadioButtonInEvenRow(3)
                .clickOnCertainRadioButtonInEvenRow(1)
                .clickOnCertainRadioButtonInEvenRow(2);
    }

    @When("^User presses calculate button on Metals and Colors Page$")
    public void user_presses_calculate_button_on_Metals_and_Colors_Page() {
        metpage.calculate(false);
    }

    @Then("^Metals and Colors Page Results should contain the correct result$")
    public void metals_and_Colors_Page_Results_should_contain_the_correct_result() {
        metpage.verifyCalculation();
    }



    @When("^User chooses elements on Metals and Colors Page$")
    public void user_chooses_elements_on_Metals_and_Colors_Page() {
        metpage.clickOnCertainCheckBoxInCheckList(1)
                .clickOnCertainCheckBoxInCheckList(2)
                .chooseCertainComboBoxColorByIndex(2)
                .chooseCertainComboBoxVegetableByIndex(1)
                .chooseCertainComboBoxVegetableByIndex(2)
                .chooseCertainComboBoxVegetableByIndex(0)
                .chooseCertainComboBoxMetalByIndex(3);
    }

    @When("^User presses submit button on Metals and Colors Page$")
    public void user_presses_submit_button_on_Metals_and_Colors_Page()  {
        metpage.submitInput(false);
    }

    @Then("^Metals and Colors Page Results should contain the correct submit$")
    public void metals_and_Colors_Page_Results_should_contain_the_correct_submit() {
        metpage.verifySubmit();
    }




    @Given("^User is on Table with Pages Page$")
    public void user_is_on_Table_with_Pages_Page() throws Throwable {
        tabpage = new TableWithPagesPage(driver);
        tabpage.tableWithPagesUpDropButtonClick();
    }

    @When("^User selects different numbers of entries on Table with Pages Page$")
    public void user_selects_different_numbers_of_entries_on_Table_with_Pages_Page() throws Throwable {
        tabpage.selectNumberOfEntries(20)
                .selectNumberOfEntries(20)
                .selectNumberOfEntries(5)
                .selectNumberOfEntries(10)
                .selectNumberOfEntries(15)
                .selectNumberOfEntries(5);
    }

    @When("^User switches sort on Table with Pages Page$")
    public void user_switches_sort_on_Table_with_Pages_Page() throws Throwable {
        tabpage.switchSort("Plans");
        tabpage.switchSort("Now");
        tabpage.switchSort("Now");
        tabpage.switchSort("Now");
    }

    @Then("^Verifying the first entry$")
    public void verifying_the_first_entry() throws Throwable {
        tabpage.verifyMatchInTable(1, 0,"AJAX");
    }

    @When("^User is searching entries$")
    public void user_is_searching_entries() throws Throwable {
        tabpage.searchEntries("AJAX",false);
        tabpage.searchEntries("ADO", false);
        tabpage.searchEntries("NU", false);
    }

    @Then("^Verifying the result of search$")
    public void verifying_the_result_of_search() throws Throwable {
        tabpage.verifyResultOfSearch("NU");
    }


}
