package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.ErrorMessage;
import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class ErrorMessageVisibility_StepDefs extends ErrorMessage {
    LoginPage loginPage = new LoginPage();
    ErrorMessage errorMessage = new ErrorMessage();

    @When("user hovers over Activities module and clicks Calendar Events menu")
    public void user_hovers_over_activities_module_and_clicks_calendar_events_menu() {
        navigateToModule("Activities", "Calendar Events");
        //us09Page.activities.click();
        //us09Page.calendarEvent.click();

    }

    @Then("user is on the Calendar Events page and clicks Create Calendar Event button.")
    public void user_is_on_the_calendar_events_page_and_clicks_create_calendar_event_button() {
        BrowserUtilities.waitForVisibility(errorMessage.createCalendarEvent, 25);
        errorMessage.createCalendarEvent.sendKeys(Keys.ENTER);
    }

    @Then("user click Repeat checkbox icon")
    public void user_click_repeat_checkbox_icon() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", repeatCheckBox);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", repeatCheckBox);
    }

    @Then("user enters less than one in Repeat Every part")
    public void user_enters_less_than_one_in_repeat_every_part() {
        errorMessage.repeatEveryPart.clear();
        errorMessage.newRepeatInput.sendKeys("-5" + Keys.ENTER);
    }


    @Then("user see {string} error message")
    public void user_see_error_message(String expectedError) {
        //String expectedError = "The value have not to be less than 1.";
        String actualErrorMessage = errorMessage.errorMessage1.getText();
        Assert.assertEquals(actualErrorMessage, expectedError);
    }

    @Then("user enters more than ninety nine in Repeat Every part")
    public void user_enters_more_than_ninety_nine_in_repeat_every_part() {
        errorMessage.repeatEveryPart.clear();
        errorMessage.newRepeatInput.sendKeys("150" + Keys.ENTER);


    }

    @Then("user see {string} new error message")
    public void user_see_new_error_message(String expectedError) {
        //String expectedError = "The value have not to be more than 99.";
        String actualErrorMessage = errorMessage.errorMessage1.getText();
        Assert.assertEquals(actualErrorMessage, expectedError);
    }


}
