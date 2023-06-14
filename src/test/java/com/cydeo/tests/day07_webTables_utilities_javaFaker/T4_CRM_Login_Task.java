package com.cydeo.tests.day07_webTables_utilities_javaFaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_CRM_Login_Task {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Create new test and make set-ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1_crm() {
        //3. Enter valid username
        WebElement inputUserName=driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUserName.sendKeys("helpdesk1@cydeo.com");
        //4. Enter valid password
        WebElement inputPassword=driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputUserName.sendKeys("UserUser");
        //5. Click to `Log In` button
        WebElement loginButton=driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver,"(2) Portal");


    }

    @Test
    public void test1_crm2() {
        //Login in using the utility method we created in CRM_Utilities class
        CRM_Utilities.login_crm(driver);

        //6. Verify title is as expected:
        //Expected: Portal
        //We are waiting 3 sec for title to be loaded to "(2) Portal"
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver,"(2) Portal");


    }

    @Test
    public void test1_crm3() {
        //Login in using the utility method we created in CRM_Utilities class
        //CRM_Utilities.login_crm(driver,"helpdesk1@cydeo.com","UserUser");
        CRM_Utilities.login_crm(driver,"helpdesk2@cydeo.com","UserUser");

        //6. Verify title is as expected:
        //Expected: Portal
        //We are waiting 3 sec for title to be loaded to "(2) Portal"
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver,"(2) Portal");


    }

}
