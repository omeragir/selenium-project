package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage {
    public CalendarEventsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='btn main-group btn-primary pull-right ']")
    public WebElement createCalendarEventButton;

    @FindBy(xpath = "//input[@data-name='recurrence-repeat']")
    public WebElement repeatButton;
}
