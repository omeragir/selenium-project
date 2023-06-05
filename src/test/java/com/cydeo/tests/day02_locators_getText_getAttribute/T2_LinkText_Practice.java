package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkText_Practice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        //1- Open a chrome browser
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        driver.findElement(By.linkText("A/B Testing")).click();

        //Thread.sleep(3000);
        String expectedTitle = "A/B Testing";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification Passed!");

        } else {

            System.out.println("Title verification Fail!");
        }

        driver.navigate().back();

        expectedTitle="Practice";
        actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification Passed!");

        } else {

            System.out.println("Title verification Fail!");
        }


    }
}
/*
TC #2: Back and forth navigation
1- Open a chrome browser
2- Go to: https://practice.cydeo.com
3- Click to A/B Testing from top of the list.
4- Verify title is:
Expected: No A/B Test
5- Go back to home page by using the .back();
6- Verify title equals:
Expected: Practice
 */