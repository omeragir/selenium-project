package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehiclesModelPage extends BasePage {

    public VehiclesModelPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    //VehiclesModelPage for store and sales managers
    @FindBy(xpath = ("(//*[@class='grid-header-row'])[1]/th/a"))
    public List<WebElement> menuNames;


    //VehiclesModelPage for truck drivers
    @FindBy(css = "#flash-messages > div > div > div:nth-child(2) > div")
    public WebElement messageElement;

}
