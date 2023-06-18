package com.cydeo.tests.review.week3;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaFaker_Properties_Practice {

    @Test
    public void faker_userName_password() {

        Driver.getDriver().get(ConfigurationReader.getProperty("cydeoLoginURL"));
        WebElement userNameBox = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));

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
        String expectedText = "Your username is invalid!\n" + "×";
        WebElement text = Driver.getDriver().findElement(By.xpath("//div[@class='flash error']"));
        String actualText = text.getText();

        Assert.assertEquals(actualText, expectedText);

    }

}
