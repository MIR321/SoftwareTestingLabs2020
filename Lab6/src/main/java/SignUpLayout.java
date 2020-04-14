import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpLayout {

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    MobileElement registrationEmail;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    MobileElement registrationUsername;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    MobileElement registrationPassword;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    MobileElement registrationConfirmPassword;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    MobileElement registerNewAccountButton;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_cancel_button")
    MobileElement registrationCancelButton;

    public SignUpLayout(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }

    public void registerNewUser(String email, String username, String password, String confPassword, boolean confirm) {
        registrationEmail.sendKeys(email);
        registrationUsername.sendKeys(username);
        registrationPassword.sendKeys(password);
        registrationConfirmPassword.sendKeys(confPassword);
        if(confirm){
            registerNewAccountButton.click();
        }else{
            registrationCancelButton.click();
        }
    }


}
