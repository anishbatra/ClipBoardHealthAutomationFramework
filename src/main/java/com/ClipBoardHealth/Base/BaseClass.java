package com.ClipBoardHealth.Base;

import com.ClipBoardHealth.Data.InputData;
import com.ClipBoardHealth.utilities.DriverSetUp;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class BaseClass extends DriverSetUp {


    public InputData inputData = new InputData();
    DriverSetUp driverSetUp = new DriverSetUp();


    //public static Logger logger;
    public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
            + "/src/main/java/com/ClipBoardHealth/testdata/DataProvider.xlsx";
    public static ExtentTest extentTest;
    public static ExtentReports extent;


    @BeforeClass
    public void setUp() throws MalformedURLException {

        logger = LogManager.getLogger(this.getClass());
        driverSetUp.setUp(inputData.browser, inputData.runType);

    }

    @AfterClass
    public void tearDown() {
        driverSetUp.tearDown();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }


}
