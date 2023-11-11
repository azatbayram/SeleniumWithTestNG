package tests.day12_ExtentReport;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestBase;
import tests.pages.LoginPage;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPassword(){
        extentLogger = report.createTest("Wrong Password Test");

        extentLogger.info("Open browser and go to URL");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter username: user1");
        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter password: somepassword");
        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Click login button");
        loginPage.loginButton.click();
        extentLogger.info("verify page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
        extentLogger.pass("Wrong Password test is passed");
    }

    @Test
    public void wrongUsernameTest(){
        //name of the test
        extentLogger= report.createTest("Wrong Username Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter username: someusername");
        loginPage.usernameInput.sendKeys("someusername");
        extentLogger.info("Enter password: UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Click login button");
        loginPage.loginButton.click();

        extentLogger.info("Verify page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
        extentLogger.pass("Wrong username test is passed");

    }
}
