package com.cydeo.tests.review.week4;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Guru99_Upload_Test {


    @Test
    public void guru99_upload_test() {

        // TC: Guru99 Upload Test
        //1. Go to  “https://demo.guru99.com/test/upload”
        Driver.getDriver().get("https://demo.guru99.com/test/upload");

        //Cookies-iframe
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//*[@id='gdpr-consent-notice']")));
        WebElement acceptAll = Driver.getDriver().findElement(By.xpath("//button[@id='save']"));
        acceptAll.click();

        // back to the main html/frame
        Driver.getDriver().switchTo().defaultContent();
        /*
          WebElement acceptAllButton = privacyBanner.findElement(By.cssSelector("a[id='cookie_action_close_header'][data-cookie-set='acceptAll']")).click();
         */

        /*
         //Find some small file from your computer, and get the path of it.
        File file = new File("/Users/i.etga/Desktop/UploadPractice.txt");
        Assert.assertTrue(file.exists());
         */

        //2. Upload file into Choose File
        WebElement chooseFile = Driver.getDriver().findElement(By.xpath("//input[@id='uploadfile_0']"));
        chooseFile.sendKeys("C:\\Users\\User\\OneDrive\\Desktop\\Neuer Ordner\\Microsoft Word-Dokument (neu).docx");

        //3. Click terms of service check box
        Driver.getDriver().findElement(By.id("terms")).click();

        //4. Click Submit File button
        Driver.getDriver().findElement(By.cssSelector("button#submitbutton")).click();

        BrowserUtils.sleep(3);

        //5. Verify expected message appeared.
        // Expected: “1 file
        // has been successfully uploaded.
        WebElement resultMsg = Driver.getDriver().findElement(By.xpath("//center[.='1 file has been successfully uploaded.']"));

        String actualMsg = resultMsg.getText();
        String expectedMsg = "1 file\nhas been successfully uploaded.";

        BrowserUtils.sleep(3);

        Assert.assertEquals(actualMsg, expectedMsg, "Result Message verification failed!");

        Driver.closeDriver();

    }
}