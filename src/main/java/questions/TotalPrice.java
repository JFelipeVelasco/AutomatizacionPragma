package questions;

import models.ModelProducts;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.Calculate;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userinterfaces.CartPage.TOTAL_VALUE;
import static userinterfaces.HomePage.LINK_CART;

public class TotalPrice implements Question<Boolean> {

    private final ModelProducts data;

    public TotalPrice(ModelProducts data) {
        this.data = data;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        int total = Calculate.total(data.getPrice(), data.getQuantity());

        actor.attemptsTo(
                WaitUntil.the(LINK_CART, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(LINK_CART),
                WaitUntil.the(TOTAL_VALUE, isVisible()).forNoMoreThan(5).seconds()
        );
        return Integer.parseInt(TOTAL_VALUE.resolveFor(actor).getText()) == total;
    }

    public static TotalPrice is(ModelProducts data) {
        return new TotalPrice(data);
    }
}
