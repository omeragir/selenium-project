package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorAlertPage extends BasePage {
    public ErrorAlertPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    //Dashboard error button for truck driver
    @FindBy(xpath = "(//button[@class='close'])[1]")
    public WebElement appAlertMsgButton;

    //Vehicle Contract Page error message text for truck driver
    @FindBy(xpath = "//div[@class='message']")
    public WebElement permissionAlertTextMessage;


    public void applicationAlertMessage() {
        BrowserUtilities.waitForClickablility(appAlertMsgButton, 1);
        appAlertMsgButton.click();
    }

    public void permissionAlertMessage(String expectedErrorMessage) {
        String actualMessage = permissionAlertTextMessage.getText();
        Assert.assertEquals(expectedErrorMessage, actualMessage);
    }

}
