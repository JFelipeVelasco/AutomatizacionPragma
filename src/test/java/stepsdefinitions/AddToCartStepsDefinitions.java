package stepsdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.ModelLogIn;
import models.ModelProducts;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import questions.Quantity;
import questions.TotalPrice;
import questions.Validate;
import tasks.AddProducts;
import tasks.LogIn;
import tasks.Select;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class AddToCartStepsDefinitions {

    @Before
    public void setOnStage() {
        setTheStage(new OnlineCast());
    }

    @Given("the user enters the website")
    public void theUserEntersTheWebsite() {
        theActorCalled("User").wasAbleTo(Open.url("https://www.demoblaze.com/"));
    }

    @When("the user adds a product to the cart")
    public void theUserAddsAProductToTheCart(DataTable product) {
        if (ModelProducts.setData(product).get(0).getCategory() != null) {
            theActorInTheSpotlight().attemptsTo(Select.category(ModelProducts.setData(product).get(0).getCategory()));
        }
        theActorInTheSpotlight().attemptsTo(
                AddProducts.toCart(ModelProducts.setData(product).get(0).getProductName(), ModelProducts.setData(product).get(0).getQuantity())
        );
    }

    @Then("check the product in the cart")
    public void checkTheProductInTheCart(DataTable product) {
        theActorInTheSpotlight().should(seeThat(Validate.cart(ModelProducts.setData(product).get(0).getProductName()),
                equalTo(ModelProducts.setData(product).get(0).getProductName())));
    }

    @And("the user enters his credentials")
    public void theUserEntersHisCredentials(DataTable data) {
        theActorInTheSpotlight().attemptsTo(
                LogIn.toWebSite(ModelLogIn.setData(data).get(0).getUser(), ModelLogIn.setData(data).get(0).getPassword())
        );
    }

    @And("select the category")
    public void selectTheCategory(DataTable category) {
        theActorInTheSpotlight().attemptsTo(
                Select.category(ModelProducts.setData(category).get(0).getCategory())
        );
    }

    @And("the user adds the second product to the cart")
    public void theUserAddsTheSecondProductToTheCart(DataTable data) {

        if (ModelProducts.setData(data).get(0).getCategory() != null) {
            theActorInTheSpotlight().attemptsTo(
                    Select.category(ModelProducts.setData(data).get(0).getCategory())
            );
        } else {
            theActorInTheSpotlight().attemptsTo(
                    Select.category(ModelProducts.setData(data).get(0).getCategory2())
            );
        }
        theActorInTheSpotlight().attemptsTo(
                AddProducts.toCart(ModelProducts.setData(data).get(0).getProductName2(), ModelProducts.setData(data).get(0).getQuantity())
        );
    }

    @And("check the second product in the cart")
    public void checkTheSecondProductInTheCart(DataTable product2) {
        theActorInTheSpotlight().should(seeThat(Validate.cart(ModelProducts.setData(product2).get(0).getProductName2()),
                equalTo(ModelProducts.setData(product2).get(0).getProductName2())));
    }

    @Then("check the product and the quantity")
    public void checkTheProductAndTheQuantity(DataTable data) {
        theActorInTheSpotlight().should(seeThat(
                Quantity.ofProducts(ModelProducts.setData(data).get(0).getProductName(), ModelProducts.setData(data).get(0).getQuantity()),
                equalTo(ModelProducts.setData(data).get(0).getProductName())
        ));
    }

    @Then("check the total")
    public void checkTheTotal(DataTable data) {
        theActorInTheSpotlight().should(seeThat(TotalPrice.is(ModelProducts.setData(data).get(0)), Matchers.is(true)));
    }
}
