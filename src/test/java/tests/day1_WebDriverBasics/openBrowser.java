package tests.day1_WebDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class openBrowser {

    public static void main(String[] args) throws InterruptedException {

        // this line make chrome get ready for automation
        WebDriverManager.chromedriver().setup();

        //create chrome driver
        //each driver represents one chrome browser
        WebDriver driver=new ChromeDriver();
        //WebDriver driver=new SafariDriver();

        driver.get("https://www.facebook.com/");

        Thread.sleep(3000);

        driver.get("https://www.google.com/maps");

        driver.quit();
    }
}
