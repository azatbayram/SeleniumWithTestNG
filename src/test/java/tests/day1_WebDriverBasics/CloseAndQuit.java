package tests.day1_WebDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.navigate().to("https://practice.cydeo.com/");

        Thread.sleep(3000);

        //close(); --> method close current tab
        driver.close();

        //giving new browser tab
        driver=new ChromeDriver();

        driver.get("https://practice.cydeo.com/");

        Thread.sleep(3000);
        //quit(); --> method close all tabs
        driver.quit();
    }
}
