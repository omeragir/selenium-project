package com.vytrack.step_definitions;

import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Us02 {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @Given("user on the dashboard page")
    public void userOnTheDashboardPage() {

        String expectedTitle = "Dashboard";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }



    @When("user click the question icon")
    public void user_click_the_question_icon() {
        BrowserUtilities.sleep(2);
        WebElement questionIcon = Driver.getDriver().findElement(By.xpath("//a[@target='_blank']"));
        questionIcon.click();
    }

    @Then("user switch to the new window")
    public void user_switch_to_the_new_window() throws InterruptedException {

        Thread.sleep(2000);

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String handle : windowHandles) {

                Driver.getDriver().switchTo().window(handle);
            }
        }



    @And("user on the Oronic Documentation page")
    public void userOnTheOronicDocumentationPage() throws InterruptedException {

        Thread.sleep(2000);

        String currentUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://doc.oroinc.com/";

        Assert.assertEquals(currentUrl,expectedUrl);
    }


}
