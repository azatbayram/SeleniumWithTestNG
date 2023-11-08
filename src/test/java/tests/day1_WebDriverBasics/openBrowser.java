package tests.day1_WebDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openBrowser {

    public static void main(String[] args) throws InterruptedException {

        // this line make chrome get ready for automation
        WebDriverManager.chromedriver().setup();

        //create chrome driver
        //each driver represents one chrome browser
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.facebook.com/");

        driver.get("https://www.google.com/maps");

        driver.quit();
    }
}
