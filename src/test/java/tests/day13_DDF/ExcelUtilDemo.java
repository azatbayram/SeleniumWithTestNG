package tests.day13_DDF;

import org.testng.annotations.Test;
import utilities.ExcelUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilDemo {

    @Test
    public void readExcelFile(){
        //Create an object from ExcelUtil
        //it accepts two arguments
        //argument 1: location of the file(path)
        //argument 2: sheet that we want to open(sheet name)

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA3-short");

        //how many rows in the sheet
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());

        //how many columns in the sheet
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        //get all column names
        System.out.println("qa3short.getColumnsNames().toString() = " + qa3short.getColumnsNames().toString());

        //get all the data list of map
        List<Map<String, String>> dataList = qa3short.getDataList();
        for (Map<String, String> map: dataList) {
            System.out.println(map.toString());
        }

        //get Nona as value
        System.out.println(dataList.get(2).get("firstname"));

        //get Haber
        System.out.println(dataList.get(8).get("lastname"));

        //get all data in 2nd array
        String [][] dataArray= qa3short.getDataArray();

        //print 2nd array
        System.out.println(Arrays.deepToString(dataArray));


    }
}
