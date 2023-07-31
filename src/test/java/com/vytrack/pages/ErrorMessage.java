package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ErrorMessage {

    public WebDriverWait wait;

    public ErrorMessage() {
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[normalize-space()='Activities']")
    public WebElement activities;

    @FindBy(xpath = "//span[normalize-space()='Calendar Events']")
    public WebElement calendarEvent;

    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div/div/div[2]/div/a")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//input[@data-name='recurrence-repeat']")
    public WebElement repeatCheckBox;

    @FindBy(xpath = "//input[@class='recurrence-subview-control__number']")
    public WebElement repeatEveryPart;

    @FindBy(xpath = "//input[@class='recurrence-subview-control__number error']")
    public WebElement newRepeatInput;

    @FindBy(xpath = "(//*[@class=\"validation-failed\"]/span/span)[2]")
    public WebElement errorMessage1;

}
