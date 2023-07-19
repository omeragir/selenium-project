package com.vytrack.step_definitions;

import com.vytrack.pages.PinbarPage;
import com.vytrack.utilities.BrowserUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class US03StepDefs {


    PinbarPage pinbarPage = new PinbarPage();


    @Given("user is on the dashboard page")
    public void user_is_on_the_dashboard_page() {

        BrowserUtilities.waitForTitleContains("Dashboard");
        BrowserUtilities.verifyTitle("Dashboard");

    }

    @When("user clicks Learn how to use this space link")
    public void user_clicks_link() {

        pinbarPage.pinBarLearnLink.sendKeys(Keys.ENTER);
    }


    @Then("user should see {string}")
    public void user_should_see(String expectedHeader) {

        BrowserUtilities.waitForVisibility(pinbarPage.header, 3);

        String actualHeader = pinbarPage.header.getText();
        Assert.assertEquals(expectedHeader, actualHeader);

    }

    @Then("user sees {string}")
    public void user_should_see_use_pin_icon_on_the_right_top_corner_of_page_to_create_fast_access_link_in_the_pinbar(String expectedText) {

        BrowserUtilities.waitForVisibility(pinbarPage.pinBarText, 2);
        String actualText = pinbarPage.pinBarText.getText();

        Assert.assertEquals(expectedText, actualText);

    }


    @Then("user should see an image on the page.")
    public void userShouldSeeAnImageOnThePage() {

        Assert.assertTrue(pinbarPage.pinBarImage.isDisplayed());

    }


}
