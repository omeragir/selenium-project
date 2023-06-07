package com.cydeo.tests.day03_cssSelector_xPath.task;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ZeroBankHeader {
    public static void main(String[] args) {

        /*
        HWP #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");
        //WebElement header=driver.findElement(By.xpath("//h3"));
        WebElement header=driver.findElement(By.cssSelector("h3"));

        String expectedHeader="Log in to ZeroBank";
        String actualHeader=header.getText();

        if (actualHeader.equals(expectedHeader)){
            System.out.println("Header verification Passed!");
        }else {
            System.out.println("Header verification Failed!");
            System.out.println("actualHeader = " + actualHeader);
            System.out.println("expectedHeader = " + expectedHeader);
        }


    }
}
