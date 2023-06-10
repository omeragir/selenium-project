package com.cydeo.tests.day05_testNG_intro_dropDowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5_dropdown_intro {
    WebDriver driver;
    //4. Verify “State selection” default selected value is correct
    //Expected: “Select a State”

    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void simple_dropdown_test() {


        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”

        //Locating the dropdown as a web element
        WebElement simpleDropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));

        //Creating Select class object,and passing dropdown web element into the constructor
        Select select = new Select(simpleDropDown);

        String expectedDefaultValue = "Please select an option";

        //Actual:
        String actualDefaultValue = select.getFirstSelectedOption().getText();

        //Do our assertion
        Assert.assertEquals(actualDefaultValue, expectedDefaultValue);
        Assert.assertTrue(actualDefaultValue.equals(expectedDefaultValue));

        // 4. Verify “State selection” default selected value is correct


        //Create Select object,and also locate the dropdown itself in my constructor
        Select stateDropDown=new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //Expected: “Select a State”
        String expectedDefaultStateValue = "Select a State";

        //Actual:
        String actualDefaultStateValue = stateDropDown.getFirstSelectedOption().getText();

        //Do our assertion
        Assert.assertEquals(actualDefaultStateValue, expectedDefaultStateValue);
        Assert.assertTrue(actualDefaultStateValue.equals(expectedDefaultStateValue));


    }


}
