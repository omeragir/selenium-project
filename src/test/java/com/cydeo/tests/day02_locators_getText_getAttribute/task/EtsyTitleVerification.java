package com.cydeo.tests.day02_locators_getText_getAttribute.task;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyTitleVerification {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");
        Thread.sleep(3000);

        WebElement cookies=driver.findElement(By.xpath("//*[@id=\"gdpr-single-choice-overlay\"]/div/div[2]/div[2]/button"));
        cookies.click();

        WebElement searchBox=driver.findElement(By.id("global-enhancements-search-query"));
        Thread.sleep(3000);
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);

        String expectedTitle="Wooden spoon - Etsy DE";
        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification Passed!!");
        }else {
            System.out.println("Title verification Fail!!");
        }

        //driver.quit();
    }
}
/*
 HWP #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon - Etsy”

global-enhancements-search-query
Wooden spoon - Etsy DE
 */