package com.cydeo.tests.day11_pom_explicitWaits;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class T1_to_T6_Actions_Practice {
    @BeforeMethod
    public void setup(){
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }

    @Test

    public void test2_default_value_verification() {

        //2. Verify big circle default text is as below.
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        //3. Assert:
        //-Text in big circle changed to: “Drag the small circle here.”
        String expectedText = "Drag the small circle here.";
        String actualText = bigCircle.getText();
        assertTrue(actualText.equals(expectedText));

    }
    @Test
    public void test3_drop_into_the_big_circle(){
        //TC3 #: Drag and drop into the big circle
        //Locating circle WebElement
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        //Creating the Actions object
        Actions actions=new Actions(Driver.getDriver());

        //2. Drag and drop the small circle to bigger circle.
        //actions.dragAndDrop(smallCircle,bigCircle).perform();
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(bigCircle)
                .pause(1000)
                .release()
                .perform();


        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String expectedText = "You did great!";
        String actualText = bigCircle.getText();
        assertTrue(actualText.equals(expectedText));
    }
    @Test
    public void test4_click_hold(){
        //TC4 #: Click and hold
        //2. Click and hold the small circle.
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        //Creating the Actions object
        Actions actions=new Actions(Driver.getDriver());

        //2. Drag and drop the small circle to bigger circle.
        //actions.dragAndDrop(smallCircle,bigCircle).perform();
        WebElement cydeoLink=Driver.getDriver().findElement(By.linkText("CYDEO"));
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(cydeoLink)
                .pause(1000)
                .perform();


        //3. Assert:
        //-Text in big circle changed to: “Drop here.”
        String expectedText = "Drop here.";
        String actualText = bigCircle.getText();
        assertTrue(actualText.equals(expectedText));

    }
    @Test
    public void test5_drag_drop_outside(){
        //TC5 #: Drag and drop outside-of the big circle
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        //Creating the Actions object
        Actions actions=new Actions(Driver.getDriver());

        //2. Drag and drop the small circle to bigger circle.
        WebElement cydeoLink=Driver.getDriver().findElement(By.linkText("CYDEO"));
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(cydeoLink)
                .pause(1000)
                .release()
                .perform();

        //3. Assert:
        //-Text in big circle changed to: “Try again!”
        String expectedText = "Try again!";
        String actualText = bigCircle.getText();
        assertTrue(actualText.equals(expectedText));
    }
    @Test
    public void test6_drag_hover(){
        //TC6 #: Drag and hover
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        //Creating the Actions object
        Actions actions=new Actions(Driver.getDriver());
        //2. Drag the small circle on top of the big circle, hold it, and verify.
        WebElement cydeoLink=Driver.getDriver().findElement(By.linkText("CYDEO"));
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(bigCircle)
                .pause(1000)
                .perform();
        //3. Assert:
        //-Text in big circle changed to: “Now drop...”
        String expectedText = "Now drop...";
        String actualText = bigCircle.getText();
        assertTrue(actualText.equals(expectedText));
    }

}
