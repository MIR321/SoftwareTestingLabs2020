package pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.List;

public class MetalsAndColorsPage extends BasePage {

    String logLastResult;
    String[] resultsMonoParams = new String[3];
    List<String> vegetables = new ArrayList<>();
    List<String> elementsWEWF = new ArrayList<>();
    int evenForCalculating;
    int oddForCalculating;
    Actions builder;

    public MetalsAndColorsPage(WebDriver webDriver) {
        super(webDriver);
        elementsCheckBoxesStates = new boolean[4];
        vegetablesCheckBoxesStates = new boolean[4];
        builder	=	new	Actions(webDriver);
        vegetables.add("Vegetables");
        vegetablesCheckBoxesStates[2] = true;
        resultsMonoParams[0] = "3";
        resultsMonoParams[1] = "Colors";
        resultsMonoParams[2] = "Metals";
    }


    @FindBy(xpath = "//section[@id='odds-selector']")
    private WebElement oddRadioButtonRow;

    public MetalsAndColorsPage clickOnCertainRadioButtonInOddRow(int index){
        if(index < 0 || index > 3)
            throw new IllegalArgumentException();

        List<WebElement> buttons = oddRadioButtonRow.findElements(By.tagName("p"));
        WebElement radioButton = buttons.get(index);
        radioButton.click();
        StringBuilder sb = new StringBuilder();
        int res = (index+1)*2-1;
        oddForCalculating = res;
        sb.append("Summary (Odd): value changed to ").append(res);
        logLastResult = sb.toString();
        verifyLog();
        return this;
    }

    @FindBy(xpath = "//section[@id='even-selector']")
    private WebElement evenRadioButtonRow;

    public MetalsAndColorsPage clickOnCertainRadioButtonInEvenRow(int index){
        if(index < 0 || index > 3)
            throw new IllegalArgumentException();

        List<WebElement> buttons = evenRadioButtonRow.findElements(By.tagName("p"));
        WebElement radioButton = buttons.get(index);
        radioButton.click();
        StringBuilder sb = new StringBuilder();
        int res = (index+1)*2;
        evenForCalculating = res;
        sb.append("Summary (Even): value changed to ").append(res);
        logLastResult = sb.toString();
        verifyLog();
        return this;
    }

    @FindBy(xpath = "//button[@id='calculate-button']")
    private WebElement calculateButton;

    public MetalsAndColorsPage calculate(boolean haveToVerifyCalculation){
        calculateButton.click();
        logLastResult = "calculate-button:button clicked";
        resultsMonoParams[0] = "Summary: ";

        resultsMonoParams[0] = resultsMonoParams[0].concat(Integer.toString(evenForCalculating+oddForCalculating));
        verifyLog();
        if(haveToVerifyCalculation)
        verifyCalculation();
        return this;
    }


    @FindBy(className = "checkbox")
    private List<WebElement> elementsInCheckList;
    private boolean[] elementsCheckBoxesStates;


    public MetalsAndColorsPage clickOnCertainCheckBoxInCheckList(int index){
        if(index < 0 || index > 3)
            throw new IllegalArgumentException();

        WebElement checkBox = elementsInCheckList.get(index);
        checkBox.click();
        elementsCheckBoxesStates[index] =  !elementsCheckBoxesStates[index];
        StringBuilder sb = new StringBuilder();
        sb.append(checkBox.getText()).append(": condition changed to ").append(elementsCheckBoxesStates[index]? "true" : "false");
        logLastResult = sb.toString();

        if(elementsCheckBoxesStates[index]){
            elementsWEWF.add(checkBox.getText());
        }else{
            elementsWEWF.remove(checkBox.getText());
        }

        verifyLog();
        return this;
    }


    @FindBy(xpath = "id(\"colors\")/div[1]/button[1]")
    private WebElement colorsComboBox;
    @FindBy(xpath = "//*[@id=\"colors\"]/div/div/ul")
    private WebElement contentOfColorsComboBox;


    public MetalsAndColorsPage chooseCertainComboBoxColorByIndex(int index){
        if(index < 0 || index > 4)
            throw new IllegalArgumentException();

        colorsComboBox.click();
        List<WebElement> elements = contentOfColorsComboBox.findElements(By.tagName("li"));
        WebElement elem = elements.get(index);
        elem.click();
        StringBuilder sb = new StringBuilder();
        sb.append("Colors: value changed to ").append(elem.getText());
        logLastResult = sb.toString();
        resultsMonoParams[1] = elem.getText();
        verifyLog();
        return this;
    }

