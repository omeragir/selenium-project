package com.cydeo.tests.day05_testNG_intro_dropDowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class T3_radioButtonUtility {
    public static void main(String[] args) throws InterruptedException {

        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/radio_buttons

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/radio_buttons");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //click and verify hockey radio button is selected
        clickAndVerifyRadioButton(driver,"sport","hockey");




        Thread.sleep(3000);
        driver.quit();


/*
Create a utility method to handle above logic.
Method name: clickAndVerifyRadioButton
Return type: void or boolean
Method args:
1. WebDriver
2. Name attribute as String (for providing which group of radio buttons)
3. Id attribute as String (for providing which radio button to be clicked)
Method should loop through the given group of radio buttons. When it finds the
matching option, it should click and verify option is Selected.
Print out verification: true
 */

    }
    private static void clickAndVerifyRadioButton(WebDriver driver,String nameAttribute,String expectedID){
        //Locate all-of the radio button,and store them in a List<WebElement>
       // List<WebElement>sportsRadioButton=driver.findElements(By.xpath("//input[@name='"+nameAttribute+"']"));
        List<WebElement>radioButton=driver.findElements(By.name(nameAttribute));
        for (WebElement each : radioButton) {
            String actualId= each.getAttribute("id");
            System.out.println("actualId = " + actualId);

            if (actualId.equals(expectedID)){
                each.click();
                System.out.println(actualId+" is selected "+each.isSelected());
                break;
            }

        }


    }



}