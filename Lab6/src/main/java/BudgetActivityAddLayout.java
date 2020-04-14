import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BudgetActivityAddLayout {
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_title_edit")
    MobileElement newExpenseTitleEdit;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_sum_edit")
    MobileElement newExpenseSumEdit;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_date_edit")
    MobileElement newExpenseDateEdit;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_category_picker")
    MobileElement newExpenseCategoryPicker;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/save_new_expense")
    MobileElement saveNewExpense;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/cancel_new_expense")
    MobileElement cancelNewExpense;

    public BudgetActivityAddLayout(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }

    public void addNewExpense(String title, String sum, String date, String category, boolean confirm) {
        newExpenseTitleEdit.sendKeys(title);
        newExpenseSumEdit.sendKeys(sum);
        newExpenseDateEdit.sendKeys(date);
        newExpenseCategoryPicker.sendKeys(category);
        if(confirm){
            saveNewExpense.click();
        }else{
            cancelNewExpense.click();
        }
    }

}
