package tests.day2_WebElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class VerifyURLChanged {

    /*
        Verify URL changed
        open chrome browser
        go to https://practice.cydeo.com/forgot_password Links to an external site.
        enter any email
        click on Retrieve password
        verify that url changed to https://practice.cydeo.com/email_sent
*/
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/forgot_password");

        WebElement emailInputbox = driver.findElement(By.name("email"));
        WebElement button = driver.findElement(By.id("form_submit"));

        emailInputbox.sendKeys("example@gmail.com");
        Thread.sleep(3000);
        button.click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://practice.cydeo.com/email_sent";

        if (actualURL.equals(expectedURL)){
            System.out.println("PASS");
            System.out.println("expectedURL = " + expectedURL);
            System.out.println("actualURL = " + actualURL);
        }
        else{
            System.out.println("FAIL");
            System.out.println("expectedURL = " + expectedURL);
            System.out.println("actualURL = " + actualURL);
        }

        driver.quit();

    }
}
