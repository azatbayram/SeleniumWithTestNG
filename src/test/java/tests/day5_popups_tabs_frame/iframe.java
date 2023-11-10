package tests.day5_popups_tabs_frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class iframe {

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
        driver.get("https://practice.cydeo.com/iframe");

        //how to switch frame
        //1. switch by using name or id attribute of frame
        driver.switchTo().frame("mce_0_ifr");
        Thread.sleep(2000);

        //clear before sendKeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Azat Bayram");

        //go back to main HTML
        //useful when we have multiple frame
        driver.switchTo().defaultContent();

        //2. switch with index
        driver.switchTo().frame(0);
        Thread.sleep(2000);

        //clear before sendKeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Azat Bayram with index");

        //second way switch frame back
        driver.switchTo().parentFrame();

        //3. switch with webelement
        //locating iframe with any valid iframe
        WebElement iframeElement= driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);
        Thread.sleep(2000);

        //clear before sendKeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Azat Bayram with WebElement");
    }

    @Test
    public void nestedIframe(){
        driver.get("https://practice.cydeo.com/nested_frames");

        //switch to frame-top
        driver.switchTo().frame("frame-top");
        //top has 3 frames under left, middle, and right
        //switch to frame middle
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        //goes to top frame
        driver.switchTo().parentFrame();
        //switch to right frame
        driver.switchTo().frame(2);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        //goes to top frame
        driver.switchTo().parentFrame();
        //switch to left frame
        driver.switchTo().frame(0);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        //goes main html
        driver.switchTo().defaultContent();

        //switch to bottom frame
        driver.switchTo().frame("frame-bottom");

        System.out.println(driver.findElement(By.tagName("body")).getText());

    }
}
