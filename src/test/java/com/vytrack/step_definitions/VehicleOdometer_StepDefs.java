package com.vytrack.step_definitions;

import com.vytrack.pages.VehicleOdometerPage;
import com.vytrack.pages.VYTrackPage;
import com.vytrack.utilities.BrowserUtilities;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VehicleOdometer_StepDefs {

    public VehicleOdometerPage VehicleOdometerPage = new VehicleOdometerPage();
    public VYTrackPage VYTrackPage = new VYTrackPage();

    @Given("the user is on the dashboard page")
    public void theUserIsOnTheDashboardPage() {
        VehicleOdometerPage.waitUntilLoaderScreenDisappear();
        // BrowserUtilities.waitFor(5);

        if (VehicleOdometerPage.isWarningMessageDisplayed()) {
            VehicleOdometerPage.closeWarningMessage();
            // BrowserUtilities.waitFor(5);
        }
    }

    @When("the user hovers over the Fleet module and clicks Vehicles Odometer")
    public void theUserHoversOverTheFleetModuleAndClicksVehiclesOdometer() {
        // BrowserUtilities.waitFor(5);

        for (WebElement each : VehicleOdometerPage.menuOptions) {
            if (each.getText().contains("Fleet")) {
                BrowserUtilities.hover(each);
            }
        }

        for (WebElement each : VYTrackPage.vehiclesMenuOptions) {
            if (each.getText().contains("Vehicle Odometer")) {
                each.click();
            }
        }
    }

    @Then("the user should see an error message {string}")
    public void userSeesTheErrorMessage(String expectedErrorMessage) {
        //  BrowserUtilities.waitFor(5);

        Assert.assertTrue("Error message is not displayed", VehicleOdometerPage.isErrorMessageDisplayed());

        String actualErrorMessage = VehicleOdometerPage.getErrorMessageText();
        Assert.assertEquals("Error message text is incorrect", expectedErrorMessage, actualErrorMessage);
    }

    @When("the user goes to the Vehicles Odometer page")
    public void theUserGoesToTheVehiclesOdometerPage() {

        theUserHoversOverTheFleetModuleAndClicksVehiclesOdometer();
        // BrowserUtilities.waitFor(5);
    }

    @Then("the user should see the default page as {int}")
    public void theUserShouldSeeTheDefaultPageAs(int expectedDefaultPageNumber) {
        // BrowserUtilities.waitFor(5);
        int actualPageNumber = VehicleOdometerPage.getCurrentPageNumber();

        Assert.assertEquals("Default page number is incorrect", expectedDefaultPageNumber, actualPageNumber);
    }

    @Then("the user should see the View Per Page as {int} by default")
    public void theUserShouldSeeViewPerPageAsByDefault(int expectedViewPerPage) {
        // BrowserUtilities.waitFor(5);
        int actualViewPerPage = VehicleOdometerPage.getCurrentPageNumber1();
        Assert.assertEquals(expectedViewPerPage, actualViewPerPage);
    }
}
