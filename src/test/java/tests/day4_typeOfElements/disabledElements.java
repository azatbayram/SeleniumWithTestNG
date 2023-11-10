package tests.day4_typeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class disabledElements {

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
    public void test1(){
        driver.get("https://practice.cydeo.com/radio_buttons");
        WebElement greenButton = driver.findElement(By.cssSelector("#green"));

        System.out.println("greenButton.isEnabled() = " + greenButton.isEnabled());
        Assert.assertFalse(greenButton.isEnabled(), "Verify that green button is enabled");
        greenButton.click();
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://practice.cydeo.com/dynamic_controls");

        WebElement enableButton = driver.findElement(By.xpath("//button[@onclick = 'swapInput()']"));
        WebElement inputBox = driver.findElement(By.xpath("//input[@type = 'text']"));

        enableButton.click();
        Thread.sleep(3000);
        inputBox.sendKeys("Azat was here");
        System.out.println(inputBox.getAttribute("value"));
    }




}
