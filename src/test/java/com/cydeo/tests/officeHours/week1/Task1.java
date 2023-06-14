package com.cydeo.tests.officeHours.week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task1 {

    public static void main(String[] args) {
        //  1-open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //  2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");

        //  3-verify Login is displayed
        String expectedTitle="Login";
        WebElement loginLink=driver.findElement(By.linkText("LOGIN"));
        loginLink.click();

        String actualTitle=driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification Passed!");
        }else {
            System.out.println("Title verification Failed!");
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("expectedTitle = " + expectedTitle);
        }
        driver.quit();





    }




}
