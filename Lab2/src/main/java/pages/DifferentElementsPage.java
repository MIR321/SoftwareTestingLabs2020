package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class DifferentElementsPage extends BasePage {

    String logLastResult;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        checkBoxesStates = new boolean[4];
    }

    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement comboBox;


    public DifferentElementsPage chooseCertainComboBoxElement(int index){
        if(index < 0 || index > 3)
            throw new IllegalArgumentException();

        comboBox.click();
        List<WebElement> elements = comboBox.findElements(By.tagName("option"));
        WebElement elem = elements.get(index);
        elem.click();
        StringBuilder sb = new StringBuilder();
        sb.append("Colors: value changed to ").append(elem.getText());
        logLastResult = sb.toString();
        verifyLog();
        return this;
    }

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxRow;

    private boolean[] checkBoxesStates;

    public DifferentElementsPage clickOnCertainCheckBox(int index){
        if(index < 0 || index > 3)
            throw new IllegalArgumentException();

        WebElement checkBox = checkBoxRow.get(index);
        checkBox.click();
        checkBoxesStates[index] =  !checkBoxesStates[index];
        StringBuilder sb = new StringBuilder();
        sb.append(checkBox.getText()).append(": condition changed to ").append(checkBoxesStates[index]? "true" : "false");
        logLastResult = sb.toString();
        verifyLog();
        return this;
    }

    @FindBy(className = "label-radio")
    private List<WebElement> radioButtonRow;

    public DifferentElementsPage clickOnCertainRadioButton(int index){
        if(index < 0 || index > 3)
            throw new IllegalArgumentException();

        WebElement radioButton = radioButtonRow.get(index);
        radioButton.click();
        StringBuilder sb = new StringBuilder();
        sb.append("metal: value changed to ").append(radioButton.getText());
        logLastResult = sb.toString();
        verifyLog();
        return this;
    }

    @FindBy(xpath = "//button[@name='Default Button']")
    private WebElement defaultButton;

    public DifferentElementsPage defaultButtonClick(){

        logLastResult = "Default Button:button clicked";
        defaultButton.click();
        verifyLog();
        return this;
    }



    @FindBy(xpath = "//input[@class='uui-button']")
    private WebElement buttonButton;

    public DifferentElementsPage buttonButtonClick(){

        logLastResult = "button:button clicked";
        buttonButton.click();
        verifyLog();
        return this;
    }


    public void verifyLog(){

        waitForLogToAppear();
        List<WebElement> logs = tableOfLogs.findElements(By.tagName("li"));
        System.out.println(logLastResult);
        System.out.println(logs.get(0).getText());
        Assert.assertTrue(logs.get(0).getText().contains(logLastResult));

    }

}
