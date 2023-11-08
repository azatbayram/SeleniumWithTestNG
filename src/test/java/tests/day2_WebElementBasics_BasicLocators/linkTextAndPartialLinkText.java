package tests.day2_WebElementBasics_BasicLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class linkTextAndPartialLinkText {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/dynamic_loading");

        WebElement link1= driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        //link1.click();

        WebElement link4= driver.findElement(By.partialLinkText("Example 4"));
        link4.click();

        Thread.sleep(3000);
        driver.quit();
    }
}
