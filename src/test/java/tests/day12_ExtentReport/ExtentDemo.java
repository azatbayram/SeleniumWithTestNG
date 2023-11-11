package tests.day12_ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

public class ExtentDemo {

    //this class is used starting for nad building report
    ExtentReports report;

    //this class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;

    //this class will define a test, enable adding logs, autors, test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        //initialize the class
        report = new ExtentReports();

        //create report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        //initialize the html report with path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report with the report path
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Vytruck smoke test");

        //set environment information
        report.setSystemInfo("Enviroment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));

    }

    @AfterMethod
    public void tearDown(){
        //this is actually when report created
        report.flush();
    }

    @Test
    public void test(){
        //give name the current test
        extentLogger = report.createTest("TC123 Login as Driver");

        //test steps
        extentLogger.info("Open chrome browser");
        extentLogger.info("Go to the URL");
        extentLogger.info("Enter driver username and password");
        extentLogger.info("click login");
        extentLogger.info("verify logged in");
        //pass() --> marks the test case as passed
        extentLogger.pass("TC123 is passed");
    }


}
