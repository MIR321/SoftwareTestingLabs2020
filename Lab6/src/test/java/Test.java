import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class Test {

    private static AndroidDriverManager driverManager;
    static AndroidDriver driver;
    private static LoginLayout loginLayout;
    private static SignUpLayout signUpLayout;
    private static BudgetActivityLayout budgetActivityLayout;
    private static BudgetActivityAddLayout budgetActivityAddLayout;

    @BeforeClass
    public static void prepareTest() {

        driverManager = new AndroidDriverManager();
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Before
    public void launchApp(){
        driver.launchApp();
        loginLayout = new LoginLayout(driver);
        signUpLayout = new SignUpLayout(driver);
        budgetActivityLayout = new BudgetActivityLayout(driver);
        budgetActivityAddLayout = new BudgetActivityAddLayout(driver);
    }

    //SIGNUP TESTS
    @org.junit.Test
    public void signUpWithCorrectInput()  {
        loginLayout.registerButton.click();
        signUpLayout.registerNewUser("test1@mail", "test1User","testtest1","testtest1", true);
        driver.hideKeyboard();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loginLayout.signInButton));
        driver.hideKeyboard();
    }
    @org.junit.Test
    public void signUpWithIncorrectEmail()  {
        loginLayout.registerButton.click();
        signUpLayout.registerNewUser("wrongemail", "test2User","testtest1","testtest1", true);
        driver.hideKeyboard();
        Assert.assertTrue(signUpLayout.registrationEmail.getAttribute("focused").equals("true"));
        signUpLayout.registrationCancelButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loginLayout.signInButton));
        driver.hideKeyboard();
    }

    //LOGIN TESTS

    @org.junit.Test
    public void loginNonexistentUser() {
        loginLayout.enterEmailAndPassword("nonexistentuser@mail", "12345678");
        driver.hideKeyboard();
        Assert.assertTrue(loginLayout.loginEmail.getAttribute("focused").equals("true"));
        loginLayout.loginEmail.clear();
        loginLayout.loginPwd.clear();
        driver.hideKeyboard();
    }

    @org.junit.Test
    public void loginExistingUser()  {
        loginLayout.registerButton.click();
        signUpLayout.registerNewUser("existinguser@mail", "existinguser","12345678","12345678", true);
        driver.hideKeyboard();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loginLayout.signInButton));
        loginLayout.enterEmailAndPassword("existinguser@mail", "12345678");
        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOf(budgetActivityLayout.addNewExpense));
        driver.navigate().back();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loginLayout.signInButton));
        loginLayout.loginEmail.clear();
        loginLayout.loginPwd.clear();
        driver.hideKeyboard();
    }

    //EXPENSES TESTS

    @org.junit.Test
    public void inputEntryAndCheckInExpensesTable()  {
        loginLayout.registerButton.click();
        signUpLayout.registerNewUser("existinguser3@mail", "existinguser3","12345678","12345678", true);
        driver.hideKeyboard();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loginLayout.signInButton));
        loginLayout.enterEmailAndPassword("existinguser3@mail", "12345678");

        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOf(budgetActivityLayout.addNewExpense));
        budgetActivityLayout.addNewExpense.click();


        budgetActivityAddLayout.addNewExpense("Title1", "1000", "04/14/2020", "Category1", true);
        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOf(budgetActivityLayout.addNewExpense));
        Assert.assertTrue(budgetActivityLayout.isEntryInTable("Title1", "Category1", "1000$"));

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loginLayout.signInButton));
        loginLayout.loginEmail.clear();
        loginLayout.loginPwd.clear();
        driver.hideKeyboard();
    }


    @org.junit.Test
    public void inputIncorrectEntry()  {

        loginLayout.registerButton.click();
        signUpLayout.registerNewUser("existinguser2@mail", "existinguser2","12345678","12345678", true);
        driver.hideKeyboard();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loginLayout.signInButton));
        loginLayout.enterEmailAndPassword("existinguser2@mail", "12345678");

        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOf(budgetActivityLayout.addNewExpense));
        budgetActivityLayout.addNewExpense.click();


        budgetActivityAddLayout.addNewExpense("Title1", "1000", "INCORRECTDATE", "Category1", true);
        driver.hideKeyboard();
        Assert.assertTrue(budgetActivityAddLayout.newExpenseDateEdit.getAttribute("focused").equals("true"));

        driver.navigate().back();
        driver.navigate().back();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loginLayout.signInButton));
        loginLayout.loginEmail.clear();
        loginLayout.loginPwd.clear();
        driver.hideKeyboard();

    }

    @After
    public void closeApp(){
        driver.closeApp();
    }

    @AfterClass
    public static void quit()
    {
        driverManager.quitDriver();
    }

}
