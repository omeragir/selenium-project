package com.cydeo.tests.review.week2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {

        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to https://practice.cydeo.com/login
        driver.get("https://practice.cydeo.com/login");

        // 3. Enter username: "tomsmith"
        WebElement userNameBox = driver.findElement(By.name("username"));
        userNameBox.sendKeys("tomsmith");
        Thread.sleep(2000);

        // 4. Enter password: "SuperSecretPassword"
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='password']"));
        passwordBox.sendKeys("SuperSecretPassword");
        Thread.sleep(2000);

        // 5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[.='Login']"));
        loginButton.click();

        // 6. Verify text displayed on page
        //    Expected: "You logged into a secure area!"

        String expectedText = "You logged into a secure area!";
        //WebElement actualTestArea = driver.findElement(By.cssSelector("flash.success"));
       // WebElement actualTestArea = driver.findElement(By.xpath("//div[@class='flash success']"));
        //if you have a space use this method normalize-space()
        WebElement actualTestArea = driver.findElement(By.xpath("//div[normalize-space(text())='You logged into a secure area!']"));
        Thread.sleep(2000);
        String actualText = actualTestArea.getText();

        if (actualText.contains(expectedText)) {
            System.out.println("Text verification Passed!");
        } else {
            System.out.println("Text verification Failed!");
            System.out.println("actualText = " + actualText);
            System.out.println("expectedText = " + expectedText);
        }

        Thread.sleep(2000);
        driver.quit();


    }
}
