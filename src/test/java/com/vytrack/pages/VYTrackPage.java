package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;

public class VYTrackPage {

    public VYTrackPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
