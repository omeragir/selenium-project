package com.cydeo.tests.day11_pom_explicitWaits;

import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class Understanding_closeDriver_method {

    @Test
    public void test1() {
        Driver.getDriver().get("https://google.com");

        //verify something
        //Driver.getDriver();-->driver
        //Driver.getDriver().quit();
        //Driver.getDriver().close();
        Driver.closeDriver();
    }

    @Test
    public void test2() {
        Driver.getDriver().get("https://google.com");
        //verify something else
        //Driver.getDriver().quit();
        //Driver.getDriver().close();
        Driver.closeDriver();
    }

    @Test
    public void test3() {
        Driver.getDriver().get("https://google.com");
        //verify something completely different
        // Driver.getDriver().quit();
        //Driver.getDriver().close();
        Driver.closeDriver();
    }

}
