package com.ClipBoardHealth.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLUtils {
    public static Workbook book;
    public static Sheet sheet;


    public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
            + "/src/main/java/com/ClipBoardHealth/testdata/DataProvider.xlsx";

    public static Object[][] getTestData(String sheetName) throws IOException {

        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        book = new XSSFWorkbook(file);
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();

            }
        }
        return data;
    }


}
