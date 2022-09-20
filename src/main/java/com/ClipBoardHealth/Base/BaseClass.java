package com.ClipBoardHealth.Base;

import com.ClipBoardHealth.Data.InputData;
import com.ClipBoardHealth.utilities.DriverSetUp;
import org.apache.log4j.LogManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class BaseClass extends DriverSetUp {


    public InputData inputData = new InputData();
    DriverSetUp driverSetUp = new DriverSetUp();

    @BeforeClass
    public void setUp() throws MalformedURLException {

        logger = LogManager.getLogger(this.getClass());
        driverSetUp.setUp(inputData.browser, inputData.runType);

    }

    @AfterClass
    public void tearDown() {
        driverSetUp.tearDown();
    }


}