    @FindBy(xpath = "//div[@id='metals']//span[@class='caret']")
    private WebElement metalsComboBox;
    @FindBy(xpath = "//*[@id=\"metals\"]/div/div")
    private WebElement contentOfMetalsComboBox;
    @FindBy(xpath = "//div[@id='metals']//input")
    private WebElement inputInMetalsComboBox;
    @FindBy(xpath = "//div[@class='uui-main-container page-inside']//main")
    private WebElement neutralElement;

    public MetalsAndColorsPage chooseCertainComboBoxMetalByIndex(int index){
        if(index < 0 || index > 4)
            throw new IllegalArgumentException();


        builder.click(metalsComboBox).build().perform();
        List<WebElement> elements = contentOfMetalsComboBox.findElements(By.tagName("li"));
        WebElement elem = elements.get(index);
        elem.click();
        StringBuilder sb = new StringBuilder();
        sb.append("Metals: value changed to ").append(elem.getText());
        logLastResult = sb.toString();
        resultsMonoParams[2] = elem.getText();
        verifyLog();
        return this;
    }

    public MetalsAndColorsPage inputTextInMetalsComboBox(String metal){
        builder.doubleClick(inputInMetalsComboBox).build().perform();
        inputInMetalsComboBox.sendKeys(metal);
        StringBuilder sb = new StringBuilder();
        sb.append("Metals: value changed to ").append(metal);
        logLastResult = sb.toString();
        resultsMonoParams[2] = metal;
        builder.click(neutralElement).build().perform();
        verifyLog();
        return this;
    }


    @FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle']")
    private WebElement vegetablesComboBox;
    @FindBy(xpath = "//div[@id='salad-dropdown']//ul[@class='dropdown-menu']")
    private WebElement contentOfVegetablesComboBox;
    private boolean[] vegetablesCheckBoxesStates;


    public MetalsAndColorsPage chooseCertainComboBoxVegetableByIndex(int index){
        if(index < 0 || index > 3)
            throw new IllegalArgumentException();

        vegetablesComboBox.click();
        List<WebElement> vegs = contentOfVegetablesComboBox.findElements(By.tagName("li"));
        WebElement checkBox = vegs.get(index);
        checkBox.click();
        neutralElement.click();
        vegetablesCheckBoxesStates[index] =  !vegetablesCheckBoxesStates[index];
        String veg = index == 0 ? "Cucumber" : index == 1 ? "Tomato" : index == 2 ? "Vegetables" : index == 3 ? "Onion" : "";

        if(vegetablesCheckBoxesStates[index]){
            vegetables.add(veg);
        }else{
            vegetables.remove(veg);
        }
        return this;
    }


    @FindBy(xpath = "//button[@id='submit-button']")
    private WebElement submitButton;

    public MetalsAndColorsPage submitInput(boolean haveToVerifySubmit){
        submitButton.click();
        if(haveToVerifySubmit)
        verifySubmit();
        return this;
    }



    public void verifyLog(){

        waitForLogToAppear();
        List<WebElement> logs = tableOfLogs.findElements(By.tagName("li"));
        Assert.assertTrue(logs.get(0).getText().contains(logLastResult));

    }

    public void verifyCalculation(){

        waitForResultToAppear();
        List<WebElement> resultElems = tableOfResults.findElements(By.tagName("li"));
        Assert.assertEquals(resultElems.get(0).getText(), resultsMonoParams[0]);

    }

    public void verifySubmit(){

        waitForResultToAppear();
        List<WebElement> results = tableOfResults.findElements(By.tagName("li"));

        if(results.size() == 5) {
            for (String elem :
                    elementsWEWF) {
                Assert.assertTrue(results.get(1).getText().contains(elem));
            }
            Assert.assertTrue(results.get(2).getText().contains(resultsMonoParams[1]));
            Assert.assertTrue(results.get(3).getText().contains(resultsMonoParams[2]));

            for (String elem :
                    vegetables) {
                Assert.assertTrue(results.get(4).getText().contains(elem));
            }
        }

    }

}
