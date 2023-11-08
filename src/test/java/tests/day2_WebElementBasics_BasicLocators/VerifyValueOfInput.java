package tests.day2_WebElementBasics_BasicLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class VerifyValueOfInput {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/forgot_password");

        WebElement emailInputbox = driver.findElement(By.name("email"));

        String expectedEmail = "example@gmail.com";
        emailInputbox.sendKeys(expectedEmail);

        String actualEmail = emailInputbox.getAttribute("value");

        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
            System.out.println("expectedEmail = " + expectedEmail);
            System.out.println("actualEmail = " + actualEmail);
        }
        else {
            System.out.println("FAIL");
            System.out.println("expectedEmail = " + expectedEmail);
            System.out.println("actualEmail = " + actualEmail);
        }

        driver.quit();

    }
}
