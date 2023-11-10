package tests.day4_typeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class displayedDemo {

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
    public void test1() throws InterruptedException {
        driver.get("https://practice.cydeo.com/dynamic_loading/1");

        WebElement startButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
        WebElement usernameBox = driver.findElement(By.id("username"));

        Assert.assertFalse(usernameBox.isDisplayed(), "Verify that username box is displayed");
        System.out.println("usernameBox.isDisplayed() = " + usernameBox.isDisplayed());

        startButton.click();
        Thread.sleep(5000);

        Assert.assertTrue(usernameBox.isDisplayed(), "Verify that username box is displayed");
        System.out.println("usernameBox.isDisplayed() = " + usernameBox.isDisplayed());

        usernameBox.sendKeys("Azat Bayram");

    }
}
