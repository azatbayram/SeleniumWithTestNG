package tests.day2_WebElementBasics_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class xPathLocator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cydeo.com/multiple_buttons");

        WebElement button1= driver.findElement(By.xpath("//button[@onclick='button1()']"));
        //button1.click();

        WebElement button2=driver.findElement(By.xpath("//button[@name='button2']"));
        //button2.click();

        WebElement button3= driver.findElement(By.xpath("//button[@id='button_three']"));
        button3.click();

        Thread.sleep(3000);
        driver.quit();


    }
}
