package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_Google_Search {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https:www.google.com");
        //cookies passed
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[id='L2AGLb']")).click();

        //locate search box
        WebElement search = driver.findElement(By.name("q"));
        Thread.sleep(3000);
        //enter ""apple" key,and press enter    //Press enter to search
        search.sendKeys("apple" + Keys.ENTER);
    }

}
/*
TC#3: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Press ENTER to search
5- Verify title:
Expected: Title should start with “apple” word
 */