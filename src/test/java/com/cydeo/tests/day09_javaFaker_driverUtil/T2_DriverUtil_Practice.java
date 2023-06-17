package com.cydeo.tests.day09_javaFaker_driverUtil;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T2_DriverUtil_Practice {
/*
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        //1- Open a Chrome browser

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

 */

    @Test
    public void bingSearch_test() {


        //2- Go to: https://bing.com
        //    Driver.getDriver()-->will return me the "driver"
        //instead of writing "driver " from now on,we will write     Driver.getDriver()
        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));
        WebElement cookies = Driver.getDriver().findElement(By.xpath("//button[@id='bnp_btn_reject']"));
        cookies.click();

        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@id='sb_form_q']"));

        //3- Write “apple” in search box
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //4- Verify title:
        String expectedTitle = ConfigurationReader.getProperty("searchValue") + " - Suchen";
        BrowserUtils.sleep(2);
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void bingSearch_test2() {


        //2- Go to: https://bing.com
        //    Driver.getDriver()-->will return me the "driver"
        //instead of writing "driver " from now on,we will write     Driver.getDriver()
        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));
        WebElement cookies = Driver.getDriver().findElement(By.xpath("//button[@id='bnp_btn_reject']"));
        cookies.click();

        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@id='sb_form_q']"));

        //3- Write “apple” in search box
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //4- Verify title:
        String expectedTitle = ConfigurationReader.getProperty("searchValue") + " - Suchen";
        BrowserUtils.sleep(2);
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void tearDown() {
        //We won`t be using the selenium`s quit method directly anymore
        //Driver.getDriver().quit();--> no more using this method
        //We will use Driver.closeDriver();

        Driver.closeDriver();

    }

}
