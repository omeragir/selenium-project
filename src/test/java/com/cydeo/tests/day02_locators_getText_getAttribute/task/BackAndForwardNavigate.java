package com.cydeo.tests.day02_locators_getText_getAttribute.task;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndForwardNavigate {
    public static void main(String[] args) {

     /*
     TC #3: Back and forth navigation
1- Open a Chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
      */

        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");

        WebElement cookies = driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div"));
        cookies.click();

        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        gmailLink.click();

        String expectedGmailText = "Gmail";
        String actualGmailTitle = driver.getTitle();
        System.out.println("actualGmailTitle = " + actualGmailTitle);

        if (actualGmailTitle.contains(expectedGmailText)) {
            System.out.println("Gmail title verification Passed!");
        } else {
            System.out.println("Gmail title verification Failed!");
        }
        driver.navigate().back();

        String expectedDriverTitle="Google";
        String actualDriverTitle=driver.getTitle();
        if (actualDriverTitle.equals(expectedDriverTitle)){
            System.out.println("Driver title verification Passed!");
        }else{
            System.out.println("Driver title verification Failed!");
        }

        driver.close();

    }
}
