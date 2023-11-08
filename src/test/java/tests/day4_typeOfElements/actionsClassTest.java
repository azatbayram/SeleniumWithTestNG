package tests.day4_typeOfElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
        Thread.sleep(3000);

        WebElement dragTarget= driver.findElement(By.cssSelector("div#draggable"));
        WebElement dropTarget=driver.findElement(By.cssSelector("div#droptarget"));

        actions.dragAndDrop(dragTarget, dropTarget).perform();

    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("https://practice.cydeo.com/hovers");
        Thread.sleep(2000);

        WebElement img1 = driver.findElement(By.cssSelector("div.figure:nth-of-type(1)"));
        WebElement img2 = driver.findElement(By.cssSelector("div.figure:nth-of-type(2)"));
        WebElement img3 = driver.findElement(By.cssSelector("div.figure:nth-of-type(3)"));
        WebElement prof1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement prof2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement prof3 = driver.findElement(By.xpath("//h5[text()='name: user3']"));

        actions.moveToElement(img1).perform();
        Assert.assertTrue(prof1.isDisplayed(), "Verify that profile 1 is displayed");
        Thread.sleep(2000);

        actions.moveToElement(img2).perform();
        Assert.assertTrue(prof2.isDisplayed(), "Verify that profile 1 is displayed");
        Thread.sleep(2000);

        actions.moveToElement(img3).perform();
        Assert.assertTrue(prof3.isDisplayed(), "Verify that profile 1 is displayed");
    }

    @Test
    public void dragAndDropChaining() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Thread.sleep(4000);

        WebElement dragTarget= driver.findElement(By.cssSelector("div#draggable"));
        WebElement dropTarget=driver.findElement(By.cssSelector("div#droptarget"));

        actions.moveToElement(dragTarget).clickAndHold().moveToElement(dropTarget).release().perform();
    }




}
