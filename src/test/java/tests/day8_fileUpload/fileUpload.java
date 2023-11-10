package tests.day8_fileUpload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class fileUpload {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice.cydeo.com/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        WebElement upload = driver.findElement(By.id("file-submit"));

        chooseFile.sendKeys(System.getProperty("user.dir") + "/src/test/resources/textfile.txt");
        Thread.sleep(2000);
        upload.click();

        String expectedFileName="textfile.txt";
        String actualFileName=driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualFileName,expectedFileName,"Verify uploaded file is true");
    }
}
