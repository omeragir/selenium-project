package com.cydeo.tests.day05_testNG_intro_dropDowns.task;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectDropDownValue {

    WebDriver driver;


    @BeforeMethod
    public void setup() {
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @AfterMethod
    public void rearDown() {
        driver.close();
    }


    @Test
    public void selectDropDown() throws InterruptedException {

        //3. Click to non-select dropdown
        WebElement dropDownLinkButton = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        dropDownLinkButton.click();

        //4. Select Facebook from dropdown
        WebElement facebookLink = driver.findElement(By.linkText("Facebook"));
        facebookLink.click();

        //5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook – Anmelden oder Registrieren";
        Assert.assertTrue(actualTitle.equals(expectedTitle), "Title verification Failed!!");
    }


}
