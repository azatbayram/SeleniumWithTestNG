package tests.day10_properties_driverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import tests.TestBase;
import utilities.ConfigurationReader;

public class LoginTest extends TestBase {

    @Test
    public void login(){
        driver.get(ConfigurationReader.get("url"));

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password + Keys.ENTER);
    }
}
