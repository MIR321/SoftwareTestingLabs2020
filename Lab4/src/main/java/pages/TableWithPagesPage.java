package pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import java.util.List;

public class TableWithPagesPage extends BasePage {

    int numberOfEntries = 5;
    boolean numberOfEntriesChanged = false;
    String logLastResult;
    int volumeOfDB = 11;

    public TableWithPagesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//select[@name='table-with-pages_length']")
    private WebElement selectNumberOfEntriesButton;


    public TableWithPagesPage selectNumberOfEntries(int num){

        if(num <= 0 || num > 20 || num%5!=0){
            throw new IllegalArgumentException();
        }

        selectNumberOfEntriesButton.click();
        List<WebElement> options = selectNumberOfEntriesButton.findElements(By.tagName("option"));
        options.get(num / 5 - 1).click();
        if(num != numberOfEntries)
            numberOfEntriesChanged = true;

        numberOfEntries = num;

        if(numberOfEntriesChanged) {
            logLastResult = "new value=" + Integer.toString(numberOfEntries);
            verifyLog();
        }
        verifyAmountOfEntries();
        return this;
    }

    @FindBy(xpath = "//label[contains(text(),'Search:')]//input[@class='uui-form-element']")
    private WebElement searchEntriesInputField;
    @FindBy(xpath = "//div[@class='uui-main-container page-inside']//main")
    private WebElement neutralElement;

    public TableWithPagesPage searchEntries(String str, boolean haveToVerifyResultOfSearch){

        searchEntriesInputField.clear();
        searchEntriesInputField.sendKeys(str);
        neutralElement.click();
        logLastResult = "value="+str;
        verifyLog();
        if (haveToVerifyResultOfSearch)
        verifyResultOfSearch(str);
        return this;

    }

    @FindBy(xpath = "//table[@id='table-with-pages']//tbody")
    public WebElement tableContent;

    public void verifyResultOfSearch(String searchInput){
        waitForTableToDraw();
        List<WebElement> rows =  tableContent.findElements(By.tagName("tr"));
        List<WebElement> columns = rows.get(0).findElements(By.tagName("td"));
        boolean match = false;
        for (WebElement col:
             columns) {
            if(col.getText().toLowerCase().contains(searchInput.toLowerCase())){
                match = true;
                break;
            }
        }
        Assert.assertTrue(match);
    }

    public void verifyAmountOfEntries(){
        waitForTableToDraw();
        List<WebElement> rows =  tableContent.findElements(By.tagName("tr"));
        if(numberOfEntries < volumeOfDB) {
            Assert.assertEquals(rows.size(), numberOfEntries);
        }
    }



    @FindBy(xpath = "//th[@class='sorting_desc']")
    private WebElement typeSortButton;
    @FindBy(xpath = "//th[contains(text(),'Now')]")
    private WebElement nowSortButton;
    @FindBy(xpath = "//th[contains(text(),'Plans')]")
    private WebElement plansSortButton;

    public void switchSort(String type){

        switch (type){
            case "Type":
                typeSortButton.click();
                break;
            case "Now":
                nowSortButton.click();
                break;
            case "Plans":
                plansSortButton.click();
                break;
        }
    }

    public void verifyMatchInTable(int x, int y, String matchingText){

        waitForTableToDraw();
        waitForTableToDraw();
        List<WebElement> rows =  tableContent.findElements(By.tagName("tr"));
        List<WebElement> columns = rows.get(y).findElements(By.tagName("td"));
        Assert.assertEquals(columns.get(x).getText(), matchingText);

    }


    public void verifyLog(){

        waitForLogToAppear();
        List<WebElement> logs = tableOfLogs.findElements(By.tagName("li"));
        Assert.assertTrue(logs.get(1).getText().contains(logLastResult));

    }

    protected void waitForTableToDraw() {
        waitActions.waitUntilCondition(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver webDriver) {
                return tableContent.findElements(By.tagName("tr")).size() > 0;
            }
        });
    }
}
