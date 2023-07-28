package com.vytrack.step_definitions;

import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.Before;

import java.time.Duration;

public class Hooks {
    //import the @Before coming from io.cucumber.java
    @Before(order = 1)
    public void setupMethod() {

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    //@Before (value = "@login", order = 2 )
    public void login_scenario_before() {
        System.out.println("---> @Before: RUNNING BEFORE EACH SCENARIO");
    }

    /*
    @After will be executed automatically after EVERY scenario in the project.
     */
    @After
    public void teardownMethod(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }


        BrowserUtilities.sleep(2);
        Driver.closeDriver();

    }

    //@BeforeStep
    public void setupStep() {
        System.out.println("-----> @BeforeSTEP : Running before each step!");
    }

    //@AfterStep
    public void teardownStep() {
        System.out.println("-----> @AfterSTEP : Running after each step!");
    }


}

