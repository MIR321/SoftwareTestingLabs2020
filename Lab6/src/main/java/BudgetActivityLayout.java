import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BudgetActivityLayout {

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/expenses_list")
    MobileElement expensesList;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
    MobileElement addNewExpense;



    public BudgetActivityLayout(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }


    public boolean isEntryInTable(String title, String expenseCategory, String expenseSum){

        List<MobileElement> entries =  expensesList.findElements(By.className("android.widget.TextView"));
        int i = 0;
        for (MobileElement e :
                entries) {
            System.out.println(e.getText());
            if(e.getText().equals(title) || e.getText().equals(expenseCategory) || e.getText().equals(expenseSum))
                i++;
        }
        if(i >= 3)
            return true;
        return false;
    }

}
