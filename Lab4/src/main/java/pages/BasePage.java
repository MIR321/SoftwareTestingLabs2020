package pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class BasePage {

    @FindBy(how=How.ID, using="name")
    private WebElement dropLoginInputField;

    public BasePage  sendLogin(String login){
        dropLoginInputField.sendKeys(login);
        return this;
    }


    @FindBy(how=How.CSS, using="html > body > header > div > nav > ul:nth-of-type(2) > li > a")
    private WebElement dropDownSignInButton;

    public BasePage  dropDownSignInButtonClick(){
        dropDownSignInButton.click();
        return this;
    }


    @FindBy(how=How.ID, using="password")
    private WebElement dropPasswordInputField;

    public BasePage  sendPassword(String pass){
        dropPasswordInputField.sendKeys(pass);
        return this;
    }




    @FindBy(how=How.XPATH, using="id(\"login-button\")/span[1]")
    private WebElement dropSubmitLoginButton;

    public BasePage  dropSubmitLoginButtonClick(){
        dropDownSignInButton.click();
        dropSubmitLoginButton.click();
        return this;
    }


    @FindBy(how=How.ID, using="user-icon")
    private WebElement userIconDropButton;

    public BasePage  userIconDropButtonClick(){
        userIconDropButton.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//span[@class='icon-search']")
    private WebElement searchButton;

    public BasePage  searchButtonClick(){
        searchButton.click();
        return this;
    }

    @FindBy(how=How.XPATH, using="//div[@class='search-field']//input")
    private WebElement searchInputField;
    @FindBy(how=How.XPATH, using="//span[@class='icon-search active']")
    private WebElement activeSearchButton;

    public BasePage searchText(String str){

        searchButtonClick();
        searchInputField.sendKeys(str);
        activeSearchButton.click();
        return this;

    }


    @FindBy(how=How.XPATH, using="//div[@class='logout']//button[@class='uui-button dark-blue btn-login']")
    private WebElement logoutButton;

    public BasePage  logoutButtonClick(){
        userIconDropButtonClick();
        logoutButton.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//li[@class='dropdown uui-profile-menu open']")
    private WebElement userProfileButton;

    public BasePage  userProfileButtonClick(){
        userProfileButton.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//a[contains(text(),'Metals & Colors')]")
    private WebElement metalsAndColorsUpMenuButton;

    public BasePage  metalsAndColorsUpMenuButtonClick(){
        metalsAndColorsUpMenuButton.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//a[contains(text(),'Service')]")
    private WebElement serviceButton;

    public BasePage  serviceButtonClick(){
        serviceButton.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//a[contains(text(),'Contact form')]")
    private WebElement contactFormUpMenuButton;

    public BasePage  contactFormUpMenuButtonClick(){
        contactFormUpMenuButton.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//a[contains(text(),'Home')]")
    private WebElement homeUpMenuButton;

    public BasePage  homeUpMenuButtonClick(){
        homeUpMenuButton.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//div[@class='epam-logo']//span[1]")
    private WebElement informationFrameworkButton;

    public BasePage  informationFrameworkButtonClick(){
        informationFrameworkButton.click();
        return this;
    }


    @FindBy(how=How.ID, using="epam-logo")
    private WebElement epamButton;

    public BasePage  epamButtonClick(){
        epamButton.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//a[contains(text(),'Support')]")
    private WebElement supportUpDropButton;

    public BasePage  supportUpDropButtonClick(){
        serviceButtonClick();
        supportUpDropButton.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//a[contains(text(),'Dates')]")
    private WebElement datesUdDropButton;

    public BasePage  datesUdDropButtonClick(){
        serviceButtonClick();
        datesUdDropButton.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//a[contains(text(),'Search')]")
    private WebElement searchUpDropButton;

    public BasePage  searchUpDropButtonClick(){
        serviceButtonClick();
        datesUdDropButton.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//a[contains(text(),'Complex Table')]")
    private WebElement complexTableUpDropButton;

    public BasePage  complexTableUpDropButtonClick(){
        serviceButtonClick();
        complexTableUpDropButton.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//a[contains(text(),'Simple Table')]")
    private WebElement simpleTableUpDropButton;

    public BasePage  simpleTableUpDropButtonClick(){
        serviceButtonClick();
        simpleTableUpDropButton.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//a[contains(text(),'User Table')]")
    private WebElement userTableUpDropButton;

    public BasePage  userTableUpDropButtonClick(){
        serviceButtonClick();
        userTableUpDropButton.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//a[contains(text(),'Table with pages')]")
    private WebElement tableWithPagesUpDropButton;

    public BasePage  tableWithPagesUpDropButtonClick(){
        serviceButtonClick();
        tableWithPagesUpDropButton.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//a[contains(text(),'Different elements')]")
    private WebElement differentElementsUpDropButton;

    public BasePage  differentElementsUpDropButtonClick(){
        serviceButtonClick();
        differentElementsUpDropButton.click();
        return this;
    }



    @FindBy(how=How.XPATH, using="//a[contains(text(),'Performance')]")
    private WebElement performanceUpDropButton;

    public BasePage  performanceUpDropButtonClick(){
        serviceButtonClick();
        performanceUpDropButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li > a")
    private WebElement homeLeftMenuButton;

    public BasePage  homeLeftMenuButtonClick(){
        homeLeftMenuButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(2) > a")
    private WebElement contactFormLeftMenuButton;

    public BasePage  contactFormLeftMenuButtonClick(){
        contactFormLeftMenuButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(3) > a")
    private WebElement serviceLeftMenuButton;

    public BasePage  serviceLeftMenuButtonClick(){
        serviceLeftMenuButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(3) > ul > li > a")
    private WebElement supportLeftMenuDropButton;

    public BasePage  supportLeftMenuDropButtonClick(){
        serviceLeftMenuButtonClick();
        supportLeftMenuDropButton.click();
        return this;
    }

    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(3) > ul > li:nth-of-type(2) > a")
    private WebElement datesLeftMenuDropButton;

    public BasePage  datesLeftMenuDropButtonClick(){
        serviceLeftMenuButtonClick();
        datesLeftMenuDropButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(3) > ul > li:nth-of-type(3) > a")
    private WebElement complexTableLeftMenuDropButton;

    public BasePage  complexTableLeftMenuDropButtonClick(){
        serviceLeftMenuButtonClick();
        complexTableLeftMenuDropButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(3) > ul > li:nth-of-type(4) > a")
    private WebElement simpleTableLeftMenuDropButton;

    public BasePage  simpleTableLeftMenuDropButtonClick(){
        serviceLeftMenuButtonClick();
        simpleTableLeftMenuDropButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(3) > ul > li:nth-of-type(5) > a")
    private WebElement searchLeftMenuDropButton;

    public BasePage  searchLeftMenuDropButtonClick(){
        serviceLeftMenuButtonClick();
        searchLeftMenuDropButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(3) > ul > li:nth-of-type(6) > a")
    private WebElement userTableLeftMenuDropButton;

    public BasePage  userTableLeftMenuDropButtonClick(){
        serviceLeftMenuButtonClick();
        userTableLeftMenuDropButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(3) > ul > li:nth-of-type(7) > a")
    private WebElement tableWithPagesLeftMenuDropButton;

    public BasePage  tableWithPagesLeftMenuDropButtonClick(){
        serviceLeftMenuButtonClick();
        tableWithPagesLeftMenuDropButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(3) > ul > li:nth-of-type(8) > a")
    private WebElement differentElementsLeftMenuDropButton;

    public BasePage  differentElementsLeftMenuDropButtonClick(){
        serviceLeftMenuButtonClick();
        differentElementsLeftMenuDropButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(3) > ul > li:nth-of-type(9) > a")
    private WebElement performanceLeftMenuDropButton;

    public BasePage  performanceLeftMenuDropButtonClick(){
        serviceLeftMenuButtonClick();
        performanceLeftMenuDropButton.click();
        return this;
    }



    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(4) > a > span")
    private WebElement metalsAndColorsLeftMenuButton;

    public BasePage  metalsAndColorsLeftMenuButtonClick(){
        metalsAndColorsLeftMenuButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(5) > a")
    private WebElement elementsPacksLeftMenuButton;

    public BasePage  elementsPacksLeftMenuButtonClick(){
        elementsPacksLeftMenuButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(5) > ul > li > a")
    private WebElement html5LeftMenuDropButton;

    public BasePage  html5LeftMenuDropButtonClick(){
        elementsPacksLeftMenuButtonClick();
        html5LeftMenuDropButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(5) > ul > li:nth-of-type(2) > a")
    private WebElement mobileLeftMenuDropButton;

    public BasePage  mobileLeftMenuDropButtonClick(){
        elementsPacksLeftMenuButtonClick();
        mobileLeftMenuDropButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(5) > ul > li:nth-of-type(3) > a")
    private WebElement bootstrapLeftMenuDropButton;

    public BasePage  bootstrapLeftMenuDropButtonClick(){
        elementsPacksLeftMenuButtonClick();
        bootstrapLeftMenuDropButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(5) > ul > li:nth-of-type(4) > a")
    private WebElement bootstrapFormLeftMenuDropButton;

    public BasePage  bootstrapFormLeftMenuDropButtonClick(){
        elementsPacksLeftMenuButtonClick();
        bootstrapFormLeftMenuDropButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(5) > ul > li:nth-of-type(5) > a")
    private WebElement bootstrapFormsLeftMenuDropButton;

    public BasePage  bootstrapFormsLeftMenuDropButtonClick(){
        elementsPacksLeftMenuButtonClick();
        bootstrapFormsLeftMenuDropButton.click();
        return this;
    }


    @FindBy(how=How.CSS, using="div#mCSB_1_container > ul > li:nth-of-type(5) > ul > li:nth-of-type(6) > a")
    private WebElement reactAntLeftMenuDropButton;

    public BasePage  reactAntLeftMenuDropButtonClick(){
        elementsPacksLeftMenuButtonClick();
        reactAntLeftMenuDropButton.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//a[contains(text(),'About')]")
    private WebElement aboutLink;

    public BasePage  aboutLinkClick(){
        aboutLink.click();
        return this;
    }


    @FindBy(how=How.XPATH, using="//a[contains(text(),'Report a bug')]")
    private WebElement reportButton;

    public BasePage  reportButtonClick(){
        reportButton.click();
        return this;
    }


    public BasePage signInToGetAccess(){

        dropDownSignInButton.click();
        dropLoginInputField.sendKeys("Roman");
        dropPasswordInputField.sendKeys("Jdi1234");
        dropSubmitLoginButton.click();
        return this;

    }

    WaitActions waitActions;

    public BasePage(WebDriver webDriver){

        PageFactory.initElements(webDriver, this);
        waitActions = new WaitActions(webDriver);

    }


    @FindBy(xpath = "//ul[@class='panel-body-list logs']")
    protected WebElement tableOfLogs;
    @FindBy(xpath = "//ul[@class='panel-body-list results']")
    protected WebElement tableOfResults;


    protected void waitForLogToAppear() {
        waitActions.waitUntilCondition(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver webDriver) {
                return tableOfLogs.findElements(By.tagName("li")).size() > 0;
            }
        });
    }

    protected void waitForResultToAppear() {
        waitActions.waitUntilCondition(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver webDriver) {
                return tableOfResults.findElements(By.tagName("li")).size() > 0;
            }
        });
    }

}
