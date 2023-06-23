package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_UpLoad_Practice {
    //TC #2 Upload Test
    //1. Go to https://practice.cydeo.com/upload
    //2. Find some small file from your computer, and get the path of it.
    //3. Upload the file.
    //4. Assert:
    //-File uploaded text is displayed on the page
    @Test
    public void uploading_test(){

        Driver.getDriver().get("https://practice.cydeo.com/upload");
        //Path copy  and paste
        String path="C:\\Users\\User\\OneDrive\\Desktop\\Neuer Ordner\\Microsoft Word-Dokument (neu).docx";
        //Use sendKeys() method and send path

        WebElement chooseFileButton=Driver.getDriver().findElement(By.id("file-upload"));
        BrowserUtils.sleep(2);
        chooseFileButton.sendKeys(path);

        WebElement uploadButton=Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement fileUploadedHeader=Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadedHeader.isDisplayed(),"Header text is not displayed");

        Driver.closeDriver();

    }
}
