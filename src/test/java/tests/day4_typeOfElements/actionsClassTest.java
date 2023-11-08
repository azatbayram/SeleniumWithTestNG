package tests.day4_typeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class actionsClassTest {

    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void dragAndDrop() throws InterruptedException {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Thread.sleep(2000);

        WebElement dragTarget= driver.findElement(By.cssSelector("div#draggable"));
        WebElement dropTarget=driver.findElement(By.cssSelector("div#droptarget"));

        actions.dragAndDrop(dragTarget, dropTarget).perform();

    }




}
