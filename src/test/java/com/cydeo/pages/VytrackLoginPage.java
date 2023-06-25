package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VytrackLoginPage {
    public VytrackLoginPage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id="prependedInput")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    public WebElement password;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement loginBtn;

}
