package tests.day5_popups_tabs_frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;
import java.util.Set;

public class multipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/windows");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void switchWindows(){

        System.out.println("Title before new window: " + driver.getTitle() );

        driver.findElement(By.linkText("Click Here")).click();

        String currentWindowHandle = driver.getWindowHandle();
        System.out.println("currentWindowHandle = " + currentWindowHandle);
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles.toString());

        for (String handle: windowHandles) {
            if (!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }

        System.out.println(driver.getWindowHandle());
    }

    @Test
    public void test2() throws InterruptedException {

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("Before Switch: " + driver.getTitle());
        Set<String> windowHandles = driver.getWindowHandles();

        //loop through each window
        for (String handle : windowHandles) {
            //one by one change it
            driver.switchTo().window(handle);
            Thread.sleep(2000);
            //whenever your title equals to your expected window title
            if (driver.getTitle().equals("New Window")) {
                //stop on that window
                break;
            }

        }

        System.out.println("After Switch: " + driver.getTitle());
    }
}
