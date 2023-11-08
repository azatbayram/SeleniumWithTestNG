package tests.day3_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1() {
        System.out.println("First Assertion");
        Assert.assertEquals("title", "tiTle");
        System.out.println("Second Assertion");
        Assert.assertEquals("url", "url");
    }

    @Test
    public void test2() {
        Assert.assertEquals(15, 15);
    }

    @Test
    public void test3() {
        String expectedTitle="Cyb";
        String actualTitle="Cybertek";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify title starts with Cyb");
    }

    @Test
    public void test4() {
        //verify email contains @ sign
        String email="azat@gmail.com";

        Assert.assertTrue(email.contains("@"),"Verify email cointains @");

    }

    @Test
    public void test5() {
        Assert.assertFalse(0>1, "Verify that 0 is not greater than 1");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("WebDriver, Open browser");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Close browser, quit");
    }
}
