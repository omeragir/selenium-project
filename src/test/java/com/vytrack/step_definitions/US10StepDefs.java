package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.US10Page;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US10StepDefs extends BasePage {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    US10Page us10Page = new US10Page();


    @When("user hovers over the Activities module")
    public void user_hovers_over_the_activities_module() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(us10Page.activities).perform();
    }

    @When("user  clicks on the Calendar Events button.")
    public void user_clicks_on_the_calendar_events_button() {

       // wait.until(ExpectedConditions.visibilityOf(us10Page.calendarEvent));
        us10Page.calendarEvent.click();
    }

    @When("user clicks on the Create Calendar Event button.")
    public void user_clicks_on_the_create_calendar_event_button() {
        wait.until(ExpectedConditions.titleContains("Calendar Events - Activities"));
        us10Page.createCalendarEvent.sendKeys(Keys.ENTER);
    }

    @When("user  enter \"Scrum daily message\" text  in the Description field")
    public void user_enter_a_in_the_description_field() {

        wait.until(ExpectedConditions.titleContains("Create Calendar"));
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Create Calendar event"));

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@title='Rich Text Area. Press ALT-F9 for menu. Press ALT-F10 for toolbar. Press ALT-0 for help']")));
//iframe[@id='oro_calendar_event_form_description-uid-64b7dcd4783f3_ifr']"
        WebElement descriptionField = Driver.getDriver().findElement(By.xpath("//*[@id=\"tinymce\"]"));

      descriptionField.sendKeys("Scrum daily message");
        Assert.assertTrue(descriptionField.isDisplayed());
    }

    @Then("the event with the description should be created successfully")
    public void the_event_with_the_description_should_be_created_successfully() {
        WebElement message = Driver.getDriver().findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        String actual =  message.getText();
        String expected = "Scrum daily message";

        Assert.assertEquals(expected,actual);
    }
}