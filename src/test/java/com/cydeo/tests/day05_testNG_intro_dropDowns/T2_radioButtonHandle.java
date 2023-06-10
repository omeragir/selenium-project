package com.cydeo.tests.day05_testNG_intro_dropDowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T2_radioButtonHandle {
    public static void main(String[] args) throws InterruptedException {
        /*


3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
         */

        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/radio_buttons

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/radio_buttons");

        //3. Click to “Hockey” radio button
        WebElement hockeyButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyButton.click();;

        System.out.println("hockeyButton.isDisplayed(),expecting true = " + hockeyButton.isDisplayed());

        Thread.sleep(3000);
        driver.quit();


    }
}
