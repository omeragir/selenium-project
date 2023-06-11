package com.cydeo.tests.review.week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RegistrationForm {
    public static void main(String[] args) {

        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        // 3. Verify title is as expected:
        // Expected: "Registration Form"

        String expectedTitle="Registration Form";
        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification Passed!");
        }else {
            System.out.println("Title verification Failed!");
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("expectedTitle = " + expectedTitle);
        }



    }
}
