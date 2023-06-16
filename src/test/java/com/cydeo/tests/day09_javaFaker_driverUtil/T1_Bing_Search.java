package com.cydeo.tests.day09_javaFaker_driverUtil;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_Bing_Search {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        //1- Open a Chrome browser

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- Go to: https://bing.com
        driver.get(ConfigurationReader.getProperty("bingURL"));
        WebElement cookies = driver.findElement(By.xpath("//button[@id='bnp_btn_reject']"));
        cookies.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void bingSearch_test() {
        //Use `configuration.properties` for the following:
        //1. The browser type
        //2. The URL
        //3. The search keyword
        //4. Make title verification dynamic. If search value changes, title
        //assertion should not fail.
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='sb_form_q']"));

        //3- Write “apple” in search box
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //4- Verify title:
        String expectedTitle = ConfigurationReader.getProperty("searchValue") + " - Suchen";
        BrowserUtils.sleep(2);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}

