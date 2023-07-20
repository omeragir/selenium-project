package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;

public class VYTrackPage {

    public VYTrackPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//button[@class='close'])[1]")
    public WebElement applicationAlertMessage;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement permissionAlertMessage;

}
