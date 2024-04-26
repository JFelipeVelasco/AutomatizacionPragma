package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userinterfaces.CartPage.PRODUCT_NAME;
import static userinterfaces.HomePage.LINK_CART;
import static userinterfaces.HomePage.LINK_HOME;

public class Validate implements Question<String> {

    private final String productName;

    public Validate(String productName) {
        this.productName = productName;
    }

    @Override
    public String answeredBy(Actor actor) {

        String productNameResult;

        actor.attemptsTo(
                WaitUntil.the(LINK_CART, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(LINK_CART),
                WaitUntil.the(PRODUCT_NAME.of(productName), isVisible()).forNoMoreThan(5).seconds()
        );
        productNameResult = PRODUCT_NAME.of(productName).resolveFor(actor).getText();
        actor.attemptsTo(
                WaitUntil.the(LINK_HOME, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(LINK_HOME)
        );

        return productNameResult;
    }

    public static Validate cart(String productName) {
        return new Validate(productName);
    }
}
