package tests.day2_WebElementBasics_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class CSSLocator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cydeo.com/multiple_buttons");

        WebElement dontClickButton = driver.findElement(By.cssSelector("#disappearing_button"));
        dontClickButton.click();

        Thread.sleep(3000);
        driver.quit();
    }
}
