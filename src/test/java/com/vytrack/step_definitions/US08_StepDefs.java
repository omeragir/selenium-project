package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US08_StepDefs extends BasePage {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();


    @When("user clicks on the {string} tab and then selects {string} module")
    public void user_clicks_on_the_tab_and_then_selects_module(String tab, String module) {

        navigateToModule(tab, module);
        BrowserUtilities.sleep(3);


    }

    @Then("user is on the {string} page")
    public void user_is_on_the_page(String expectedInTitle) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));

    }

    @Then("user clicks on the Create Calendar Event button")
    public void user_clicks_on_the_create_calendar_event_button() {
        wait.until(ExpectedConditions.visibilityOf(calendarEventsPage.createCalendarEventButton));
        calendarEventsPage.createCalendarEventButton.click();
    }

    @Then("user is on the Create Calendar event page")
    public void user_is_on_the_create_calendar_event_page() {
        wait.until(ExpectedConditions.titleContains("Create Calendar"));
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Create Calendar event"));

    }

    @Then("user clicks on the Repeat checkbox")
    public void user_clicks_on_the_repeat_checkbox() {

        WebElement element = calendarEventsPage.repeatButton;
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);

    }

    @Then("user sees the number {string} selected by default")
    public void user_sees_the_number_selected_by_default(String expectedNum) {
        WebElement repeatEveryBox = Driver.getDriver().findElement(By.ByXPath.xpath("(//input[@class='recurrence-subview-control__number'])[1]"));
        Assert.assertEquals(expectedNum, repeatEveryBox.getAttribute("value"));
    }


    @When("user deletes {string}")
    public void user_deletes(String num1) {
        WebElement repeatEveryBox = Driver.getDriver().findElement(By.ByXPath.xpath("(//input[@class='recurrence-subview-control__number'])[1]"));
        repeatEveryBox.clear();


    }

    @Then("user sees the error message {string}")
    public void user_sees_the_error_message(String expectedMessage) {
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//span[.='This value should not be blank.']//span/span"));
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


}

