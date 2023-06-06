package com.cydeo.tests.day03_cssSelector_xPath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_NextBaseCrm {
    public static void main(String[] args) {

        /*
        TC #1: NextBaseCRM, locators and getText() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password
PS: Inspect and decide which locator you should be using to locate web
elements.
         */
        // WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com");

        WebElement userLogin = driver.findElement(By.name("USER_LOGIN"));

        userLogin.sendKeys("incorrect");

        WebElement userPassword = driver.findElement(By.name("USER_PASSWORD"));

        userPassword.sendKeys("incorrect");

        WebElement loginButton = driver.findElement(By.className("login-btn"));

        loginButton.click();

        String expectedErrorText = "Incorrect login or password";
        String actualErrorText = driver.findElement(By.className("errortext")).getText();

        if (actualErrorText.equals(expectedErrorText)) {
            System.out.println("Error text verification Passed!");
        } else {
            System.out.println("Error text verification Fail!");
        }

        //driver.quit();


    }
}
