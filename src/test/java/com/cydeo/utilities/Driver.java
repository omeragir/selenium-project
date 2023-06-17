package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //Create a private constructor to remove access to this object
    private Driver() {
    }

    /*We make the WebDriver private,because we want to close access from outside the class
    We are making it static,because we will use it in static method
     */

    private static WebDriver driver;//default value=null

    /*Create a re-usable utility method which will return the same driver instance once we call it.
    -If an instance doesn`t exist,it will create first,and then it will always return same instance.
     */

    public static WebDriver getDriver() {
        if (driver == null) {

            /*We will read our browser type from configuration.properties file.
            This way,we can control which browser is opened from outside from our code.
             */
        String browserType=ConfigurationReader.getProperty("browser");
        /*
        Depending on the browserType returned from the configuration.properties
        switch statement determine the "case",and open the matching browser.
         */

        switch (browserType){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;

        }

        }
        return driver;
    }


}
