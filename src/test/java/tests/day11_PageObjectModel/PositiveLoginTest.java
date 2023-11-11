package tests.day11_PageObjectModel;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestBase;
import tests.pages.LoginPage;
import utilities.ConfigurationReader;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsDriver(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/");
    }

}
