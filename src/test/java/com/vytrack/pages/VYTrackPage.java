package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VYTrackPage {

    public VYTrackPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='title title-level-2']")
    public List<WebElement> vehiclesMenuOptions;

    @FindBy(xpath = "//input[@data-role='select-row-cell']")
    public List<WebElement> carsCheckboxes;

    @FindBy(xpath = "//button[@class='btn btn-default btn-small dropdown-toggle']/input")
    public WebElement selectAllCars;



    @FindBy(xpath = "(//button[@class='close'])[1]")
    public WebElement applicationAlertMessage;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement permissionAlertMessage;

}
