package tests.day10_properties_driverTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class propertiesTest {

    @Test
    public void test1(){
        String browser = ConfigurationReader.get("browser");
        System.out.println("browser = " + browser);

        String url = ConfigurationReader.get("url");
        System.out.println("url = " + url);
    }

    @Test
    public void openBrowserWithConf() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password + Keys.ENTER);

        Thread.sleep(3000);
        driver.quit();
    }
}
