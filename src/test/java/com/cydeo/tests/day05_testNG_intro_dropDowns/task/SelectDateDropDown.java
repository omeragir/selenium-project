package com.cydeo.tests.day05_testNG_intro_dropDowns.task;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectDateDropDown {
    WebDriver driver;

    //1. Open Chrome browser
    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }



    @Test
    public void selectDate() {
        //3. Select “December 1st, 1933” and verify it is selected.
        //Select year using : visible text
        //Select month using : value attribute
        //Select day using : index number

        WebElement findYear = driver.findElement(By.xpath("//select[@id='year']"));
        Select selectYear = new Select(findYear);
        selectYear.selectByVisibleText("1933");

        WebElement findMonth = driver.findElement(By.xpath("//select[@id='month']"));
        Select selectMonth = new Select(findMonth);
        selectMonth.selectByValue("11");

        WebElement findDay = driver.findElement(By.xpath("//select[@id='day']"));
        Select selectDay = new Select(findDay);
        selectDay.selectByIndex(0);

        String expectedYear="1933";
        String expectedMonth="December";
        String expectedDay="1";

        String actualYear= selectYear.getFirstSelectedOption().getText();
        Assert.assertEquals(actualYear,expectedYear);

        String actualMonth= selectMonth.getFirstSelectedOption().getText();
        Assert.assertEquals(actualMonth,expectedMonth);

        String actualDay= selectDay.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDay,expectedDay);


    }


}
