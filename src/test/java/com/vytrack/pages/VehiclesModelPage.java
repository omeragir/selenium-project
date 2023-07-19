package com.vytrack.pages;


import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehiclesModelPage {

    public VehiclesModelPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    //VehiclesModelPage for store and sales managers
    @FindBy(xpath = ("(//*[@class='grid-header-row'])[1]/th/a"))
    public List<WebElement> menuNames;


    //VehiclesModelPage for truck drivers
    @FindBy(css = "#flash-messages > div > div > div > div")
    public WebElement messageElement;


    //DashboardPage
    @FindBy(css = "#main-menu > ul > li:nth-child(2) > a > span")
    public WebElement fleetTab;

    @FindBy(css = "#main-menu > ul > li:nth-child(1) > a")
    public WebElement driverFleetTab;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[9]/a/span")
    public WebElement vehiclesModel;

    @FindBy(xpath = "//span[@class='title title-level-2']")
    public WebElement driverVehiclesModel;


}
