package com.cydeo.tests.day05_testNG_intro_dropDowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T1_stateElementReferenceException {
    public static void main(String[] args) throws InterruptedException {

        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/add_remove_elements/
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //3. Click to “Add Element” button
        WebElement addElementButton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElementButton.click();

        //4. Verify “Delete” button is displayed after clicking.
        //5. Click to “Delete”
        WebElement deleteButton=driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("deleteButton.isDisplayed(), expecting true = " + deleteButton.isDisplayed());

        Thread.sleep(3000);
        deleteButton.click();

        //Verify “Delete” button is  not displayed after clicking.
        //use try/catch to handle and verify

        try {
            System.out.println("deleteButton.isDisplayed(),expecting false = " + deleteButton.isDisplayed());
        }catch (StaleElementReferenceException e){
            System.out.println("--->StaleElementReferenceException happened due to element being deleted from page.");
            System.out.println("Which concludes our test case -PASSING-");
            System.out.println("deleteButton.isDisplayed(),expecting =false  " );
        }

        Thread.sleep(3000);
        driver.quit();


    }

}
