package tests.day4_typeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;

public class ListOfElements {

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
    public void test1(){
        driver.get("https://practice.cydeo.com/multiple_buttons");

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("buttons.size() = " + buttons.size());

        Assert.assertEquals(buttons.size(), 6);

        for (WebElement button : buttons){
            System.out.println("button.getText() = " + button.getText());
        }

        buttons.get(5).click();
    }

    @Test
    public void test2() {

        driver.get("https://practice.cydeo.com/multiple_buttons");
        //passing locator which is not exist, it will not throw NoSuchElement
        List<WebElement> buttons = driver.findElements(By.tagName("butvfdvfb"));

        System.out.println("buttons.size() = " + buttons.size());

    }
}
