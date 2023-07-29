package com.vytrack.step_definitions;
import com.vytrack.pages.BasePage;
import com.vytrack.pages.ErrorAlertPage;
import com.vytrack.utilities.BrowserUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class VehicleContracts_StepDefs extends BasePage {


    ErrorAlertPage errorAlertPage = new ErrorAlertPage();

    @When("user hovers over {string} module and clicks on the {string} menu")
    public void user_hovers_over_fleet_module_and_clicks_on_the_vehicle_contracts_menu(String tab, String module) {

        navigateToModule(tab, module);
    }

    @Then("user should be able to access the page successfully.")
    public void user_should_be_able_to_access_the_page_successfully() {

        BrowserUtilities.verifyURLContains("https://qa.fleetgru.com/entity/Extend_Entity_VehicleContract");
    }

    @Then("title should be {string}.")
    public void titleShouldBe(String expectedTitle) {

        BrowserUtilities.waitForTitleContains(expectedTitle);
        BrowserUtilities.verifyTitle(expectedTitle);

    }


    @And("user should click error messages")
    public void userShouldClickErrorMessages() {

        errorAlertPage.applicationAlertMessage();


    }


    @Then("user should see an error message saying {string}")
    public void userShouldSeeAnErrorMessageSaying(String expectedErrorMessage) {

        errorAlertPage.permissionAlertMessage(expectedErrorMessage);

    }


}
