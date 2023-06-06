package com.cydeo.tests.day03_cssSelector_xPath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_locator_getText_getAttribute {
    public static void main(String[] args) {

        /*
        TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a Chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes
PS: Inspect and decide which locator you should be using to locate web
elements.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/");

        String expectedLabelText = "Remember me on this computer";
        String actualLabelText = driver.findElement(By.className("login-item-checkbox-label")).getText();

        if (actualLabelText.equals(expectedLabelText)) {
            System.out.println("Label text verification Passed");
        } else {
            System.out.println("Label text verification Fail");
        }

        String expectedForgotLinkText = "FORGOT YOUR PASSWORD?";
        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        String actualLinkText = forgotPasswordLink.getText();

        if (actualLinkText.equals(expectedForgotLinkText)) {

            System.out.println("Link text verification Passed!");
        } else {
            System.out.println("expectedForgotLinkText = " + expectedForgotLinkText);
            System.out.println("actualLinkText = " + actualLinkText);
            System.out.println("Link text verification Fail!");
        }

        String expectedInHref="forgot_password=yes";
        String actualInHref=forgotPasswordLink.getAttribute("href");

        if (actualInHref.contains(expectedInHref)){
            System.out.println("HREF attribute value is Expected.Pass!!");
        }else {
            System.out.println("actualInHref = " + actualInHref);
            System.out.println("expectedInHref = " + expectedInHref);
            System.out.println("HREF attribute value is Expected.Fail!!");
        }

    }
}
