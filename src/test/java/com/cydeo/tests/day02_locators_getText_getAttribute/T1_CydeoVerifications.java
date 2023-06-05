package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        driver.manage().window().maximize();

        Thread.sleep(3000);

        driver.navigate().to("https://practice.cydeo.com");

        String expectedInUrl = "cydeo";

        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedInUrl)) {

            System.out.println("URL verification Pass!!!");

        } else {

            System.out.println("URL verification Failed!!!");
        }

        String expectedTitle = "Practice";

        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification is Passed!!! ");
        } else {
            System.out.println("Title verification is Fail!!! ");
        }

        //browser close
        driver.close();


    }
}
/*
TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
4. Verify title:
 Expected: Practice
 */