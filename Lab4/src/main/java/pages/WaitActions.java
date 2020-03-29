package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.NoSuchElementException;

public class WaitActions {

    private WebDriverWait webDriverWait;

    public WaitActions(WebDriver webDriver) {
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    public Boolean waitUntilCondition(ExpectedCondition<Boolean> p) {
        return (Boolean)webDriverWait.ignoring(NoSuchElementException.class).until(p);
    }

}
