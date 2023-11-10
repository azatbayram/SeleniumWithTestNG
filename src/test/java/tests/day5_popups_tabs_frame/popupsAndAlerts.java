package tests.day5_popups_tabs_frame;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class popupsAndAlerts {

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
        driver.get("https://practice.cydeo.com/javascript_alerts");

        //click for JS alerts button
        driver.findElement(By.cssSelector("button[onclick = 'jsAlert()']")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.findElement(By.cssSelector("button[onclick = 'jsConfirm()']")).click();
        Thread.sleep(3000);
        alert.dismiss();

        driver.findElement(By.cssSelector("button[onclick = 'jsPrompt()']")).click();
        alert.sendKeys("Azat");
        Thread.sleep(3000);
        alert.accept();
    }
}
