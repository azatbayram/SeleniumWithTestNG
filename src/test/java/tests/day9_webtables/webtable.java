package tests.day9_webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class webtable {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void printTable(){
        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(table.getText());

        String name = "Ned Stark";
        Assert.assertTrue(table.getText().contains(name));
    }

    @Test
    public void getAllHeaders(){

        List<WebElement> headers = driver.findElements(By.cssSelector("tbody tr th"));
        System.out.println(headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

        //number of rows with headers
        List<WebElement> rowsWithHeader = driver.findElements(By.xpath("//table[@class = 'SampleTable']/tbody/tr"));
        System.out.println(rowsWithHeader.size());

        //number of rows without header
        List<WebElement> rowsWithoutHeader = driver.findElements(By.xpath("//table[@class = 'SampleTable']/tbody/tr"));
        rowsWithoutHeader.remove(0);
        System.out.println(rowsWithoutHeader.size());

    }

    @Test
    public void getRow(){
        WebElement row2 = driver.findElement(By.xpath("(//table[@class = 'SampleTable']/tbody/tr)[3]"));
        System.out.println(row2.getText());

        List<WebElement> numRows = driver.findElements(By.xpath("//table[@class = 'SampleTable']/tbody/tr"));


        for (int i=1; i<numRows.size(); i++){
            System.out.println(i + " " + numRows.get(i).getText());
        }

    }

    @Test
    public void getAllCellInOneRow(){
        List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("(//table[@class = 'SampleTable']/tbody/tr)[3]/td"));

        for (WebElement oneCell: allCellsInOneRow) {
            System.out.println(oneCell.getText());
        }
    }

    @Test
    public void getSingleCell(){
        WebElement singleCell = driver.findElement(By.xpath("((//table[@class = 'SampleTable']/tbody/tr)[3]/td)[6]"));
        System.out.println(singleCell.getText());
    }

    @Test
    public void printAllCellsByIndex(){
        int numColumns = getNumberOfColumns();
        int numRows = getNumberOfRows();

        List<WebElement> headers = driver.findElements(By.cssSelector("tbody tr th"));
        headers.remove(0);

        for (WebElement header : headers) {
            System.out.print(header.getText() + " | ");
        }
        System.out.println();

        for (int i=2; i<=numRows; i++){
            for (int j=2; j<=numColumns; j++){
                WebElement oneCell = driver.findElement(By.xpath("((//table[@class = 'SampleTable']/tbody/tr)["+i+"]/td)["+j+"]"));
                System.out.print(oneCell.getText() + " | ");
            }
            System.out.println();
        }
    }

    private int getNumberOfColumns(){
        List<WebElement> headers = driver.findElements(By.cssSelector("tbody tr th"));
        return headers.size();
    }

    private int getNumberOfRows(){
        List<WebElement> rowsWithHeader = driver.findElements(By.xpath("//table[@class = 'SampleTable']/tbody/tr"));
        return rowsWithHeader.size();
    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow(){
        String name = "John Doe";
        String xPath = "(//table[@class = 'SampleTable']/tbody/tr/td)[.='"+ name +"']/../td[6]";
        WebElement address = driver.findElement(By.xpath(xPath));
        System.out.println(address.getText());
    }


}
