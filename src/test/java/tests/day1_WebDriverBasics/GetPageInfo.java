package tests.day1_WebDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetPageInfo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://practice.cydeo.com/");

        String pageTitle=driver.getTitle();
        String pageUrl= driver.getCurrentUrl();
        String pageSource= driver.getPageSource();

        System.out.println("pageTitle = " + pageTitle);
        System.out.println("pageUrl = " + pageUrl);
        System.out.println("pageSource = " + pageSource);

        driver.quit();
    }
}
