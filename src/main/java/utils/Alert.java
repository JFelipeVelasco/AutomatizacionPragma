package utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class Alert implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String alertMessage = driver.switchTo().alert().getText();
        actor.remember("TextAlert", alertMessage);
        driver.switchTo().alert().accept();
    }

    public static Alert accept() {
        return new Alert();
    }
}
