package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_T2_T3_information_alert_practice {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test
    public void information_alert_test1() throws InterruptedException {
        //3. Click to “Click for JS Alert” button
        WebElement jsForAlertButton=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsForAlertButton.click();
        Thread.sleep(2000);
        //4. Click to OK button from the alert
        Alert alert=driver.switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        String expectedAlertTExt="You successfully clicked an alert";
        WebElement alertText=driver.findElement(By.id("result"));
        String actualAlertText=alertText.getText();

        Assert.assertTrue(actualAlertText.equals(expectedAlertTExt),"Alert text verification Failed!!");

        //Failure message will only be displayed if assertion fails:
        Assert.assertTrue(alertText.isDisplayed(),"Result text is NOT displayed!!!");

    }
    @Test
    public void confirmation_alert_test2() throws InterruptedException {


        //3. Click to “Click for JS Confirm” button
        WebElement jsConfirmButton=driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsConfirmButton.click();
        Thread.sleep(2000);

        //4. Click to OK button from the alert
        Alert alert=driver.switchTo().alert();
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        String expectedAlertText="You clicked: Ok";
        WebElement alertText=driver.findElement(By.id("result"));
        String actualAlertText=alertText.getText();
        Assert.assertEquals(actualAlertText,expectedAlertText,"Text verification Failed!!");

    }
    @Test
    public void information_alert_test3() throws InterruptedException {

        //3. Click to “Click for JS Prompt” button
        WebElement jsPromptButton=driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPromptButton.click();

        //4. Send “hello” text to alert
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("hello");
        Thread.sleep(2000);

        //5. Click to OK button from the alert
        alert.accept();
        //6. Verify “You entered: hello” text is displayed.
        String expectedAlertText="You entered: hello";

        WebElement alertText=driver.findElement(By.id("result"));
        String actualAlertText=alertText.getText();
        Assert.assertEquals(actualAlertText,expectedAlertText,"Text verification Failed!!");

    }

}
