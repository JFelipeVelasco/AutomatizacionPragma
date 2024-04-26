package tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.Alert;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static userinterfaces.HomePage.LINK_HOME;
import static userinterfaces.HomePage.PRODUCT;
import static userinterfaces.InfoProductPage.BTN_ADD;

public class AddProducts implements Task {

    private final String product;
    private final int n;

    public AddProducts(String product, int n) {
        this.product = product;
        this.n = n;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(PRODUCT.of(product), isClickable()).forNoMoreThan(5).seconds(),
                Click.on(PRODUCT.of(product))
        );
        for (int i = 0; i < n; i++) {
            actor.attemptsTo(
                    WaitUntil.the(BTN_ADD, isClickable()).forNoMoreThan(5).seconds(),
                    Click.on(BTN_ADD),
                    Alert.accept()
            );
        }
        actor.attemptsTo(
                WaitUntil.the(LINK_HOME, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(LINK_HOME)
        );
    }

    public static AddProducts toCart(String product, int n) {
        return Instrumented.instanceOf(AddProducts.class).withProperties(product, n);
    }
}
