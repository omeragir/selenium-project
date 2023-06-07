package com.cydeo.tests.day03_cssSelector_xPath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_xpath {
    public static void main(String[] args) {

        /*
        TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a Chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “Log in” button text is as expected:
Expected: Log In
PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button from
         */
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/");

        String expectedLogInText="Log In";


        //WebElement loginButton=driver.findElement(By.className("login-btn"));


        //tagName[@attribute='value'
        //WebElement loginButton=driver.findElement(By.xpath("//input[@type='submit']"));

        WebElement loginButton=driver.findElement(By.xpath("//input[@value='Log In']"));

        String actualLoginText=loginButton.getAttribute("value");

        if (actualLoginText.equals(expectedLogInText)){
            System.out.println("Log in button text verification Passed!!");
        }else {
            System.out.println("Log in button text verification Failed!!");
        }

        //  driver.close();



    }
}

