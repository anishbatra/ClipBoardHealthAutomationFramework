package com.ClipBoardHealth.Base;

import com.ClipBoardHealth.Data.InputData;
import com.ClipBoardHealth.utilities.DriverSetUp;
import com.ClipBoardHealth.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class BaseClass {



    InputData inputData = new InputData();
    DriverSetUp driverSetUp = new DriverSetUp();


    public static WebDriver driver;



    @BeforeClass
    public void setUp() throws MalformedURLException {


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
