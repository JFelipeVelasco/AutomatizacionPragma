package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    private CartPage() {
    }

    public static final Target PRODUCT_NAME = Target.the("Product Name").locatedBy("//td[contains(text(),'{0}')]");
    public static final Target PRODUCT_QUANTITY = Target.the("Quantity of products").locatedBy("//tbody/tr[{0}]");
    public static final Target TOTAL_VALUE = Target.the("The total value").locatedBy("//h3[@id='totalp']");
}
