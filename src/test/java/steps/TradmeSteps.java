package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import page.BasePage;
import page.TrademePage;

public class TradmeSteps {

    private final TrademePage trademePage = new TrademePage();

    @Given("^I navigate to (.+)$")
    public void goToSite(String URL){
        BasePage.navigateTo(URL);
    }


    @When("^I search the product (.+)$")
    public void searchProduct(String productName) {

        trademePage.writeInputSearch(productName);
        trademePage.clickSearchBtn();

    }

    @When("^I can see a result text with (.+)$")
    public void validateProductWasFound(String productExpected) {

        assertEquals("Product has not found", productExpected ,trademePage.getProductOfResultText());

    }
}
