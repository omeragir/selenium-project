package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5_window_handle_practice {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //2. Create new test and make set-ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3. Go to : https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void multiple_window_test() {

        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.equals(expectedTitle));

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        System.out.println("Before click title = " + driver.getTitle());

        //5. Click to: “Click Here” link
        WebElement clickHereLink = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereLink.click();
        System.out.println("After click title = " + driver.getTitle());


        //6. Switch to new Window. We need to use driver.getWindowHandles() method
        //driver.getWindowHandle();
        //1- windowHandle: mainHandle
        //2-  windowHandle: 2nd windowHandle

        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
            System.out.println("Current title while switching window " + driver.getTitle());
        }

        //7. Assert: Title is “New Window”
        String expectedTitleAfterClick = "New Window";
        String actualCurrentTitle = driver.getTitle();

        Assert.assertEquals(actualCurrentTitle, expectedTitleAfterClick);

        //if we have to go back to main page to continue our test case,
        // we can use mainHandle to switch

        driver.switchTo().window(mainHandle);

        //code

    }


}
