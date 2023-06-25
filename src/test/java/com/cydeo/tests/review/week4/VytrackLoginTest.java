package com.cydeo.tests.review.week4;

import com.cydeo.pages.VytrackLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class VytrackLoginTest {
    @Test

    public void vytrack_driver_login_test(){
        // TC: Vytrack app login test as Driver
        // 1- Open a Chrome browser
        // 2- Go to: https://qa3.vytrack.com/user/login
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));

        // 3. Enter username User1
        VytrackLoginPage vytrackLoginPage=new VytrackLoginPage();
        vytrackLoginPage.userName.sendKeys("User1");

        // 4. Enter password UserUser123
        vytrackLoginPage.password.sendKeys("UserUser123");
        // 5. Click to Log-in button
        vytrackLoginPage.loginBtn.click();

    }
}
