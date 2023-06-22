package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Registration_Form {

    @Test
    public void registration_form(){
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.URL"));

        WebElement firstName=Driver.getDriver().findElement(By.name("firstname"));
        Faker faker=new Faker();
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName=Driver.getDriver().findElement(By.name("lastname"));
        lastName.sendKeys(faker.name().lastName());

        WebElement userName=Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("JaneDoe");

        WebElement email=Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement password=Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.internet().password());

        WebElement phone=Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys(faker.numerify("571-###-####"));

        WebElement gender=Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        gender.click();

        WebElement date=Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        date.sendKeys("01/01/1992");

        Select selectDepartment=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        selectDepartment.selectByVisibleText("Department of Engineering");

        Select selectJobTitle=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        selectJobTitle.selectByIndex(1);

        WebElement program=Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        program.click();

        WebElement signInButton=Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        signInButton.click();

        WebElement successMessage=Driver.getDriver().findElement(By.xpath("//div[@role='alert']"));
        Assert.assertTrue(successMessage.isDisplayed());

        Driver.closeDriver();

    }


    //3. Enter first name
    //4. Enter last name
    //5. Enter username
    //6. Enter email address
    //7. Enter password
    //8. Enter phone number
    //9. Select a gender from radio buttons
    //10.Enter date of birth
    //11.Select Department/Office
    //12.Select Job Title
    //13.Select programming language from checkboxes
    //14.Click to sign up button
    //15.Verify success message “You’ve successfully completed registration.” is
    //displayed.
}
