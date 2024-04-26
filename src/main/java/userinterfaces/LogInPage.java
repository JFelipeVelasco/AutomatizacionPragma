package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LogInPage {

    private LogInPage() {
    }

    public static final Target INPUT_USER = Target.the("Input for username").located(By.id("loginusername"));
    public static final Target INPUT_PASS = Target.the("Input for password").located(By.id("loginpassword"));
    public static final Target BTN_LOGIN = Target.the("Login button").locatedBy("//button[contains(text(),'Log in')]");

}
