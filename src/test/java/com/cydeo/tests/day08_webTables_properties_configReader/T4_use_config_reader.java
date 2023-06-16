package com.cydeo.tests.day08_webTables_properties_configReader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_use_config_reader {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1- Open a Chrome browser
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2- Go to: https://google.com
        driver.get(ConfigurationReader.getProperty("googleURL"));
        //Cookies
        WebElement cookies = driver.findElement(By.xpath("//button[@id='W0wltc']"));
        cookies.click();
    }

    @Test
    public void google_search() {
        //3- Write “apple” in search box
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@name='q']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Google Search
        String expectedTitle=ConfigurationReader.getProperty("searchValue")+" - Google Suche";
        BrowserUtils.sleep(2);
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);


        //1. The browser type
        //2. The URL
        //3. The search keyword
        //4. Make title verification dynamic. If search value changes, title
        //assertion should not fail.


    }
}



