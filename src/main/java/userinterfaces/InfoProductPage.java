package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InfoProductPage {

    private InfoProductPage() {
    }

    public static final Target BTN_ADD = Target.the("BTN add to cart").locatedBy("//a[contains(text(),'Add to cart')]");
}
