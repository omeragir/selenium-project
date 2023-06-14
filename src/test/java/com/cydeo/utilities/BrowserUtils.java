package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

/*
This clas will be storing only the utility methods that can be used across the project.
 */
public class BrowserUtils {

/*
This method will accept int(in seconds) and execute Thread.sleep method for given duration
Arg:int second
 */
public static void sleep(int second){
    second*=1000;
    try{
        Thread.sleep(second);
    }catch (InterruptedException e){

    }
}

public static void switchWindowAndVerifyTitle(WebDriver driver,String expectedInURL,String expectedTitle){

    //Return and store all window handles in a Set
    Set<String> allWindowHandles = driver.getWindowHandles();
    for (String each : allWindowHandles) {
        driver.switchTo().window(each);
        System.out.println("Currently URL:"+driver.getCurrentUrl());

        if (driver.getCurrentUrl().contains(expectedInURL)){
            break;
        }

    }


    //5. Assert: Title contains “”
    String actualTitle=driver.getTitle();
    Assert.assertEquals(actualTitle,expectedTitle);
}

public static void verifyTitle(WebDriver driver,String expectedTitle){
    Assert.assertEquals(driver.getTitle(),expectedTitle);
}

    public static void verifyTitleContains(WebDriver driver,String expectedTitle){
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }

}
