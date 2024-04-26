package tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static userinterfaces.HomePage.LINK_LOGIN;
import static userinterfaces.LogInPage.*;

public class LogIn implements Task {

    private final String user;
    private final String password;

    public LogIn(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(LINK_LOGIN, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(LINK_LOGIN),
                WaitUntil.the(INPUT_USER, isClickable()).forNoMoreThan(5).seconds(),
                Enter.theValue(user).into(INPUT_USER),
                Enter.theValue(password).into(INPUT_PASS),
                Click.on(BTN_LOGIN)
        );
    }

    public static LogIn toWebSite(String user, String password) {
        return Instrumented.instanceOf(LogIn.class).withProperties(user, password);
    }
}
