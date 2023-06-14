package com.cydeo.utilities;
/*
This class will store the method related to CRM project
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {
    /*
    This method will log in using below credentials
    @UserName:helpdesk1@cydeo.com
    @Password:UserUser
     */

    public static void login_crm(WebDriver driver){

        //3. Enter valid username
        WebElement inputUserName=driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUserName.sendKeys("helpdesk1@cydeo.com");
        //4. Enter valid password
        WebElement inputPassword=driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputUserName.sendKeys("UserUser");
        //5. Click to `Log In` button
        WebElement loginButton=driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

    }

    public static void login_crm(WebDriver driver,String username,String password){

        //3. Enter valid username
        WebElement inputUserName=driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUserName.sendKeys(username);
        //4. Enter valid password
        WebElement inputPassword=driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputUserName.sendKeys(password);
        //5. Click to `Log In` button
        WebElement loginButton=driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

    }

}
