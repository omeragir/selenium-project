package com.cydeo.tests.review.week2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class NavigateAndGetMethod {
    public static void main(String[] args) throws InterruptedException {




        // 1. Open a Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to: https://www.etsy.com
        driver.get("https://www.etsy.com");
        WebElement cookies = driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-mb-xs-0']"));
        cookies.click();

        // 3. Navigate to https://www.amazon.com/

        Thread.sleep(2000);
        driver.navigate().to("https://www.amazon.com/");
        // 4. Navigate back, forward and refresh

        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();

        // 5. Write “selenium” in search box
        // 6. Press search button to search
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Suche Amazon']"));
        searchBox.sendKeys("selenium" + Keys.ENTER);

        // 7. Verify title is "Amazon.com : selenium"
        String expectedTitle = "Amazon.com : selenium";
        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification Passed!!");
        }else {
            System.out.println("Title verification Failed!!");
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("expectedTitle = " + expectedTitle);
        }


        // 8. Verify url contains "selenium"

        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains("selenium")){
            System.out.println("Url verification Passed!!!");
        }else{
            System.out.println("Url verification Failed!");
            System.out.println("actualUrl = " + actualUrl);
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
