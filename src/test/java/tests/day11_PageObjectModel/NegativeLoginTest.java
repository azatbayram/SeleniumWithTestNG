package tests.day11_PageObjectModel;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestBase;
import tests.pages.LoginPage;
import utilities.ConfigurationReader;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login");

    }

    @Test
    public void wrongUsernameTest(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("usserf");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login");

    }
}
