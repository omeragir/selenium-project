package com.cydeo.tests.review.week3;

import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaFakerTask {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // 1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @Test
    public void test1() {
        // 2. Go to https://practice.cydeo.com/login
        driver.get("https://practice.cydeo.com/login");

        WebElement userNameBox = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='wooden_spoon']"));

        Faker faker = new Faker();
        String userName = faker.name().fullName();
        String password = faker.bothify("##??##?#?#");

        // 3. Enter username using java faker
        userNameBox.sendKeys(userName);
        // 4. Enter password using java faker
        passwordBox.sendKeys(password);
        // 5. Click to Log-in button
        loginButton.click();

        // 6. Verify text displayed on page
        //    Expected: "Your username is invalid!"
        String expectedText = "Your username is invalid!\n"+"×";
        WebElement text = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualText = text.getText();

        Assert.assertEquals(actualText,expectedText);

    }


}
