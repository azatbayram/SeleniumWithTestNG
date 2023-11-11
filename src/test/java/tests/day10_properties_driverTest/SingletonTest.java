package tests.day10_properties_driverTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.Driver;

public class SingletonTest {

    @Test
    public void test1(){
        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }

    @Test
    public void test2(){
        WebDriver driver = Driver.get();
        driver.get("https://google.com");

        Driver.closeDriver();
    }
}
