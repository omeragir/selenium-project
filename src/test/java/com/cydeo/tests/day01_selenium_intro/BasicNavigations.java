package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        //Setup driver browser
        WebDriverManager.chromedriver().setup();

        //Create instance Chrome browser
        WebDriver driver = new ChromeDriver();

        //This line will maximize the currently opened browser
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();

        //Go to tesla.com
        driver.get("https://www.tesla.com");

        //use .getCurrentUrl() method to print out current URL
        String currentUrl=driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        String currentTitle=driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        //Use navigate back() to go back
        driver.navigate().back();

        //Stop execution for 3 second
        Thread.sleep(3000);

        //Use navigate forward() to go forward
        driver.navigate().forward();

        //Stop execution for 3 second
        Thread.sleep(3000);

        //User navigate refreshes the page using navigate.refresh();
        driver.navigate().refresh();

        //Stop execution for 3 second
        Thread.sleep(3000);

        //User navigate to google.com using navigate().to("write new URL")
        driver.navigate().to("https://www.google.com");

        //get title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());

        currentTitle=driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        //close only the currently focused window/tab
        driver.close();

        //close all-of- the opened browser
        driver.quit();



    }

}
