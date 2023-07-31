package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehiclesModelPage;
import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ModelPageColumnVisibility_StepDefs extends BasePage {

    LoginPage loginPage = new LoginPage();
    Actions actions = new Actions(Driver.getDriver());
    VehiclesModelPage vehiclesModelPage = new VehiclesModelPage();


    @And("user hovers over {string} tab and click {string} module")
    public void userHoversOverTabAndClickModule(String tab, String module) {

        navigateToModule(tab, module);
    }

    @Then("user is navigated Vehicles Model page")
    public void user_is_navigated_vehicles_model_page() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleIs("All - Vehicles Model - Entities - System - Car - Entities - System"));

        String expectedTitle = "All - Vehicles Model - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals("Title verification failed!", expectedTitle, actualTitle);

    }


    @Then("should see below a total of ten columns")
    public void should_see_below_a_total_of_ten_columns(List<String> expectedMenu) {

        List<String> actualMenu = BrowserUtilities.getElementsText(vehiclesModelPage.menuNames);
        Assert.assertEquals(expectedMenu, actualMenu);

    }


    @Given("user is logged as a truck driver")
    public void user_is_logged_as_a_truck_driver() {
        loginPage.login(ConfigurationReader.getProperty("driver_username"), ConfigurationReader.getProperty("driver_password"));

    }


    @Then("user should see the error message {string}")
    public void user_should_see_the_error_message(String string) {
        BrowserUtilities.waitFor(5);
        String expectedErrorMessage = "You do not have permission to perform this action.";
        String actualMessage = vehiclesModelPage.messageElement.getText();
        Assert.assertEquals(expectedErrorMessage, actualMessage);


    }

    @When("driver hovers over {string} module and click {string} menu")
    public void driverHoversOverAndClickMenu(String tab, String module) {

        navigateToModule(tab, module);
    }


}
