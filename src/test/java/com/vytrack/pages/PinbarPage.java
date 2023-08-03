package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinbarPage extends BasePage {

    public PinbarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[text()='Learn how to use this space']")
    public WebElement pinBarLearnLink;

    @FindBy(xpath = "//div[@class='clearfix']/h3")
    public WebElement header;

    @FindBy(xpath = "//div[@class='clearfix']//p[1]")
    public WebElement pinBarText;

    @FindBy(xpath = "//img[@src='/bundles/oronavigation/images/pinbar-location.jpg']")
    public WebElement pinBarImage;

}
