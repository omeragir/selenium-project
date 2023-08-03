package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class VehicleOdometerPage {

    @FindBy(css = "span.title-level-1")
    public List<WebElement> menuOptions;

    @FindBy(xpath = "//div[@class='message' and contains(text(), 'You do not have permission to perform this action.')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[contains(@class, 'alert-error')]")
    public WebElement warningMessage;

    @FindBy(xpath = "//div[contains(@class, 'alert-error')]/button")
    public WebElement closeButtonWarningMessage;

    @FindBy(css = "div[class='loader-mask shown']")
    public WebElement loaderMask;

    @FindBy(css = "input.input-widget[type='number']")
    public WebElement pageNumberInput;

    @FindBy(xpath = "//button[normalize-space()='25']")
    public WebElement getPageNumberInput1;

    public VehicleOdometerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public int getCurrentPageNumber() {
        String currentPageNumberText = pageNumberInput.getAttribute("value");
        return Integer.parseInt(currentPageNumberText);
    }

    public int getCurrentPageNumber1() {
        Integer currentPageNumberText1 = Integer.valueOf(getPageNumberInput1.getText());
        return Integer.parseInt(String.valueOf(currentPageNumberText1));
    }

    public boolean isErrorMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.isDisplayed();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();

    }

    public boolean isWarningMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2));
        return wait.until(ExpectedConditions.visibilityOf(warningMessage)).isDisplayed();
    }

    public void closeWarningMessage() {
        closeButtonWarningMessage.click();
    }

    public void waitUntilLoaderScreenDisappear() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }

}
