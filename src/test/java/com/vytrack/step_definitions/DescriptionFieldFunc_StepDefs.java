package com.vytrack.step_definitions;

import com.vytrack.pages.CreateCalenderPage;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DescriptionFieldFunc_StepDefs extends CreateCalenderPage {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    CreateCalenderPage createCalenderPage = new CreateCalenderPage();


    @When("user hovers over the Activities module")
    public void user_hovers_over_the_activities_module() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(createCalenderPage.activities).perform();
    }

    @When("user  clicks on the Calendar Events button.")
    public void user_clicks_on_the_calendar_events_button() {

        // wait.until(ExpectedConditions.visibilityOf(us10Page.calendarEvent));
        createCalenderPage.calendarEvent.click();
    }

    @When("user clicks on the Create Calendar Event button.")
    public void user_clicks_on_the_create_calendar_event_button() {
        wait.until(ExpectedConditions.titleContains("Calendar Events - Activities"));
        createCalenderPage.createCalendarEvent.sendKeys(Keys.ENTER);
    }

    @When("user  enter \"Scrum daily message\" text  in the Description field")
    public void user_enter_a_in_the_description_field() {

        wait.until(ExpectedConditions.titleContains("Create Calendar"));
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Create Calendar event"));

        Driver.getDriver().switchTo().frame(iframe);

        descriptionField.sendKeys("Scrum daily message");
        Assert.assertTrue(descriptionField.isDisplayed());
    }

    @Then("the event with the description should be created successfully")
    public void the_event_with_the_description_should_be_created_successfully() {
        String actual = message.getText();
        String expected = "Scrum daily message";

        Assert.assertEquals(expected, actual);
    }

}
