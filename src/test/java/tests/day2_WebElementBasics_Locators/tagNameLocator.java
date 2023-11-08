package tests.day2_WebElementBasics_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class tagNameLocator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/sign_up");

        WebElement fullNAmeInbox = driver.findElement(By.tagName("input"));
        WebElement emailInbox = driver.findElement(By.name("email"));
        WebElement signUpButton = driver.findElement(By.tagName("button"));

        fullNAmeInbox.sendKeys("Azat Bayram");
        emailInbox.sendKeys("example@gmail.com");
        System.out.println(fullNAmeInbox.getAttribute("value"));
        System.out.println(emailInbox.getAttribute("value"));
        signUpButton.click();

        Thread.sleep(3000);
        driver.quit();
    }
}
