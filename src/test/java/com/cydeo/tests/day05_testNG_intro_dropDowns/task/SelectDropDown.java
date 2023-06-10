package com.cydeo.tests.day05_testNG_intro_dropDowns.task;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectDropDown {
   WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test (priority = 1)
    public void selectIllinoisMethod(){
        //3. Select Illinois
        Select selectIllinois=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        selectIllinois.selectByVisibleText("Illinois");

        String expectedIllinois="Illinois";
        String actualIllinois=selectIllinois.getFirstSelectedOption().getText();

        Assert.assertEquals(actualIllinois,expectedIllinois);
        Assert.assertTrue(actualIllinois.equals(expectedIllinois));

    }
    @Test (priority = 2)
    public void selectVirginiaMethod(){
        //4. Select Virginia
        Select selectVirginia=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        selectVirginia.selectByValue("VA");

        String expectedVirginia="Virginia";
        String actualVirginia=selectVirginia.getFirstSelectedOption().getText();

        Assert.assertEquals(actualVirginia,expectedVirginia);
        Assert.assertTrue(actualVirginia.equals(expectedVirginia));

    }
    @Test (priority = 3)
    public void selectCaliforniaMethod(){
        //5. Select California
        Select selectCalifornia=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        selectCalifornia.selectByIndex(5);

        String expectedCalifornia="California";
        String actualCalifornia=selectCalifornia.getFirstSelectedOption().getText();

        Assert.assertEquals(actualCalifornia,expectedCalifornia);
        Assert.assertTrue(actualCalifornia.equals(expectedCalifornia));

    }





    //6. Verify final selected option is California.
    //Use all Select options. (visible text, value, index)
}
