package tests.day4_typeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class attributeTest {

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
    public void test(){
        driver.get("https://practice.cydeo.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.cssSelector("#blue"));

        //get the value of type attribute
        System.out.println(blueRadioButton.getAttribute("type"));

        //get the value of name attribute
        System.out.println(blueRadioButton.getAttribute("name"));

        //get the value of checked attribute
        //since checked attribute does not keep any value, it will return true or false based on the condition
        System.out.println(blueRadioButton.getAttribute("checked"));

        //trying to get attribute that does not exist
        //when we use non exist attribute it will return null to us
        System.out.println(blueRadioButton.getAttribute("href"));
    }

}
