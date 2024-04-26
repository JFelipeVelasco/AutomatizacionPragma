package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    private HomePage() {
    }

    public static final Target LINK_HOME = Target.the("Link header to home").
            locatedBy("//a[contains(text(),'Home')]");
    public static final Target LINK_CART = Target.the("Link header to cart").
            located(By.id("cartur"));
    public static final Target LINK_LOGIN = Target.the("Link header to login").
            located(By.id("login2"));
    public static final Target PRODUCT = Target.the("Product").
            locatedBy("//a[contains(text(),'{0}')]");
    public static final Target CATEGORY = Target.the("Category").
            locatedBy("//div[@class = 'list-group']//a[contains(text(),'{0}')]");
}
