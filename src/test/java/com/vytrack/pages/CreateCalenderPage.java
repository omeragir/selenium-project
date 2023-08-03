package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCalenderPage extends BasePage {

    public CreateCalenderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "loader-mask")
    public WebElement loadingBar;


    @FindBy(xpath = "(//button[@class='close'])[1]")
    public WebElement alert1;

    @FindBy(xpath = "//span[normalize-space()='Activities']")
    public WebElement activities;

    @FindBy(xpath = "//span[normalize-space()='Calendar Events']")
    public WebElement calendarEvent;

    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div/div/div[2]/div/a")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//*[@id=\"tinymce\"]")
    public WebElement descriptionField;

    @FindBy(xpath = "//iframe[@title='Rich Text Area. Press ALT-F9 for menu. Press ALT-F10 for toolbar. Press ALT-0 for help']")
    public WebElement iframe;

    @FindBy(xpath = "//*[@id=\"tinymce\"]/p")
    public WebElement message;

}
