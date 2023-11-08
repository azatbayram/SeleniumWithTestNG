package tests.day1_WebDriverBasics;

import org.openqa.selenium.WebDriver;
import utilities.WebDriverFactory;

public class CallWebDriverFactory {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/");
        Thread.sleep(3000);
        driver.quit();
    }
}
