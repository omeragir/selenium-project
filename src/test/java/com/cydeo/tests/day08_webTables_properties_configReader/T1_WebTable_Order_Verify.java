package com.cydeo.tests.day08_webTables_properties_configReader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_WebTable_Order_Verify {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void order_verify_name_test() {
        //2. Verify Bob’s name is listed as expected.
        //below locator is locating me the Bob Martin`s cell as where it is currently stored.
        ////table[@class='SampleTable']/tbody/tr[7]/td[2]

        //locate Bob`s cell using its name as the text
        String locator="//table[@class='SampleTable']//td[.='Bob Martin']";
        WebElement bobCell = driver.findElement(By.xpath(locator));
        System.out.println("bobCell.getText() = " + bobCell.getText());

        //Expected: “Bob Martin”
        String expectedName = "Bob Martin";
        String actualName = bobCell.getText();
        Assert.assertEquals(actualName, expectedName, "Name are not matching!");

        //3. Verify Bob Martin’s order date is as expected
        //WebElement bobOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/../td[5]"));
        WebElement bobOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));

        //Expected: 12/31/2021
        String expectedBobDate = "12/31/2021";
        String actualBobDate=bobOrderDate.getText();
        System.out.println("actualBobDate = " + actualBobDate);
        Assert.assertTrue(actualBobDate.equals(expectedBobDate));


    }

    @Test
    public void test2_use_order_verify(){

        //call the utility method and created
        String alexandraGray=WebOrderUtils.returnOrderDate(driver,"Alexandra Gray");
        System.out.println("alexandraGray = " + alexandraGray);

    }
@Test
    public void test3(){
        WebOrderUtils.orderVerify(driver,"Bob Martin","12/31/2021");
}


}
