package tests.day3_testNG;

import org.testng.annotations.*;

public class BeforeAfterMethods {

    @BeforeClass
    public void setUpClass(){
        System.out.println("Before Class");
        System.out.println("Execute one time before class");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("After Class");
        System.out.println("Some reporting code here");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("WebDriver, open browser");
    }

    @AfterMethod
    public void taerDown(){
        System.out.println("Close browser, quit");
    }

    @Test
    public void test1(){
        System.out.println("First test case");
    }

    @Test
    public void test2(){
        System.out.println("Second test case");
    }

    @Test
    public void test3(){
        System.out.println("Third test case");
    }
}
