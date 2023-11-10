package tests.day7_actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class JavaScriptExecutor {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void clickWithJS(){

        driver.get("http://practice.cydeo.com/");

        WebElement dropdownLink= driver.findElement(By.linkText("Dropdown"));

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",dropdownLink);

    }

    @Test
    public void typeWithJS(){
        driver.get("http://practice.cydeo.com/dynamic_controls");
        WebElement inputBox= driver.findElement(By.cssSelector("input[type='text']"));

        JavascriptExecutor js=(JavascriptExecutor) driver;
        String text="Hello Disabled Input";
        js.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);
    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cydeo.com/infinite_scroll");

        JavascriptExecutor js=(JavascriptExecutor) driver;

        for (int i=0; i<10;i++){
            Thread.sleep(3000);
            js.executeScript("window.scrollBy(0,250)");
        }

        for (int i=0; i<10;i++){
            Thread.sleep(3000);
            js.executeScript("window.scrollBy(0,-250)");
        }

    }

    @Test
    public void scrollElement() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");
        WebElement contact= driver.findElement(By.linkText("İletişim"));

        JavascriptExecutor js=(JavascriptExecutor) driver;
        driver.findElement(By.id("sp-cc-accept")).click();
        Thread.sleep(2000);

        js.executeScript("arguments[0].scrollIntoView(true);",contact);

    }
}
