package com.cydeo.tests.day05_testNG_intro_dropDowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T2_radioButtonHandle {
    public static void main(String[] args) throws InterruptedException {

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

        if (hockeyButton.isSelected()){
            System.out.println("Button is selected.Verification PASSED!");
        }else {
            System.out.println("Button is not selected.Verification Failed!");
        }

        Thread.sleep(3000);
        driver.quit();


    }
}
