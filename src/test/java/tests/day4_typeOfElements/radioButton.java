package tests.day4_typeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class radioButton {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test(){

        driver.get("https://practice.cydeo.com/radio_buttons");

        //locating radio buttons
        WebElement blueRadioButton=driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioButton=driver.findElement(By.cssSelector("#red"));

        //how to check radio button is selected?
        System.out.println("blueRadioButton.isSelected() = " + blueRadioButton.isSelected());
        System.out.println("redRadioButton.isSelected() = " + redRadioButton.isSelected());

        //Verify blue is selected red is not selected
        Assert.assertTrue(blueRadioButton.isSelected(),"Verify that blue is selected");
        Assert.assertFalse(redRadioButton.isSelected(),"Verify that red is not selected");

        //how to click radio button
        redRadioButton.click();

        Assert.assertFalse(blueRadioButton.isSelected(),"Verify that blue is not selected");
        Assert.assertTrue(redRadioButton.isSelected(),"Verify that red is selected");

    }
}
