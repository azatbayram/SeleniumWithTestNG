package tests.day13_DDF;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.TestBase;
import tests.pages.DashboardPage;
import tests.pages.LoginPage;
import utilities.ExcelUtil;

public class DDFLoginTest extends TestBase {

    @DataProvider
    public Object[][] userData(){

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA3-short");

        String [][] dataArray = qa3short.getDataArrayWithoutFirstRow();

        //System.out.println(Arrays.deepToString(dataArray));

        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void loginWithDataProvider(String username, String password, String firstName, String lastName){
        extentLogger= report.createTest("Test "+firstName+" "+lastName);
        LoginPage loginPage=new LoginPage();

        loginPage.login(username, password);

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullName=dashboardPage.getUserName();
        String expectedFullName=firstName+" "+lastName;

        Assert.assertEquals(actualFullName, expectedFullName,"verify full name is matching");
        extentLogger.pass("PASS");
    }

}
