package tests.day9_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class webtable {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void printTable(){
        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(table.getText());

        String name = "Ned Stark";
        Assert.assertTrue(table.getText().contains(name));
    }

    @Test
    public void getAllHeaders(){

        List<WebElement> headers = driver.findElements(By.cssSelector("tbody tr th"));
        System.out.println(headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

        //number of rows with headers
        List<WebElement> rowsWithHeader = driver.findElements(By.cssSelector("tbody tr"));
        System.out.println(rowsWithHeader.size());

        //number of rows without header
        List<WebElement> rowsWithoutHeader = driver.findElements(By.cssSelector("tbody tr"));
        rowsWithoutHeader.remove(0);
        System.out.println(rowsWithoutHeader.size());

    }
}
