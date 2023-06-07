package com.cydeo.tests.day02_locators_getText_getAttribute.task;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassLocatorPractice {
    public static void main(String[] args) throws InterruptedException {
        /*
        TC #4: Practice Cydeo – Class locator practice
1- Open a Chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected:
Expected: Practice
PS: Locate “Home” link using “className” locator
         */

        WebDriverManager.chromiumdriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/inputs");
       // WebElement homeButton=driver.findElement(By.linkText("Home"));
        WebElement homeButton=driver.findElement(By.className("nav-link"));
        Thread.sleep(2000);
        homeButton.click();

        String expectedTitle="Practice";
        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification Passed!");
        }else {
            System.out.println("Title verification Failed!");
        }



    }
}
