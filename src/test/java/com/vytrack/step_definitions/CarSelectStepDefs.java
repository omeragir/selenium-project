package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.VYTrackPage;
import com.vytrack.utilities.BrowserUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class CarSelectStepDefs extends BasePage {

    VYTrackPage vyTrackPage = new VYTrackPage();
    List<WebElement> checkboxes = vyTrackPage.carsCheckboxes;

    @Given("the user is on the dashboard page")
    public void theUserIsOnTheDashboardPage() {
        BrowserUtilities.waitForTitleContains("Dashboard");
        BrowserUtilities.verifyTitle("Dashboard");

    }

    @When("user hovers over Fleet module and clicks Vehicles menu")
    public void user_hovers_over_fleet_module_and_clicks_vehicles_menu() {

        for (WebElement each : menuOptions) {
            if (each.getText().contains("Fleet")) {
                BrowserUtilities.hover(each);
            }
        }

        for (WebElement each : vyTrackPage.vehiclesMenuOptions) {
            if (each.getText().contains("Vehicles")) {
                each.click();
            }
        }
    }

    @Then("all the checkboxes should be unchecked by default")
    public void all_the_checkboxes_should_be_unchecked_by_default() {
        for (WebElement each : vyTrackPage.carsCheckboxes) {
            Assert.assertFalse(each.isSelected());
        }
    }

    @When("user checks the first checkbox")
    public void user_checks_the_first_checkbox() {
        vyTrackPage.selectAllCars.click();
    }

    @Then("all cars should be checked.")
    public void all_cars_should_be_checked() {
        for (WebElement each : vyTrackPage.carsCheckboxes) {
            Assert.assertTrue(each.isSelected());
        }
    }

    WebElement randomCheckbox;

    @When("user checks one of the cars randomly")
    public void user_checks_one_of_the_cars_randomly() {
        randomCheckbox = checkboxes.get(new Random().nextInt(checkboxes.size()));
        randomCheckbox.click();

    }

    @Then("a random car should be checked")
    public void a_random_car_should_be_checked() {
        Assert.assertTrue(randomCheckbox.isSelected());
    }


}
