package com.cydeo.tests.review.week3;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AlertPractice {
    @Test
    public void alert_practice_test1() {
        // 1. Open browser
        // 2. Go to website: https://practice.cydeo.com/javascript_alerts
        Driver.getDriver().get("https://practice.cydeo.com/javascript_alerts");

        WebElement jsAlertButton = Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertButton.click();
        BrowserUtils.sleep(2);

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        String expectedAlertTExt="You successfully clicked an alert";
        WebElement alertText= Driver.getDriver().findElement(By.id("result"));
        String actualAlertText=alertText.getText();

    }

    @Test
    public void alert_practice_test2() {
        // 1. Open browser
        // 2. Go to website: https://practice.cydeo.com/javascript_alerts
        Driver.getDriver().get("https://practice.cydeo.com/javascript_alerts");

        WebElement jsAlertButton = Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsAlertButton.click();
        BrowserUtils.sleep(2);

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        String expectedAlertTExt="You clicked: Ok";
        WebElement alertText= Driver.getDriver().findElement(By.id("result"));
        String actualAlertText=alertText.getText();

    }

    @Test
    public void alert_practice_test3() {
        // 1. Open browser
        // 2. Go to website: https://practice.cydeo.com/javascript_alerts
        Driver.getDriver().get("https://practice.cydeo.com/javascript_alerts");

        WebElement jsAlertButton = Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsAlertButton.click();
        BrowserUtils.sleep(2);

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        String expectedAlertTExt="You entered: hello";
        WebElement alertText= Driver.getDriver().findElement(By.id("result"));
        String actualAlertText=alertText.getText();

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }



}
