package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import base.BasePage;
import page.TrademePage;
import utils.ReportsUtils;

public class TradmeSteps {

    private TrademePage trademePage;;
    private ReportsUtils reportsUtils;

    @Before
    public void before(){
        trademePage = new TrademePage();
        reportsUtils = new ReportsUtils();
    }

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

    @After
    public void scenarioTearDown(Scenario scenario){
        reportsUtils.takeErrorScreenshot(scenario);
    }


}
