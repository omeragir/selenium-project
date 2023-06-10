package com.cydeo.tests.day05_testNG_intro_dropDowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_TestNG_Selenium_Practice {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1.Open Chrome browser
         driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2.Go to https://www.cydeo.com
        driver.get("https://www.cydeo.com");

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }


    @Test
    public void test1_cydeo_title_verification() {

        //3.Verify title:

        String actualTitle=driver.getTitle();
        String expected="Cydeo";

        Assert.assertEquals(actualTitle,expected);


    }



}
