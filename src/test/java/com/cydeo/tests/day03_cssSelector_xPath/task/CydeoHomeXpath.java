package com.cydeo.tests.day03_cssSelector_xPath.task;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CydeoHomeXpath {
    public static void main(String[] args) throws InterruptedException {


        // 1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        //2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");

        //3- Click to “Home” link
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        homeLink.click();


        //4- Verify title is as expected:
        //Expected: Practice

        String expectedHomeTitle = "Practice";
        String actualHomeTitle = driver.getTitle();
        if (actualHomeTitle.equals(expectedHomeTitle)) {
            System.out.println("Home title verification Passed!");
        } else {
            System.out.println("Home title verification Failed!");
            System.out.println("actualHomeTitle = " + actualHomeTitle);
            System.out.println("expectedHomeTitle = " + expectedHomeTitle);
        }
        Thread.sleep(3000);
        driver.quit();
        //PS: Locate “Home” link using “xpath” locator

    }
}
