package tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static userinterfaces.HomePage.CATEGORY;

public class Select implements Task {

    private final String category;

    public Select(String category) {
        this.category = category;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(CATEGORY.of(category), isClickable()).forNoMoreThan(5).seconds(),
                Click.on(CATEGORY.of(category))
        );
    }

    public static Select category(String category) {
        return Instrumented.instanceOf(Select.class).withProperties(category);
    }
}
