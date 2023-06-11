package com.cydeo.tests.review.week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class RegistrationFormFilling {
    public static void main(String[] args) {

        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        // 3. Enter First name: "John"
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameBox.sendKeys("John");

        // 4. Enter Last name: "Smith"
        WebElement lastNameBox = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameBox.sendKeys("Smith");

        // 5. Enter Username: "johnsmith123"
        WebElement userNameBox = driver.findElement(By.xpath("//input[@name='username']"));
        userNameBox.sendKeys("johnsmith123");

        // 6. Enter Email address: "john.smith@email.com"
        WebElement emailBox = driver.findElement(By.xpath("//input[@name='email']"));
        emailBox.sendKeys("john.smith@email.com");

        // 7. Enter password: "John1234"
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='password']"));
        passwordBox.sendKeys("John1234");

        // 8. Enter Phone number: "123-456-7890"
        WebElement phoneNumberBox = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNumberBox.sendKeys("123-456-7890");

        // 9. Click to "Male" from Gender
        WebElement genderBox = driver.findElement(By.xpath("//input[@name='gender']"));
        genderBox.click();

        // 10. Enter Date of birth "01/28/1990"
        WebElement birthDayBox = driver.findElement(By.xpath("//input[@name='birthday']"));
        birthDayBox.sendKeys("01/28/1990");

        // 11. Select "Department of Engineering" from Department/Office dropdown
        WebElement departmentDropDown = driver.findElement(By.xpath("//select[@name='department']"));
        Select selectDepartment = new Select(departmentDropDown);
        selectDepartment.selectByIndex(1);

        // 12. Select "SDET" from Job title dropdown
        WebElement jobTitleDropDown = driver.findElement(By.xpath("//select[@name='job_title']"));
        Select selectJobTitle = new Select(jobTitleDropDown);
        selectJobTitle.selectByIndex(4);

        // 13. Click to "Java" from languages
        WebElement javaButton = driver.findElement(By.xpath("//input[@value='java']"));
        javaButton.click();

        // 14. Click to "Sign up" button
        WebElement signInButton = driver.findElement(By.xpath("//button[.='Sign up']"));
        signInButton.click();

        // 15. Verify text displayed on page
        //     Expected: "Well done!"

        String expectedText = "Well done!";
        WebElement actualHeaderText = driver.findElement(By.xpath("//h4"));
        String actualText = actualHeaderText.getText();

        if (actualText.equals(expectedText)){
            System.out.println("Text verification Passed!!");
        }else {
            System.out.println("Text verification Failed!!");
            System.out.println("actualText = " + actualText);
            System.out.println("expectedText = " + expectedText);
        }


    }
}
