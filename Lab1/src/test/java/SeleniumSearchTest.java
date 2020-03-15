import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumSearchTest {

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
    }

    @Test
    public void   resultShouldMatchTheSearch(){
        String strForSearch = "wikipedia.org";
        driver.get("http://www.yandex.ru");
        WebElement element	=	driver.findElement(By.xpath("//input[@id='text']"));
        element.sendKeys(strForSearch);
        element.submit();
        WebElement	dynamicElement	=	(new WebDriverWait(driver,	10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search-result\"]/li[1]/div/div[1]/div[1]/a/b")));
        System.out.println("Found text: " + dynamicElement.getText());
        Assert.assertEquals(dynamicElement.getText(), strForSearch);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
