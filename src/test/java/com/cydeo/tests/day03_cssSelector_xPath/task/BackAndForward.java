package com.cydeo.tests.day03_cssSelector_xPath.task;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BackAndForward {
    public static void main(String[] args) throws InterruptedException {

        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //cookies button
        WebElement cookies = driver.findElement(By.xpath("//button[@class='tHlp8d']"));
        cookies.click();
        Thread.sleep(3000);

        //Search box apple write-enter-navigate back
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("apple" + Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();


        //3- Click to Gmail from top right.
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        gmailLink.click();

        //4- Verify title contains:
        //Expected: Gmail
        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification Passed!");
        } else {
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("Title verification Failed");
        }
        Thread.sleep(3000);

        //5- Go back to Google by using the .back();
        driver.navigate().back();


        //6- Verify title equals:
        //Expected: Google
        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();

        if (actualGoogleTitle.equals(expectedGoogleTitle)) {
            System.out.println("Google title verification Passed!");
        } else {
            System.out.println("actualGoogleTitle = " + actualGoogleTitle);
            System.out.println("expectedGoogleTitle = " + expectedGoogleTitle);
            System.out.println("Google title verification Failed");
        }
        //driver.quit();

    }
}
