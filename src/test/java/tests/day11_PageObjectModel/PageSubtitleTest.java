package tests.day11_PageObjectModel;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.TestBase;
import tests.pages.CalendarEventsPage;
import tests.pages.DashboardPage;
import tests.pages.LoginPage;
import utilities.ConfigurationReader;

public class PageSubtitleTest extends TestBase {

    /**
     * Test case
     * Open Chrome browser
     * Login as a Driver
     * Verify that page subtitle is Quick Launchpad
     * Go to Activities -> Calendar Events
     * verify that page subtitle is Calendar Events
     */

    @Test
    public void test(){

        LoginPage loginPage=new LoginPage();

        loginPage.loginAsDriver();

        String expectedSubtitle="Quick Launchpad";
        DashboardPage dashboardPage=new DashboardPage();
        String actualSubtitle=dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle, expectedSubtitle);

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        String expected="Calendar Events";
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),expected);



    }
}
