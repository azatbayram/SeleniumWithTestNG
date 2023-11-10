package tests.day6_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.Duration;


public class ExplicitWait {

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
        driver.get("https://practice.cydeo.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement userInput=driver.findElement(By.id("username"));
        wait.until(ExpectedConditions.visibilityOf(userInput));
        userInput.sendKeys("Azat Bayram");

    }
}
