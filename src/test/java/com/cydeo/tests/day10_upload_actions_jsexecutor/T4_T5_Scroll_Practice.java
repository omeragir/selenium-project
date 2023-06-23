package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_T5_Scroll_Practice {

    @Test
    public void t4_t5_scrolling_practice(){
        //TC #4: Scroll practice
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/

        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        //Locate CYDEO link element
        WebElement cydeoLink=Driver.getDriver().findElement(By.linkText("CYDEO"));

       //Create Actions class object
        Actions actions=new Actions(Driver.getDriver());
        //4- Scroll using Actions class “moveTo(element)” method
        BrowserUtils.sleep(2);
        actions.moveToElement(cydeoLink).perform();



        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button
        BrowserUtils.sleep(2);
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();

        Driver.closeDriver();
    }

}
