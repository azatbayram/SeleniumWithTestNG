package tests.day4_typeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class CheckBoxDemo {

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
        driver.get("https://practice.cydeo.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.cssSelector("input[name='checkbox1']"));
        WebElement checkBox2 = driver.findElement(By.cssSelector("input[name='checkbox2']"));

        Assert.assertFalse(checkBox1.isSelected(), "Verify checkbox 1 is not selected");
        Assert.assertTrue(checkBox2.isSelected(), "Verify checkbox 2 is selected");

        checkBox1.click();

        Assert.assertTrue(checkBox1.isSelected(), "Verify checkbox 1 is selected");
        Assert.assertTrue(checkBox2.isSelected(), "Verify checkbox 2 is selected");


    }
}
